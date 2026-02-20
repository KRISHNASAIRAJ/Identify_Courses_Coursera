package testcases;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage_Aditya;

public class TC_03_Verify10000Courses extends BaseTest {
        @Test
        public void tenThousandAndFreeTrial() throws Exception {
            HomePage_Aditya homepage = new HomePage_Aditya(driver, wait);
            Assert.assertTrue(homepage.isTenThousandTextVisible(), "'10,000+' text is NOT visible on the homepage");
            homepage.clickFreeTrialButton();
            Assert.assertTrue(homepage.isFreeTrialPageOpens(),
                    "Free Trial Not Opening");
        }

}
