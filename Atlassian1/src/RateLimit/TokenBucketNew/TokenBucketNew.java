package RateLimit.TokenBucketNew;

public class TokenBucketNew {

    private int tokens;

    private long lastRefillTime;

    private int maxRequestPerSec;


    public TokenBucketNew(int maxRequestPerSec) {
        this.tokens = maxRequestPerSec;
        this.lastRefillTime = System.currentTimeMillis();
        this.maxRequestPerSec = maxRequestPerSec;
    }


    public boolean allow() {
        synchronized (this) {
            this.refillTokens();
            if (this.tokens == 0) {
                return false;
            }
            tokens--;
            return true;
        }
    }

    private void refillTokens() {
        long curTime = System.currentTimeMillis();
        double secSinceLastRefill = (curTime - lastRefillTime) / 1000.0;
        int cnt = (int) (secSinceLastRefill * maxRequestPerSec);
        if (cnt > 0) {
            tokens = Math.min(tokens +  cnt, maxRequestPerSec);

            System.out.println("The last refill token:"+tokens);
            lastRefillTime = curTime;
        }
    }
}
