package testcases;

import basetest.BaseTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.CourseDetailsPage;

public class TC_012_VerifyRatings extends BaseTest {
    //Harsh
    CourseDetailsPage courseDetailsPage;
    @BeforeTest
    void setUp()
    {
        courseDetailsPage=new CourseDetailsPage(driver,wait);
    }
    @Test
    void CheckForRating()
    {
        courseDetailsPage.checkReviews();
    }
}
