package ratelimiter;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

public class SlidingWindow extends RateLimiter{

    private final ConcurrentMap<Long, AtomicInteger> windows = new ConcurrentHashMap<>();

    protected SlidingWindow(int maxRequestPerSec) {
        super(maxRequestPerSec);
    }

    @Override
    boolean allow() {
        long curTime = System.currentTimeMillis();
        //System.out.println("cur time is:"+curTime);
        //long curWindowKey = curTime / (1000 * 1000);
        long curWindowKey = curTime / 1000 * 1000;
        //System.out.println("curWindowKey  is:"+curWindowKey);
        if(!windows.containsKey(curWindowKey)){
            windows.put(curWindowKey, new AtomicInteger(0));
        }
        //windows.putIfAbsent(curWindowKey, new AtomicInteger(0));
        long preWindowKey = curWindowKey - 1000;

        //System.out.println("preWindowKey  is:"+preWindowKey);
        AtomicInteger preCount = windows.get(preWindowKey);

        if (preCount == null) {
            //System.out.println("inside is:");
            //System.out.println(windows.get(curWindowKey));
            return windows.get(curWindowKey).incrementAndGet() <= maxRequestPerSec;
        }

        System.out.println("curTime is:"+curTime);
        System.out.println("curWindowKey is:"+curWindowKey);
        double preWeight = 1 - (curTime - curWindowKey) / 1000.0;
        long count = (long) (preCount.get() * preWeight
                + windows.get(curWindowKey).incrementAndGet());
        return count <= maxRequestPerSec;
    }
}
