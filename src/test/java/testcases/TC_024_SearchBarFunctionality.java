package testcases;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.ResultsPage;

public class TC_024_SearchBarFunctionality extends BaseTest {
    HomePage homePage;
    @BeforeTest
    void setUp(){
        homePage =new HomePage(driver,wait);
    }
    @Test(priority = 21)
    void searchBarFunctionality(){
        Assert.assertTrue(homePage.searchBarVisibility());
        homePage.sendInputToSearchBar("Web Development");
    }
}
