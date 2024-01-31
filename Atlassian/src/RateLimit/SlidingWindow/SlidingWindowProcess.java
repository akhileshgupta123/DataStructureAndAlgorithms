package RateLimit.SlidingWindow;
import java.util.*;
public class SlidingWindowProcess implements Runnable{

    private SlidingWindowCounter slidingWindowCounter;
    public SlidingWindowProcess(SlidingWindowCounter slidingWindowCounter){
        this.slidingWindowCounter = slidingWindowCounter;
    }

    public void run(){

        while(true){
            int p = (int) (1+Math.random() * 5);
            System.out.println("Request with  "+ p + " request ");

            for(int i=0; i<p; i++){
                System.out.println("does request allow "+ this.slidingWindowCounter.allow());
            }

            try{

                //long waitTime = (long)(Math.random()*77000*7000);

                long waitTime = (long)(Math.random()*55000.0 + 5000.0);

                //long waitTime = (long)(Math.random()*55000.0 + 5000.0);

                System.out.println("Next Request Time: " + new Date(System.currentTimeMillis() + waitTime));
                System.out.println("===========================");
                System.out.println("===========================");
                Thread.sleep(waitTime);
            }catch(InterruptedException ex){
                throw new RuntimeException(ex);
            }
        }

    }
}
