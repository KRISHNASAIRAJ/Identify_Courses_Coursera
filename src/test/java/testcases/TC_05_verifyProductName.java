package testcases;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage_Aditya;

import java.io.IOException;

public class TC_05_verifyProductName extends BaseTest {

        @Test(priority = 0)
        public void testSearchProductName() throws IOException {
            HomePage_Aditya homePageAditya =new HomePage_Aditya(driver,wait);
            homePageAditya.searchAndLoadCards();

        }

}
