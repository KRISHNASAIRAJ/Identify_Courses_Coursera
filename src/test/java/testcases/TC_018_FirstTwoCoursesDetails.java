package testcases;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.ResultsPage;

import java.io.IOException;

public class TC_018_FirstTwoCoursesDetails extends BaseTest {
    //Krishna
    ResultsPage resultsPage;
    HomePage homePage;
    @Test(priority = 25)
    void difficultyLevelFunctionality(){
        homePage=new HomePage(driver,wait);
        resultsPage =new ResultsPage(driver,wait);
        homePage.sendInputToSearchBar("Web Development");
        Assert.assertTrue(resultsPage.difficultyLevelVisibility());
        resultsPage.selectDifficultyLevel("Beginner");
        resultsPage.clickViewButton();
    }

    @Test(priority = 26)
    void languageOptionsFunctionality(){
        Assert.assertTrue(resultsPage.areLanguageOptionsClickable());
        resultsPage.selectLanguage("English");
        resultsPage.clickViewButton();
    }

    @Test(priority = 27)
    void beginnersLevelCoursesData() throws IOException {
        resultsPage.getListOfTitles();
    }
}
