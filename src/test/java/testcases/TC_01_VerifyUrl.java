package testcases;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import utilities.ConfigReader;
import utilities.Log;

import java.io.IOException;

public class TC_01_VerifyUrl extends BaseTest {
    //By Irfan
    HomePage homePage;
    @Test(priority = 1)
    public void verifyURl() throws IOException {
        homePage =new HomePage(driver,wait);
        Log.info("Getting the URL of the Page");
        Assert.assertEquals(homePage.getURL(),configReader.getProp("URL"));
        Log.info("URL verification completed");
    }
}
