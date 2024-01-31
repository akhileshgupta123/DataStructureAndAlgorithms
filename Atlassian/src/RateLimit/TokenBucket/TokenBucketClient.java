package RateLimit.TokenBucket;

public class TokenBucketClient {
    public static void main(String[] args){
        System.out.println("Inside Token Bucket Client");
        TokenBucket tokenBucket = new TokenBucket(10);
        AddTokenProcess addToken = new AddTokenProcess(tokenBucket);
        SendTokenProcess sendToken = new SendTokenProcess(tokenBucket);
        Thread addTokenProcess = new Thread(addToken);
        Thread sendTokenProcess = new Thread(sendToken);
        addTokenProcess.start();
        sendTokenProcess.start();
    }
}
