package ratelimiterbackup;

import java.util.concurrent.TimeUnit;

public class RateLimiterMain {
    public static void main(String args[]) throws InterruptedException {
        //RateLimiterBackup obj = new TokenBucketBackup(10);

        RateLimiterBackup obj = new SlidingWindowLogBackup(10);

        Thread sendReqThread = new Thread(()->{
            sendRateLimiterRequest(obj,100, 10);
        }

        );

        sendReqThread.start();
        sendReqThread.join();

    }

    public static void sendRateLimiterRequest(RateLimiterBackup obj ,  int totalRquestCount, int requestPerSecond){
        long startTime = System.currentTimeMillis();

        for(int i=0; i<totalRquestCount; i++){
            try{
                System.out.println("########the request count is:"+ i);
                new Thread(() -> {
                    while(!obj.isAllowToSendRequest()){
                        try{
                            Thread.sleep(10);

                        }catch(InterruptedException ex){
                            ex.printStackTrace();
                        }

                    }


                }
                ).start();

                Thread.sleep(1000/requestPerSecond);
            }catch(InterruptedException ex){
                ex.printStackTrace();
            }
        }

        double  duration = (System.currentTimeMillis() - startTime) / 1000.0;

        System.out.println(totalRquestCount + " requests processed in " + duration + " seconds. "
                + "Rate: " + (double) totalRquestCount / duration + " per second");
    }
}
