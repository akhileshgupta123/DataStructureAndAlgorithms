package RateLimit.FixedWindowNew;

import RateLimit.SlidingWindow.SlidingWindowCounter;
import RateLimit.SlidingWindow.SlidingWindowProcess;

public class FixedWindowNewClient {

    public static void main(String[] args){
        System.out.println("inside sliding window");
        FixedWindowCounter counterObj = new FixedWindowCounter(3,1000*10);
        Thread fixedWindowThread = new Thread(new FixedWindowNewProcess(counterObj));
        fixedWindowThread.start();
    }
}
