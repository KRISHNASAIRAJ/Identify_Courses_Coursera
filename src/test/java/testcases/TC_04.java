package testcases;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;

public class TC_04 extends BaseTest {
    @Test
    void testCheckLevels(){
        HomePage homePage = new HomePage(driver,wait);
        Assert.assertTrue(homePage.courseLevel());
    }
}
