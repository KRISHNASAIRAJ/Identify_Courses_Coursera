package testcases;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;

public class TC_04_VerifyLoginAndEmail extends BaseTest {
    @Test
    public void testLogInAndEmailLabel() throws Exception {
        HomePage homePage = new HomePage(driver,wait);
        Assert.assertTrue(homePage.isLogInButtonClickable(wait), "Log In button is NOT clickable on the homepage");
        homePage.clickLogInButton();
        Assert.assertTrue(homePage.isEmailLabelVisible(wait), "Email label is NOT visible after clicking Log In button");
        homePage.closeLoginForm();

    }
}
