package RateLimit.LeakyBucket;

public class LeakyBucketToken {
    private int outFlowRate;
    private int bucketSize;
    private int currentCounter;

    public LeakyBucketToken(int outFlowRate, int bucketSize){
        this.currentCounter = 0;
        this.bucketSize = bucketSize;
        this.outFlowRate = outFlowRate;
    }

    public synchronized void addRequest(int n){
        System.out.println("Get "+ n+ " Request");
        if(currentCounter+n > bucketSize){
            System.out.println("packet is not adjust. it discarded");
            return;
        }

        System.out.println("Added "+ n + " Request into queue.");
        this.currentCounter = this.currentCounter + n;
    }

    public void processRequest(){
        if(this.currentCounter ==0){
            return;
        }

        int currentProcessRequest = Math.min(this.outFlowRate, currentCounter);

        System.out.println("Processed "+ currentProcessRequest + " Request from Queue");
        this.currentCounter = this.currentCounter - currentProcessRequest;
    }
}
