package testcases;

import basetest.BaseTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.CourseDetailsPage;
import pageObjects.HomePage;
import pageObjects.ResultsPage;

public class TC_17_VerifyRatings extends BaseTest {
    HomePage homePage;
    ResultsPage resultsPage;
    CourseDetailsPage courseDetailsPage;

    @BeforeTest
    void setUp()
    {
//        homePage=new HomePage(driver,wait);
//        resultsPage=new ResultsPage(driver,wait);
        courseDetailsPage=new CourseDetailsPage(driver,wait);
    }

    @Test
    void CheckForRating()
    {
        courseDetailsPage.CheckReviews();
    }
}
