package MultiThreading;
import java.util.concurrent.*;
import java.util.*;

public class InvokeAllExample {
    public static void main(String args[]) throws InterruptedException,ExecutionException{
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        List<Callable<Integer>> taskList = new ArrayList<Callable<Integer>>();

        for(int i=0; i<10; i++){
            Callable obj = new CallableParamImpl(i);
            taskList.add(obj);
        }

        List<Future<Integer>> futures = executorService.invokeAll(taskList);

        for(Future<Integer> future: futures) {
            // The result is printed only after all the futures are complete. (i.e. after 5 seconds)
            System.out.println(future.get());
        }


        executorService.shutdown();
    }
}
