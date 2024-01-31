package RateLimit.SlidingWindow;

public class SlidingWindowClient {
    public static void main(String[] args){
        System.out.println("inside sliding window");
        SlidingWindowCounter counterObj = new SlidingWindowCounter(5);
        Thread slidingWindowThread = new Thread(new SlidingWindowProcess(counterObj));
        slidingWindowThread.start();
    }
}
