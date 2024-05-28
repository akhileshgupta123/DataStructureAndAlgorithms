package ratelimiterbackup;

public class LeakyBucketBackup extends RateLimiterBackup{

    private long nextAllowTime;
    private final long REQUEST_INTERVAL_MILLIS;
    protected LeakyBucketBackup(int maxRequestPerSecond){
        super(maxRequestPerSecond);
        REQUEST_INTERVAL_MILLIS = 1000/maxRequestPerSecond;
        nextAllowTime = System.currentTimeMillis();

    }
    @Override
    boolean isAllowToSendRequest() {
        long currTime = System.currentTimeMillis();
        synchronized(this){
            if(currTime>=nextAllowTime){
                nextAllowTime = currTime + REQUEST_INTERVAL_MILLIS;
                return true;
            }
        }
        return false;
    }
}
