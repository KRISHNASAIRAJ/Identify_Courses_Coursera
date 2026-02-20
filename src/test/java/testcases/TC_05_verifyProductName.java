package testcases;

import basetest.BaseTest;
import org.testng.annotations.Test;
import pageObjects.HomePage_Aditya;

public class TC_05_verifyProductName extends BaseTest {

        @Test(priority = 0)
        public void testSearchProductName(){
            HomePage_Aditya homePageAditya =new HomePage_Aditya(driver,wait);
            homePageAditya.searchAndLoadCards();
            //Assert.assertTrue(homePageAditya.test11());
        }

}
