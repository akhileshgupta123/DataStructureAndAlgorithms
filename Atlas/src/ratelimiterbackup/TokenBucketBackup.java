package ratelimiterbackup;

public class TokenBucketBackup extends RateLimiterBackup{

    private int token;
    public TokenBucketBackup(int maxRequestPerSec){
        super(maxRequestPerSec);
        this.token = maxRequestPerSec;

        new Thread(() -> {
            while(true){
                try{

                    Thread.sleep(1000);
                }catch(InterruptedException ex){
                    ex.printStackTrace();
                }

                this.fillToken(maxRequestPerSec);
            }

        }).start();
    }
    @Override
    boolean isAllowToSendRequest() {
        synchronized(this){
            if(token==0)
                return false;
            else {
                token--;
                return true;
            }
        }

    }

    private void fillToken(int count){
        synchronized(this){
            token = Math.min(token+ count, this.maxRequestPerSecond);
            notifyAll();
        }

    }
}
