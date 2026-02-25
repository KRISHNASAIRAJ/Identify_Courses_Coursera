package testcases;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.ResultsPage;
import utilities.Log;


public class TC_017_SortFunctionExistence extends BaseTest {
    //Harsh
    ResultsPage result;
    @BeforeTest
    void setUp(){
        result=new ResultsPage(driver,wait);
    }

    @Test
    void checkForSortFunction() {
        Assert.assertTrue(result.filterAndSortVisible(),"Filter and Sort Button is not Visible");
        result.filterAndSortClick();
        Log.info("Filter and sort button verification completed");
    }
}
