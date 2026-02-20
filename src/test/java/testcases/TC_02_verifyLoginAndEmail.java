package testcases;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.HomePage_Aditya;

public class TC_02_verifyLoginAndEmail extends BaseTest {
    @Test
    public void testLogInAndEmailLabel() throws Exception {
        HomePage_Aditya homePage = new HomePage_Aditya(driver,wait);
        Assert.assertTrue(homePage.isLogInButtonClickable(wait), "'Log In' button is NOT clickable on the homepage");
        homePage.clickLogInButton();
        Assert.assertTrue(homePage.isEmailLabelVisible(wait), "Email label is NOT visible after clicking 'Log In' button");
    }
}
