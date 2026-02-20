package testcases;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage_Aditya;

public class TC_07_verifyReviews extends BaseTest {
    @Test
        public void testCheckReviews(){
            HomePage_Aditya homePageAditya = new HomePage_Aditya(driver,wait);
            Assert.assertTrue(homePageAditya.courseReviews());
        }
}
