import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.*;

public class MyTestBase {

    private VoteAlgorithm voter;
    @BeforeClass
    public static void initialization(){

    }

    @BeforeTest
    public void setup(){
        voter = new VoteAlgorithm();
    }


    @Test
    public void firstTest(){

        List<List<String>> result = voter.calculateFinalListData();

        Assert.assertEquals(result.size(),3);

    }
}
