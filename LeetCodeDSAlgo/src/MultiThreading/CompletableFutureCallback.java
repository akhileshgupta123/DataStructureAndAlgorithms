package MultiThreading;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureCallback {
    public static void main(String args[]){
        CompletableFuture<Integer> futureCount = createCompletableFuture();

        try{
            int count = futureCount.get();

            System.out.println(count);
        }catch(Exception ex){

        }

    }

    private static CompletableFuture<Integer> createCompletableFuture() {
        CompletableFuture<Integer> futureCount = CompletableFuture.supplyAsync(
                ()->{

                    try {
                        // simulate long running task
                        Thread.sleep(2000);
                    } catch (InterruptedException e) { }
                    return 20;
                }

        );
        return futureCount;
    }
}
