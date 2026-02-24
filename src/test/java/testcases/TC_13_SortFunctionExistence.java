package testcases;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.ResultsPage;


public class TC_13_SortFunctionExistence extends BaseTest {
    ResultsPage result;
    @BeforeTest
    void setUp(){
        result=new ResultsPage(driver,wait);
    }

    @Test
    void CheckForSortFunction() {
        Assert.assertTrue(result.FilterAndSortVisible(),"Filter and Sort Button is not Visible");
        result.FilterAndSortClick();
    }
}
