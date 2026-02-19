package testcases;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;

public class TC_021_checkLoginButtonEnabledOrNot extends BaseTest {
    @Test(priority = 21)
    void checkLoginButton(){
        HomePage homePage=new HomePage(driver,wait);
        Assert.assertTrue(homePage.isLoginButtonEnabled());
    }
}
