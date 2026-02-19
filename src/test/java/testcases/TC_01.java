package testcases;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;

public class TC_01 extends BaseTest {

        @Test(priority = 0)
        public void testSearchProductName(){
            HomePage homePage=new HomePage(driver,wait);
            homePage.searchAndLoadCards();
            //Assert.assertTrue(homePage.test11());
        }

}
