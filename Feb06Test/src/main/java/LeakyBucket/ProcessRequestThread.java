package LeakyBucket;

public class ProcessRequestThread extends Thread{
    private LeakyBucketToken leakyBucketToken;
    public ProcessRequestThread( LeakyBucketToken leakyBucketToken){
        this.leakyBucketToken = leakyBucketToken;
    }

    public void run(){
        while(true){
            this.leakyBucketToken.processRequest();
            try{

                Thread.sleep(5000);
            }catch(Exception ex){

            }
        }
    }
}
