package ratelimiterbackup;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

public class SlidingWindowBackup extends RateLimiterBackup{

    private final ConcurrentMap<Long, AtomicInteger> windows = new ConcurrentHashMap<>();
    protected SlidingWindowBackup(int maxRequestPerSec){
        super(maxRequestPerSec);
    }
    @Override
    boolean isAllowToSendRequest() {
        long curTime = System.currentTimeMillis();
        long curWindowKey = curTime / 1000 * 1000;

        if(!windows.containsKey(curWindowKey)){
            windows.put(curWindowKey, new AtomicInteger(0));
        }

        long preWindowKey = curWindowKey - 1000;
        AtomicInteger preCount = windows.get(preWindowKey);

        if (preCount == null) {
            //System.out.println("inside is:");
            //System.out.println(windows.get(curWindowKey));
            return windows.get(curWindowKey).incrementAndGet() <= this.maxRequestPerSecond;
        }

        double preWeight = 1 - (curTime - curWindowKey) / 1000.0;
        long count = (long) (preCount.get() * preWeight
                + windows.get(curWindowKey).incrementAndGet());
        return count <= this.maxRequestPerSecond;
    }
}
