package ratelimiter;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
public class DriverMain {
    public static void main(String args[]) throws InterruptedException {
        final int MAX_REQUESTS_PER_SEC = 10;

        //RateLimiter rateLimiter = ; // new a RateLimiter here
        RateLimiter rateLimiter = new LeakyBucket(MAX_REQUESTS_PER_SEC);
        //RateLimiter rateLimiter = new TokenBucket(MAX_REQUESTS_PER_SEC);

        //RateLimiter rateLimiter = new SlidingWindowLog(MAX_REQUESTS_PER_SEC);

        //RateLimiter rateLimiter = new SlidingWindow(MAX_REQUESTS_PER_SEC);

        //sendRequest(rateLimiter, 20, 1);

        Thread requestThread = new Thread(() -> {
            //sendRequest(rateLimiter, 10, 1);
            //sendRequest(rateLimiter, 20, 2);
            //sendRequest(rateLimiter,50, 5);
            sendRequest(rateLimiter,100, 10);
            /*sendRequest(rateLimiter,200, 20);
            sendRequest(rateLimiter,250, 25);
            sendRequest(rateLimiter,500, 50);
            sendRequest(rateLimiter,1000, 100);*/
        });

        requestThread.start();
        requestThread.join();
    }


    public static void sendRequest(RateLimiter rateLimiter, int totalCnt, int requestPerSec) {
        long startTime = System.currentTimeMillis();
        CountDownLatch doneSignal = new CountDownLatch(totalCnt);
        for (int i = 0; i < totalCnt; i++) {
            try {
                System.out.println("########the count is:"+ doneSignal.getCount());
                new Thread(() -> {
                    while (!rateLimiter.allow()) {
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    doneSignal.countDown();
                }).start();
                TimeUnit.MILLISECONDS.sleep(1000 / requestPerSec);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            doneSignal.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        double duration = (System.currentTimeMillis() - startTime) / 1000.0;
        System.out.println(totalCnt + " requests processed in " + duration + " seconds. "
                + "Rate: " + (double) totalCnt / duration + " per second");
    }
}
