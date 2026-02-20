package testcases;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.HomePage;

import java.io.IOException;

public class TC_05_VerifyBusiness extends BaseTest {
    //By Aditya
    HomePage homePage;
    @BeforeTest
    void setUp() throws IOException {
        homePage =new HomePage(driver,wait);
    }
    @Test
    public void checkBusiness() throws Exception {
        Assert.assertTrue(homePage.businessTitle());

    }
    @Test
    public void checkBusinessFunctionality(){
    Assert.assertTrue(homePage.businessHome());
    }
}
