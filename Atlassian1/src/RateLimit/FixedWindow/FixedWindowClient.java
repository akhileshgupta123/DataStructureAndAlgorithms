package RateLimit.FixedWindow;

public class FixedWindowClient {
    public static void main(String[] args){
        System.out.println("start");

        FixedWindowBucket fixedWindowBucket = new FixedWindowBucket(10);

        Thread fixedWindowReset = new Thread(new FixedWindowReset(fixedWindowBucket));
        Thread fixedWindowProcess = new Thread(new FixedWindowProcess(fixedWindowBucket));
        fixedWindowReset.start();
        fixedWindowProcess.start();
    }
}
