package testcases;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;

public class TC_02 extends BaseTest {
    @Test
    public void testSearchPartnerAndBadge(){
        HomePage homePage = new HomePage(driver,wait);
       //homePage.test2();
        Assert.assertTrue(homePage.test2());
    }
}
