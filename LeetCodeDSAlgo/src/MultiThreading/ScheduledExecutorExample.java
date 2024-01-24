package MultiThreading;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorExample {
    public static void main(String args[]){
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);
        Runnable worker = new MyRunnable();
        scheduledExecutorService.scheduleAtFixedRate(worker,0,2,TimeUnit.SECONDS);

        //scheduledExecutorService.shutdown();

    }
}
