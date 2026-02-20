package testcases;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.ResultsPage;

import java.io.IOException;

public class TC_05_VerifyProductNames extends BaseTest {
    //By Aditya
    HomePage homePage;
    ResultsPage resultsPage;
    @BeforeTest
    void setUp() throws IOException {
        homePage =new HomePage(driver,wait);
        resultsPage=new ResultsPage(driver,wait);
    }
        @Test(priority = 5)
        public void testSearchProductName(){
            homePage.sendInputToSearchBar("Python");
            Assert.assertTrue(resultsPage.searchAndLoadCards());
        }

}
