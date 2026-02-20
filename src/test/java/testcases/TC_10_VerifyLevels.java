package testcases;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.ResultsPage;

import java.io.IOException;

public class TC_10_VerifyLevels extends BaseTest {
    //By Aditya
    ResultsPage resultsPage;
    @BeforeTest
    void setUp() throws IOException {
        resultsPage=new ResultsPage(driver,wait);
    }
    @Test(priority = 8)
    void testCheckLevels(){
        Assert.assertTrue(resultsPage.courseLevel());
    }
}
