package testcases;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.ResultsPage;

public class TC_020_CheckLoginButtonEnabledOrNot extends BaseTest {
    //Aditya
    ResultsPage resultsPage;
    @Test(priority = 29)
    void checkLoginButton(){
        resultsPage =new ResultsPage(driver,wait);
        Assert.assertTrue(resultsPage.isLoginButtonEnabled());
    }
}
