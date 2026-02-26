package testcases;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.CourseDetailsPage;
import pageObjects.HomePage;
import pageObjects.ResultsPage;
import utilities.Log;

import java.io.IOException;
import java.util.List;

public class TC_014_VerifyRatings extends BaseTest {
    //Harsh
    CourseDetailsPage courseDetailsPage;
    HomePage homePage;
    ResultsPage resultsPage;

    @Test(priority = 19)
    void CheckForRating() throws InterruptedException, IOException {
        homePage=new HomePage(driver,wait);
        resultsPage=new ResultsPage(driver,wait);
        courseDetailsPage=new CourseDetailsPage(driver,wait);
        homePage.sendInputToSearchBar("Python");
        resultsPage.guidedProject();
        courseDetailsPage.courseDetails();
        List<String> ratingList = courseDetailsPage.fetchRatings();
        Assert.assertFalse(ratingList.isEmpty(), " No ratings found on course page");
        Log.info("Successfully fetched Ratings");
    }
}
