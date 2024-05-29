package RateLimit.FixedWindowNew;

import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class FixedWindowCounter {

    private final int maxRequestPerWindow;
    private final long windowSizeInMillis;
    private ConcurrentHashMap<Long, AtomicInteger> window;

    public FixedWindowCounter(int maxRequest, long windowSizeInMillis){
        this.maxRequestPerWindow = maxRequest;
        this.windowSizeInMillis = windowSizeInMillis;
        this.window = new ConcurrentHashMap<>();
    }


    public boolean allow(){
        long currentTime = System.currentTimeMillis();

        System.out.println("Current Time of Request :"+ new Date(currentTime) + " " + currentTime);
        long currentWindowKey = currentTime/ this.windowSizeInMillis;

        System.out.println("Current Window Key: " + currentWindowKey);

        if(!window.containsKey(currentWindowKey)){
            window.put(currentWindowKey, new AtomicInteger(0));
        }


        //long preWindowKey = currentWindowKey - 60000;
        //System.out.println("Previous Window Key: " + preWindowKey);

        int count = window.get(currentWindowKey).incrementAndGet();
        System.out.println("the existing count is:"+count);
        return  count <= maxRequestPerWindow;

    }
}
