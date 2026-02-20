package testcases;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage_Aditya;

public class TC_06_verifyPartnerBadge extends BaseTest {
    @Test
    public void testSearchPartnerAndBadge(){
        HomePage_Aditya homePageAditya = new HomePage_Aditya(driver,wait);
       //homePageAditya.test2();
        Assert.assertTrue(homePageAditya.companyCourseName());
    }
}
