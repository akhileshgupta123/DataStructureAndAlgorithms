package MultiThreading;
import java.util.concurrent.*;

public class FutureCallableExample {
    public static void main(String args[]) throws InterruptedException, ExecutionException{

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Callable item = new CallableImpl();
        Future<String> future = executorService.submit(item);


        while(!future.isDone()) {
            System.out.println("Task is still not done...");
            Thread.sleep(200);
        }
        String result = future.get();
        System.out.println(result);

        executorService.shutdown();
    }
}
