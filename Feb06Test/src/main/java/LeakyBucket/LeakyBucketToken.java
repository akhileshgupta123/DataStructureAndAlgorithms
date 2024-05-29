package LeakyBucket;

public class LeakyBucketToken {
    private int bucketSize;
    private int outData;
    private int currentCounter;

    public LeakyBucketToken(int outData, int bucketSize){
        this.bucketSize = bucketSize;
        this.outData = outData;
        this.currentCounter = 0;
    }

    public synchronized void addRequest(int n){
        System.out.println("Get "+ n+ " Request");

        if(this.currentCounter+n>bucketSize){
            System.out.println("packet is not adjust. it discarded");
            return;
        }
        System.out.println("Added "+ n + " Request into queue.");
        this.currentCounter = this.currentCounter + n;
    }

    public synchronized void processRequest(){
        if(this.currentCounter ==0){
            return;
        }

        int currentProcessRequest = Math.min(this.outData, this.currentCounter);

        System.out.println("Processed "+ currentProcessRequest + " Request from Queue");
        this.currentCounter = this.currentCounter - currentProcessRequest;

    }

    public int getBucketSize() {
        return bucketSize;
    }

    public void setBucketSize(int bucketSize) {
        this.bucketSize = bucketSize;
    }

    public int getOutData() {
        return outData;
    }

    public void setOutData(int outData) {
        this.outData = outData;
    }

    public int getCurrentCounter() {
        return currentCounter;
    }

    public void setCurrentCounter(int currentCounter) {
        this.currentCounter = currentCounter;
    }
}
