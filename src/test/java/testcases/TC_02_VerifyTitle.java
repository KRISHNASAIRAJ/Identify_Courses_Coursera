package testcases;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.CourseSearchPage;
import pageObjects.HomePage;
import utilities.ConfigReader;

import java.io.IOException;

public class TC_02_VerifyTitle extends BaseTest {
    //By Irfan
    HomePage homePage;
    ConfigReader configReader;
    @BeforeTest
    void setUp() throws IOException {
        homePage =new HomePage(driver,wait);
        configReader=new ConfigReader();
    }
    @Test(priority = 2)
    public void verifyTitle(){
        String actualTitle = homePage.getTitle();
        Assert.assertTrue(actualTitle.contains("Coursera"), "Page title does not contain expected text. Actual title: " + actualTitle);
    }
}
