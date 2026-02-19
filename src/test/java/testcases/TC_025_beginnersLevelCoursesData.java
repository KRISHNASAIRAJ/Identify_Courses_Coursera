package testcases;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.Base;
import pageObjects.HomePage;

import java.io.IOException;

public class TC_025_beginnersLevelCoursesData extends BaseTest {
    HomePage homePage;
    @BeforeTest
    void setUp(){
        homePage=new HomePage(driver,wait);
    }
    @Test(priority = 21)
    void searchBarFunctionality(){
        Assert.assertTrue(homePage.searchBarVisibility());
        homePage.sendInputToSearchBar("Web Development");
    }
    @Test(priority = 22)
    void difficultyLevelFunctionality(){
        Assert.assertTrue(homePage.difficultyLevelVisibility());
        homePage.selectDifficultyLevel("Beginner");
    }
    @Test(priority = 23)
    void viewButtonFunctionality(){
        Assert.assertTrue(homePage.isViewButtonEnabled());
        homePage.clickViewButton();
    }
    @Test(priority = 24)
    void languageOptionsFunctionality(){
        Assert.assertTrue(homePage.areLanguageOptionsClickable());
        homePage.selectLanguage("English");
        homePage.clickViewButton();
    }
    @Test(priority = 25)
    void beginnersLevelCoursesData() throws IOException {
        homePage.getListOfTitles();
    }
}
