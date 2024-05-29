
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
public class RouterTest {


    private RouterImpl routerObject;

    @BeforeTest
    public void initSetup(){
        routerObject = new RouterImpl();
    }


    @Test(expectedExceptions = Exception.class)
    public void RegisterRouterLookupTest() throws Exception{
        this.populateData();
        Assert.assertEquals(routerObject.getRouterMap().size(), 4);
        this.cleanUpData();

    }

    @Test(expectedExceptions = Exception.class)
    public void LookupRouteTest() throws Exception{
        this.populateData();
        Assert.assertEquals(routerObject.lookupRoute("/Test1"),"ABC");
        this.cleanUpData();
    }

    @Test(expectedExceptions = Exception.class)
    public void NotFoundRouteTest() throws Exception{
        this.populateData();

        Assert.assertEquals(routerObject.lookupRoute("asdsadsad"),null);

        this.cleanUpData();
    }

    @Test
    public void EmptyRouterLookupTest(){
        Assert.assertEquals(routerObject.getRouterMap().size(), 0);
    }

    @Test(expectedExceptions = Exception.class)
    public void MissingRouterLookupExceptionTest() throws Exception{
        this.populateData();
        Assert.assertEquals(routerObject.lookupRoute("asdsadsad"),"Lookup Record Does Not Exist");
        //AssertionError(routerObject.lookupRoute("asdsadsad"))
        //Assert.expectThrows(routerObject.lookupRoute("asdsadsad"),Throwable)
        this.cleanUpData();
    }
    private void populateData() throws Exception{
        routerObject.registerRoute("/Test1","ABC");
        routerObject.registerRoute("/Test1/Test2","XYZ");
        routerObject.registerRoute("/Test1/Test2/Test3","CDF");
        routerObject.registerRoute("/File1/File2","YHG");
    }

    private void cleanUpData(){
        routerObject.getRouterMap().clear();
    }


}
