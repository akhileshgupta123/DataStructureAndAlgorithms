package MultiThreading;

import java.util.concurrent.Callable;

public class CallableImpl implements Callable {

    public String call() throws InterruptedException{
        System.out.println("Entered Callable");
        Thread.sleep(2000);
        return "Hello from Callable";
    }
}
