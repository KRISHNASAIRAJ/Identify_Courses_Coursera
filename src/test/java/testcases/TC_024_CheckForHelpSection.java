package testcases;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.BusinessFormPage;
import pageObjects.HomePage;
import utilities.Log;

import java.io.IOException;

public class TC_024_CheckForHelpSection extends BaseTest {
    HomePage homePage;
    BusinessFormPage businessFormPage;

    @BeforeTest
    void setUp()
    {
        homePage=new HomePage(driver,wait);
        businessFormPage=new BusinessFormPage(driver,wait);
    }

    @Test
    void checkHelpSection() throws IOException {
        businessFormPage.clickOnIndividual();
        Assert.assertTrue(homePage.checkForHelpSection(),"Help section is not displayed");
        homePage.clickHelpSection();
        Log.info("Help Section Verification Completed");
    }
}
