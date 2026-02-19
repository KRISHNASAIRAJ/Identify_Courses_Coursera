package testcases;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;

public class TC_026_checkLoginButtonEnabledOrNot extends BaseTest {
    @Test(priority = 26)
    void checkLoginButton(){
        HomePage homePage=new HomePage(driver,wait);
        Assert.assertTrue(homePage.isLoginButtonEnabled());
    }
}
