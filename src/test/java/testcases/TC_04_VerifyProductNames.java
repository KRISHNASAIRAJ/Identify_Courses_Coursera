package testcases;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.ResultsPage;

import java.io.IOException;

public class TC_04_VerifyProductNames extends BaseTest {
    //By Aditya
    HomePage homePage;
    ResultsPage resultsPage;

        @Test(priority = 5)
        public void testSearchProductName() throws IOException {
            homePage =new HomePage(driver,wait);
            resultsPage=new ResultsPage(driver,wait);
            homePage.sendInputToSearchBar("Python");
            Assert.assertTrue(resultsPage.searchAndLoadCards());
        }

}
