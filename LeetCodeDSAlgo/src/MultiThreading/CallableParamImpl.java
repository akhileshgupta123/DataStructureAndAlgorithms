package MultiThreading;

import java.util.concurrent.Callable;

public class CallableParamImpl implements Callable {
    private int id;

    public CallableParamImpl(Integer id){
        this.id = id;
    }

    public Integer call() throws InterruptedException{
        Thread.sleep(2000);
        return this.id;
    }
}
