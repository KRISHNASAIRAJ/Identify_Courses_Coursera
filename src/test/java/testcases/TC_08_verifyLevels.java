package testcases;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage_Aditya;

public class TC_08_verifyLevels extends BaseTest {
    @Test
    void testCheckLevels(){
        HomePage_Aditya homePageAditya = new HomePage_Aditya(driver,wait);
        Assert.assertTrue(homePageAditya.courseLevel());
    }
}
