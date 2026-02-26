package testcases;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.CourseDetailsPage;
import pageObjects.HomePage;
import pageObjects.ResultsPage;

public class TC_019_CheckFAQ extends BaseTest {
    //Harsh
    ResultsPage resultsPage;
    HomePage homePage;
    CourseDetailsPage courseDetailsPage;

    @Test(priority = 21)
    void CheckForFaq() throws InterruptedException {
        homePage=new HomePage(driver,wait);
        resultsPage=new ResultsPage(driver,wait);
        courseDetailsPage=new CourseDetailsPage(driver,wait);
        homePage.sendInputToSearchBar("Web Development");
        resultsPage.selectDifficultyLevel("Beginner");
        resultsPage.clickViewButton();
        resultsPage.filterAndSortClick();
        Assert.assertTrue(resultsPage.clickCourseSwitchCheckFAQReturn(),"FAQ section is not displayed");
    }
}
