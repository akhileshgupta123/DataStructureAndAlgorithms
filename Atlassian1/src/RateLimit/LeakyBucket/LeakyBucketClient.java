package RateLimit.LeakyBucket;

public class LeakyBucketClient {
    public static void main(String[] args){
        LeakyBucketToken leakyBucketToken = new LeakyBucketToken(5,10);

        Thread addRequestThread = new AddRequestThread(leakyBucketToken);
        Thread processRequestThread = new ProcessRequestThread(leakyBucketToken);
        addRequestThread.start();
        processRequestThread.start();
    }
}
