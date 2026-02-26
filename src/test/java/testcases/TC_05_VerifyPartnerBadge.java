package testcases;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.ResultsPage;

import java.io.IOException;

public class TC_05_VerifyPartnerBadge extends BaseTest {
    //By Aditya
    HomePage homePage;
    ResultsPage resultsPage;

    @Test(priority = 6)
    public void testSearchPartnerAndBadge() throws IOException {
        homePage =new HomePage(driver,wait);
        homePage.sendInputToSearchBar("Python");
        resultsPage=new ResultsPage(driver,wait);
        Assert.assertTrue(resultsPage.companyCourseName());
    }
}
