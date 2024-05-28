import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.ConcurrentSkipListMap;

public class RateLimitService {
    private static final long MILLIS_IN_SECOND = 1000;
    private static final long MILLIS_IN_MIUTE = 60000;
    private static final long MILLIS_IN_HOUR = 3600000;
    private static final long MILLIS_IN_DAY = 86400000;

    private static final int RATE_LIMIT_PER_MIN = 3;

    private static final int RATE_LIMIT_PER_HOUR = 10;
    private static Map<Long, ConcurrentSkipListMap<Long, Integer>> limitMap = new HashMap<Long, ConcurrentSkipListMap<Long, Integer>>();
    private static Map<Long, Integer> requestCounterHourly = new HashMap<Long, Integer>();

    public static void main(String[] args) {

        RateLimitService rls = new RateLimitService();
        rls.test();
    }

    private void test() {

        System.out.println("=============================");
        System.out.println(String.format("Max reqs in minute: %d | Max reqs in hour: %d", RATE_LIMIT_PER_MIN, RATE_LIMIT_PER_HOUR));
        System.out.println("=============================");

        Long userId = 1L;
        refreshMinuteSlots(userId, System.currentTimeMillis());

        long reqT = System.currentTimeMillis();
        int sleepTime = 10000;

        for (int i=0; i<10; i++) {
            reqT = System.currentTimeMillis();
            boolean isAllowed = isAllowed(reqT, 1L);
            System.out.println(String.format("Req at %d allowed? %s (totalRequestsInHour: %d) ", reqT, isAllowed, requestCounterHourly.get(userId)));

            //sleepTime *= 2; // exponential
            sleep(sleepTime);
        }

        System.out.println("=============================");
        printTimes(limitMap.get(userId));
        System.out.println("=============================");

    }

    private void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void refreshMinuteSlots(Long userId, Long reqT) {
        Long minofDay = truncate(reqT, ChronoUnit.HOURS); // start min of the hour

        System.out.println("the start time  value"+minofDay);
        ConcurrentSkipListMap<Long, Integer> times = new ConcurrentSkipListMap<Long, Integer>();

        for (int i=0; i<=59; i++) { // add rounded minutes in an hour to the map
            times.put(minofDay, 0);
            minofDay += MILLIS_IN_MIUTE;
        }

        System.out.println(times);

        limitMap.put(userId, times);
    }

    private Long truncate(Long time, ChronoUnit unit) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date date = new Date(time);
        String dateStr = sdf.format(date);

        Instant instant = Instant.parse(dateStr);
        Instant returnValue = instant.truncatedTo(unit);

        System.out.println("the return  value"+returnValue);

        System.out.println("the time in milli  value"+returnValue.toEpochMilli());
        return returnValue.toEpochMilli();
    }


    private boolean isAllowed(Long reqT, Long userId) {

        ConcurrentSkipListMap<Long, Integer> times = limitMap.get(userId);

        Long truncatedMin = truncate(reqT, ChronoUnit.MINUTES); // truncate to the beginning of minute

        if (times != null) {
            Long truncatedHour = truncate(reqT, ChronoUnit.HOURS); // truncate to the beginning of hour
            Long truncatedDay = truncate(reqT, ChronoUnit.DAYS); // truncate to the beginning of the day

            if ((truncatedMin - truncatedDay >= MILLIS_IN_DAY)
                    || (truncatedMin - truncatedHour >= MILLIS_IN_HOUR)) {

                refreshMinuteSlots(userId, reqT);
                requestCounterHourly.put(userId, 0);
            }

        } else {
            refreshMinuteSlots(userId, reqT);

        }

        times = limitMap.get(userId);

        // Reject if greater than rate limit threshold
        if ((times.get(truncatedMin) >= RATE_LIMIT_PER_MIN) || (requestCounterHourly.getOrDefault(userId, 0) >= RATE_LIMIT_PER_HOUR)) {
            return false;
        }

        System.out.println(String.format("Putting reqT %d in the bucket %d", reqT, truncatedMin));
        times.put(truncatedMin, times.get(truncatedMin) + 1);
        limitMap.put(userId, times);
        requestCounterHourly.put(userId, requestCounterHourly.getOrDefault(userId, 0) + 1);

        return true;
    }

    private void printTimes(ConcurrentSkipListMap<Long, Integer> times) {

        System.out.println("Current state of the times for user...");
        for (Long time : times.keySet()) {
            System.out.println(time + " : " + times.get(time));
        }
    }
}
