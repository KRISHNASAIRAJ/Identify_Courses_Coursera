package testcases;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;

public class TC_03 extends BaseTest {
    @Test
        public void testCheckReviews(){
            HomePage homePage = new HomePage(driver,wait);
            Assert.assertTrue(homePage.courseReviews());
        }
}
