package testcases;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.ResultsPage;

import java.io.IOException;

public class TC_07_VerifyProductNamesAndPartner extends BaseTest {
    //By Aditya
    HomePage homePage;
    ResultsPage resultsPage;
    @Test(priority = 11)
    public void testSearchProductName() throws IOException {
        homePage =new HomePage(driver,wait);
        resultsPage=new ResultsPage(driver,wait);
        homePage.sendInputToSearchBar("Python");
        Assert.assertTrue(resultsPage.searchAndLoadCards());
    }

    @Test(priority = 12)
    public void testSearchPartnerAndBadge() throws IOException {
        homePage =new HomePage(driver,wait);
        homePage.sendInputToSearchBar("Python");
        resultsPage=new ResultsPage(driver,wait);
        Assert.assertTrue(resultsPage.companyCourseName());
    }
}
