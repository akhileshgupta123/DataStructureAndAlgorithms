package MultiThreading;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class ReentrantLockMethodsExample {
    public static void main(String args[]){
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        ReentrantLockMethodsCounter lockMethodsCounter = new ReentrantLockMethodsCounter();

        executorService.submit(new ReEntrantRunnable(lockMethodsCounter,"First"));

        executorService.submit(new ReEntrantRunnable(lockMethodsCounter,"Second"));






        executorService.shutdown();

    }
}
