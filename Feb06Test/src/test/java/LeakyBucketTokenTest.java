import LeakyBucket.AddRequestThread;
import LeakyBucket.LeakyBucketToken;
import LeakyBucket.ProcessRequestThread;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import  org.testng.annotations.BeforeClass;
public class LeakyBucketTokenTest {
    private LeakyBucketToken leakyBucketToken;
    private Thread addRequestThread;
    private Thread processRequestThread;


    //LeakyBucketToken leakyBucketToken = new LeakyBucketToken(5,10);

    //Thread addRequestThread = new AddRequestThread(leakyBucketToken);
    //Thread processRequestThread = new ProcessRequestThread(leakyBucketToken);
      //  addRequestThread.start();
        //processRequestThread.start();
    @BeforeTest
    public void initSetup(){
        leakyBucketToken = new LeakyBucketToken(5,10);
    }

    @Test
    public void validateProcessRequest() throws Exception{
        addRequestThread = new AddRequestThread(leakyBucketToken);
        addRequestThread.start();
        Thread.sleep(5000);
        Assert.assertTrue(this.leakyBucketToken.getCurrentCounter()>0);
    }

    @Test
    public void validateReleaseRequest() throws Exception{
        processRequestThread = new ProcessRequestThread(leakyBucketToken);
        processRequestThread.start();
        Thread.sleep(7000);
        Assert.assertTrue(this.leakyBucketToken.getCurrentCounter()<=this.leakyBucketToken.getBucketSize()
                && this.leakyBucketToken.getCurrentCounter()>0);
    }
}
