package testcases;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.ResultsPage;

import java.io.IOException;

public class TC_09_VerifyLevels extends BaseTest {
    //By Aditya
    ResultsPage resultsPage;
    HomePage homePage;
    @Test(priority = 14)
    void testCheckLevels() throws IOException {
        homePage=new HomePage(driver,wait);
        resultsPage=new ResultsPage(driver,wait);
        homePage.sendInputToSearchBar("Python");
        Assert.assertTrue(resultsPage.courseLevel());
    }
}
