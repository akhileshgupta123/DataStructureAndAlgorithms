package RateLimit.FixedWindow;

public class FixedWindowBucket {
    private int token;
    private int bucketSize;

    public FixedWindowBucket(int bucketSize){
        this.token = 0;
        this.bucketSize = bucketSize;
    }

    public synchronized void resetToken(){
        System.out.println("Resetting Token");
        this.token = 0;
    }

    public synchronized void processRequest(int n){
        System.out.println("Packet size : "+ n + " arrived");

        if(this.token+n>this.bucketSize){
            System.out.println("Packet is non adjust to given remaining bucket size.");
        }else{
            this.token = this.token + n;
            System.out.println("Processing " + n + " requests");
        }

    }

}
