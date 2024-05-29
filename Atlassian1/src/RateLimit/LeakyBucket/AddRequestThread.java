package RateLimit.LeakyBucket;

public class AddRequestThread extends Thread{

    private LeakyBucketToken leakyBucketToken;

    public AddRequestThread(LeakyBucketToken leakyBucketToken) {
        this.leakyBucketToken = leakyBucketToken;
    }

    public void run(){
        while(true){
            try{

                Thread.sleep(2000);
            }catch(Exception ex){

            }
            leakyBucketToken.addRequest((int)(Math.random()*9));
        }
    }
}
