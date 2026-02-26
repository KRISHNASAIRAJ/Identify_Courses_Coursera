package testcases;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;

public class TC_06_Verify10000Courses extends BaseTest {
    //Aditya
    HomePage homePage;
        @Test
        public void tenThousandAndFreeTrial() throws Exception {
            homePage = new HomePage(driver, wait);
            Assert.assertTrue(homePage.isTenThousandTextVisible(), "'10,000+' text is NOT visible on the homepage");
//            homePage.clickFreeTrialButton();
//            Assert.assertTrue(homePage.isFreeTrialPageOpens(),
//                    "Free Trial Not Opening");
        }

}
