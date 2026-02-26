package testcases;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.ResultsPage;

import java.io.IOException;

public class TC_06_VerifyReviews extends BaseTest {
    //By Aditya
    ResultsPage resultsPage;
    HomePage homePage;

    @Test(priority = 7)
        public void testCheckReviews() throws IOException {
        homePage =new HomePage(driver,wait);
        homePage.sendInputToSearchBar("Python");
        resultsPage=new ResultsPage(driver,wait);
            Assert.assertTrue(resultsPage.courseReviews());
        }
}
