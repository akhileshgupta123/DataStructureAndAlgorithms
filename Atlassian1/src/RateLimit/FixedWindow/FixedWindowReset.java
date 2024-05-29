package RateLimit.FixedWindow;

public class FixedWindowReset implements Runnable{

    private FixedWindowBucket fixedWindowBucket;

    public FixedWindowReset(FixedWindowBucket fixedWindowBucket){
        this.fixedWindowBucket = fixedWindowBucket;
    }

    public void run(){

        while(true){
            try{
                Thread.sleep(10000);

            }catch(InterruptedException ex){
                throw new RuntimeException(ex);
            }
            this.fixedWindowBucket.resetToken();
        }

    }
}
