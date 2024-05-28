package ratelimiter;
import java.util.concurrent.TimeUnit;
public class TokenBucket extends RateLimiter{

    private int tokens;

    public TokenBucket(int maxRequestsPerSec) {
        super(maxRequestsPerSec);
        this.tokens = maxRequestsPerSec;
        new Thread(() -> {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                refillTokens(maxRequestsPerSec);
            }
        }).start();
    }

    @Override
    boolean allow() {
        synchronized (this) {
            if (tokens == 0) {
                return false;
            }
            tokens--;
            return true;
        }
    }

    private void refillTokens(int cnt) {
        synchronized (this) {
            System.out.println("when refill tokens");
            tokens = Math.min(tokens + cnt, maxRequestPerSec);
            System.out.println("the final token count is:"+tokens);
            notifyAll();
        }
    }
}
