package MultiThreading;
import java.util.*;
import java.util.concurrent.*;

public class CompletableFutureExample1 {
    public static void main(String args[]) throws Exception{
        List<Integer> list = new ArrayList<Integer>();
        list.add(5);
        list.add(9);
        list.add(14);

        CompletableFuture<String> greetingFuture = CompletableFuture.supplyAsync(()->{
            return "testing";
        });

        System.out.println(greetingFuture.get());
    }
}
