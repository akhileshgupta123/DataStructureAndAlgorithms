package ratelimiterbackup;

import java.util.LinkedList;
import java.util.Queue;

public class SlidingWindowLogBackup extends RateLimiterBackup{
    private final Queue<Long> log = new LinkedList<>();
    protected SlidingWindowLogBackup(int maxRequestPerSecond){
        super(maxRequestPerSecond);
    }
    @Override
    boolean isAllowToSendRequest() {
        long currTime = System.currentTimeMillis();
        long baoundary = currTime - 1000;
        synchronized(log){

            while(!log.isEmpty() &&  log.peek() <= baoundary){
                log.poll();
            }
            log.add(currTime);
            return log.size() <= maxRequestPerSecond;
        }

    }
}
