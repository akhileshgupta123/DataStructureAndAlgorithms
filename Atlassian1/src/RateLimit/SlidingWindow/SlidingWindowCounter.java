package RateLimit.SlidingWindow;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.*;
public class SlidingWindowCounter {
    private int maxRequest;
    private ConcurrentHashMap<Long, AtomicInteger> window;

    public SlidingWindowCounter(int maxRequest){
        this.maxRequest = maxRequest;
        this.window = new ConcurrentHashMap<>();
    }

    public boolean allow(){
        long currentTime = System.currentTimeMillis();

        System.out.println("Current Time of Request :"+ new Date(currentTime) + " " + currentTime);
        long currentWindowKey = currentTime/60000 * 60000;

        System.out.println("Current Window Key: " + currentWindowKey);

        if(!window.containsKey(currentWindowKey)){
            window.put(currentWindowKey, new AtomicInteger(0));
        }

        long preWindowKey = currentWindowKey - 60000;
        System.out.println("Previous Window Key: " + preWindowKey);

        AtomicInteger preCount = window.get(preWindowKey);

        if(preCount==null){
            int count = window.get(currentWindowKey).incrementAndGet();
            System.out.println("Existing Count: " + count);
            return  count <= maxRequest;
        }

        double preweight = 1 - (currentTime - currentWindowKey)/60000;

        long count = (long) (preCount.get() * preweight + window.get(currentWindowKey).incrementAndGet());
        System.out.println("Existing Count: " + count);
        return count <= maxRequest;
    }

}
