package testcases;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import utilities.CommonCode;

import java.io.IOException;

public class TC_023_SearchBarFunctionality extends BaseTest {
    HomePage homePage;
    CommonCode commonCode;
    @BeforeTest
    void setUp(){
        homePage =new HomePage(driver,wait);
        commonCode=new CommonCode(driver,wait);
    }
    @Test(priority = 21)
    void searchBarFunctionality() throws IOException {
        Assert.assertTrue(homePage.searchBarVisibility());
        commonCode.takeScreenshot();
        homePage.sendInputToSearchBar("Web Development");
    }
}
