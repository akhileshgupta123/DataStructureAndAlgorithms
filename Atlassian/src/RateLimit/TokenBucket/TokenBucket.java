package RateLimit.TokenBucket;

public class TokenBucket {
    private int tokens;
    private int bucketSize;
    public TokenBucket(int bucketSize){
        this.tokens = 0;
        this.bucketSize = bucketSize;
    }
    public synchronized void addToken(){
        if(this.tokens>=this.bucketSize){
            return;
        }
        this.tokens = this.tokens + 1;

        System.out.println("New Token Added. Total Token:" + tokens);
    }

    public synchronized void sendPacket(int n){
        System.out.println("packet of size :"+n+" arrive");
        if(n> this.tokens){
            System.out.println("Token does not exist same quantity as Packet");
        }else{
            this.tokens = this.tokens - n;
            System.out.println("Forwarding packet");
        }
    }

}
