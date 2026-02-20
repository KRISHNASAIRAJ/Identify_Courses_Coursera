package testcases;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;

public class TC_06_Verify10000Courses extends BaseTest {
        @Test
        public void tenThousandAndFreeTrial() throws Exception {
            HomePage homepage = new HomePage(driver, wait);
            Assert.assertTrue(homepage.isTenThousandTextVisible(), "'10,000+' text is NOT visible on the homepage");
            homepage.clickFreeTrialButton();
            Assert.assertTrue(homepage.isFreeTrialPageOpens(),
                    "Free Trial Not Opening");
        }

}
