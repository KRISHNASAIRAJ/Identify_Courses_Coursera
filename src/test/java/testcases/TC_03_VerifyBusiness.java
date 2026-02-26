package testcases;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;

public class TC_03_VerifyBusiness extends BaseTest {
    //By Aditya
    HomePage homePage;

    @Test(priority = 5)
    public void checkBusiness() throws Exception {
        homePage =new HomePage(driver,wait);
        Assert.assertTrue(homePage.businessTitle());
    }
    @Test(priority = 6)
    public void checkBusinessFunctionality(){
    Assert.assertTrue(homePage.businessHome());
    }
}
