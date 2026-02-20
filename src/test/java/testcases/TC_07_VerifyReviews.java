package testcases;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.ResultsPage;

import java.io.IOException;

public class TC_07_VerifyReviews extends BaseTest {
    //By Aditya
    ResultsPage resultsPage;
    @BeforeTest
    void setUp() throws IOException {
        resultsPage=new ResultsPage(driver,wait);
    }
    @Test(priority = 7)
        public void testCheckReviews(){
            Assert.assertTrue(resultsPage.courseReviews());
        }
}
