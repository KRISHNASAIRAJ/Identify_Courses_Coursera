package testcases;

import basetest.BaseTest;
import org.testng.annotations.Test;
import pageObjects.HomePage_Aditya;

public class TC_04_verifyBusiness extends BaseTest {
    @Test
    public void FreeTrial() throws Exception {
        HomePage_Aditya homepage = new HomePage_Aditya(driver, wait);

    }
}
