package testcases;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.ResultsPage;

import java.io.IOException;

public class TC_016_GetAllLanguagesAndLevels extends BaseTest {
    //Krishna
    ResultsPage resultsPage;
    HomePage homePage;

    @Test(priority = 22)
    void getListOfLanguages() throws IOException {
        homePage=new HomePage(driver,wait);
        homePage.sendInputToSearchBar("Web Development");
        resultsPage =new ResultsPage(driver,wait);
        Assert.assertTrue(resultsPage.areLanguageOptionsClickable());
        resultsPage.getLanguages();
    }
    @Test(priority = 23)
    void viewButtonFunctionality(){
        Assert.assertTrue(resultsPage.isViewButtonEnabled());
        resultsPage.clickViewButton();
    }
    @Test(priority = 24)
    void getListOfLevels() throws IOException {
        Assert.assertTrue(resultsPage.difficultyLevelVisibility());
        resultsPage.getLevels();
        resultsPage.clickViewButton();
    }
}
