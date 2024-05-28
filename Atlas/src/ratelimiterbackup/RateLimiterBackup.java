package ratelimiterbackup;

public abstract class RateLimiterBackup {
    protected final int maxRequestPerSecond;


    protected RateLimiterBackup(int maxRequestPerSecond){
        this.maxRequestPerSecond = maxRequestPerSecond;
    }

    abstract boolean isAllowToSendRequest();
}
