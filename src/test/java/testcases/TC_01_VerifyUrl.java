package testcases;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import utilities.ConfigReader;

import java.io.IOException;

public class TC_01_VerifyUrl extends BaseTest {
    //By Irfan
    HomePage homePage;
    ConfigReader configReader;
    @BeforeTest
    void setUp() throws IOException {
        homePage =new HomePage(driver,wait);
        configReader=new ConfigReader();
    }
    @Test(priority = 1)
    public void verifyURl() throws IOException {
        Assert.assertEquals(homePage.getURL(),configReader.getProp("URL"));
    }
}
