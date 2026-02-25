package testcases;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import utilities.CommonCode;

import java.io.IOException;

public class TC_015_SearchBarFunctionality extends BaseTest {
    //Krishna
    HomePage homePage;
    @BeforeTest
    void setUp(){
        homePage =new HomePage(driver,wait);
    }
    @Test(priority = 21)
    void searchBarFunctionality() throws IOException {
        Assert.assertTrue(homePage.searchBarVisibility());
        homePage.sendInputToSearchBar("Web Development");
    }
}
