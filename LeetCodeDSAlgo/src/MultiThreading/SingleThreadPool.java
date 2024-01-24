package MultiThreading;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class SingleThreadPool {

    public static void main(String args[]) throws InterruptedException{
        ExecutorService executor =  Executors.newFixedThreadPool(5);
        //ExecutorService executor =  Executors.newSingleThreadExecutor();


        for (int i = 0; i < 10; i++) {
            Runnable worker = new MyRunnable();
            executor.execute(worker);
            //executor.submit(worker);
        }


        executor.shutdown();
        // Wait until all threads are finish
        executor.awaitTermination(3000, TimeUnit.SECONDS);
        System.out.println("Finished all threads");
    }
}
