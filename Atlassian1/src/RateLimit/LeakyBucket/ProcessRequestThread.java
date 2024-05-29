package RateLimit.LeakyBucket;

public class ProcessRequestThread extends Thread{

    private LeakyBucketToken leakyBucketToken;

    public ProcessRequestThread(LeakyBucketToken leakyBucketToken) {
        this.leakyBucketToken = leakyBucketToken;
    }

    public void run(){
        while(true){
            this.leakyBucketToken.processRequest();
            try{
                Thread.sleep(6000);

            }catch(Exception ex){
                System.out.println("here exception");
            }
        }
    }
}
