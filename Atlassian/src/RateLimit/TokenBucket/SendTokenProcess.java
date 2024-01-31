package RateLimit.TokenBucket;

public class SendTokenProcess implements Runnable{
    private TokenBucket tokenBucket;
    public SendTokenProcess(TokenBucket tokenBucket){
        this.tokenBucket = tokenBucket;
    }

    public void run(){
        while(true){
            try{
                Thread.sleep(500 + (int) (Math.random()*3000));
            }catch(InterruptedException ex){

            }
            this.tokenBucket.sendPacket(1 + (int) (Math.random()*9));
        }
    }
}
