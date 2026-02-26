package testcases;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.HomePage;


import java.io.IOException;

public class TC_011_FooterCheck extends BaseTest {
    //Aditya
    HomePage homePage;

    @Test
    public void checkFooter(){
        homePage =new HomePage(driver,wait);
        Assert.assertTrue(homePage.footerCheck());
    }
}
