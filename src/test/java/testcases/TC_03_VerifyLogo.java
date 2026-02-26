package testcases;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.HomePage;

import java.io.IOException;

public class TC_03_VerifyLogo extends BaseTest {
    //By Aditya
    HomePage homePage;

    @Test(priority = 3)
    public void testWebsiteLogo(){
        homePage =new HomePage(driver,wait);
        Assert.assertTrue(homePage.checkLogo());
    }
}
