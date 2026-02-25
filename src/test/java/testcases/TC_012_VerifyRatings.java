package testcases;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.CourseDetailsPage;
import utilities.Log;

import java.io.IOException;
import java.util.List;

public class TC_012_VerifyRatings extends BaseTest {
    //Harsh
    CourseDetailsPage courseDetailsPage;
    @BeforeTest
    void setUp()
    {
        courseDetailsPage=new CourseDetailsPage(driver,wait);
    }
    @Test
    void checkForRating() throws IOException {
        List<String> ratingList = courseDetailsPage.fetchRatings();
        Assert.assertFalse(ratingList.isEmpty(), " No ratings found on course page");
        Log.info("Successfully fetched Ratings");
    }
}
