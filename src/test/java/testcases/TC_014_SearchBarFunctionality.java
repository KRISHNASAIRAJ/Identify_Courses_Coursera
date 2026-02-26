package testcases;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import utilities.CommonCode;

import java.io.IOException;

public class TC_014_SearchBarFunctionality extends BaseTest {
    //Harsh
    HomePage homePage;
    CommonCode commonCode;
    @Test(priority = 21)
    void searchBarFunctionalityWithValidInput() throws IOException {
        homePage =new HomePage(driver,wait);
        Assert.assertTrue(homePage.searchBarVisibility());
        homePage.sendInputToSearchBar("Web Development");
    }
    @Test(priority = 22)
    void searchBarFunctionalityWithInvalidInput() throws IOException {
        commonCode=new CommonCode(driver,wait);
        homePage =new HomePage(driver,wait);
        Assert.assertTrue(homePage.searchBarVisibility());
        Assert.assertTrue(homePage.searchWithInvalid("unknowcoursetext"));
    }
}
