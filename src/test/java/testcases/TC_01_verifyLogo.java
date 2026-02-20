package testcases;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage_Aditya;

public class TC_01_verifyLogo extends BaseTest {
    @Test
    public void testWebsiteLogo(){
        HomePage_Aditya homePageAditya = new HomePage_Aditya(driver, wait);
        Assert.assertTrue(homePageAditya.checkLogo(), "Coursera logo is NOT visible on the homepage");

    }
}
