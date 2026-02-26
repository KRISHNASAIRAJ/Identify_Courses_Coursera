package testcases;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.ResultsPage;


public class TC_017_SortFunctionExistence extends BaseTest {
    //Harsh
    ResultsPage resultsPage;
    HomePage homePage;

    @Test
    void CheckForSortFunction() {
        homePage=new HomePage(driver,wait);
        homePage.sendInputToSearchBar("Web Development");
        resultsPage =new ResultsPage(driver,wait);
        Assert.assertTrue(resultsPage.filterAndSortVisible(),"Filter and Sort Button is not Visible");
        resultsPage.filterAndSortClick();
    }
}
