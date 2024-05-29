import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.*;
public class FileProcessorTestCase {

    private FileProcessor processor;

    @BeforeTest
    public void initSetup(){
        this.processor = new FileProcessor(5);
    }
    @Test
    public void validateFileCollectionName(){
        this.processor.populateCollection("file1.txt",null, 100);
        this.processor.populateCollection("file2.txt","collection1", 200);
        this.processor.populateCollection("file3.txt","collection1", 200);
        this.processor.populateCollection("file4.txt","collection2", 300);
        this.processor.populateCollection("file5.txt",null, 10);

        List<String> result = this.processor.getTopNCollection();
        int size = this.processor.getTotalSizeFiles();

        Assert.assertEquals(result.get(0), "collection1");
        Assert.assertEquals(result.get(1), "collection2");

        Assert.assertEquals(size, 810);



    }
}
