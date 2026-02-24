package testcases;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.ResultsPage;

public class TC_020_CheckLoginButtonEnabledOrNot extends BaseTest {
    //Aditya
    @Test(priority = 28)
    void checkLoginButton(){
        ResultsPage resultsPage =new ResultsPage(driver,wait);
        Assert.assertTrue(resultsPage.isLoginButtonEnabled());
    }
}
