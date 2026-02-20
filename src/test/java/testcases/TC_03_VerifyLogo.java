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
    @BeforeTest
    void setUp() throws IOException {
        homePage =new HomePage(driver,wait);
    }
    @Test(priority = 3)
    public void testWebsiteLogo(){
        Assert.assertTrue(homePage.checkLogo());
    }
}
