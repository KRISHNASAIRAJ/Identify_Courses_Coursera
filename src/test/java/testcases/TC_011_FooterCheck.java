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
    @BeforeTest
    void setUp() throws IOException {
        homePage =new HomePage(driver,wait);
    }
    @Test
    public void checkFooter(){
        Assert.assertTrue(homePage.footerCheck());
    }
}
