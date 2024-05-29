package RateLimit.FixedWindow;

public class FixedWindowProcess implements Runnable{
    private FixedWindowBucket fixedWindowBucket;
    public FixedWindowProcess(FixedWindowBucket fixedWindowBucket){
        this.fixedWindowBucket = fixedWindowBucket;
    }

    public void run(){
        while(true){
            try{
                this.fixedWindowBucket.processRequest((int)(1+ Math.random()*9));
                Thread.sleep(2000);
            }catch(InterruptedException ex){
                throw new RuntimeException(ex);
            }
        }
    }
}
