package RateLimit.TokenBucketNew;

import RateLimit.SlidingWindow.SlidingWindowCounter;
import RateLimit.SlidingWindow.SlidingWindowProcess;

public class TokenBucketClient {
    public static void main(String[] args){
        System.out.println("inside token bucket window");
        TokenBucketNew counterObj = new TokenBucketNew(3);
        Thread tokenBucketThread = new Thread(new TokenBucketProcess(counterObj));
        tokenBucketThread.start();
    }
}
