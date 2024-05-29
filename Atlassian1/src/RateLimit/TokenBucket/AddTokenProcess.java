package RateLimit.TokenBucket;

public class AddTokenProcess implements Runnable{

    private TokenBucket tokenBucket;
    public AddTokenProcess(TokenBucket tokenBucket){
        this.tokenBucket = tokenBucket;
    }

    public void run(){

        while(true){
            tokenBucket.addToken();
            try{
                Thread.sleep(300);

            }catch (InterruptedException ex){

            }
        }

    }
}
