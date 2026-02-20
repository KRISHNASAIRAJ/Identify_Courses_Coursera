package testcases;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.ResultsPage;

import java.io.IOException;

public class TC_024_getAllLanguagesAndLevels extends BaseTest {
    ResultsPage resultsPage;
    @BeforeTest
    void setUp(){
        resultsPage =new ResultsPage(driver,wait);
    }
    @Test(priority = 22)
    void getListOfLanguages() throws IOException {
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
