package testcases;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.ResultsPage;

public class TC_026_checkLoginButtonEnabledOrNot extends BaseTest {
    @Test(priority = 26)
    void checkLoginButton(){
        ResultsPage resultsPage =new ResultsPage(driver,wait);
        Assert.assertTrue(resultsPage.isLoginButtonEnabled());
    }
}
