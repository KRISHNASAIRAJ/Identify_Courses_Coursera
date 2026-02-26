package testcases;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.CourseDetailsPage;
import pageObjects.HomePage;
import pageObjects.ResultsPage;
import utilities.Log;

import java.io.IOException;
import java.util.List;

public class TC_013_InstructorDetails extends BaseTest {
    //Harsh
    CourseDetailsPage courseDetailsPage;
    HomePage homePage;
    ResultsPage resultsPage;
    @Test
    void getLinks() throws InterruptedException, IOException {
        homePage=new HomePage(driver,wait);
        resultsPage=new ResultsPage(driver,wait);
        courseDetailsPage=new CourseDetailsPage(driver,wait);
        homePage.sendInputToSearchBar("Python");
        resultsPage.guidedProject();
        courseDetailsPage.courseDetails();
        List<String> details = courseDetailsPage.instructorDetails();
        Assert.assertFalse(details.isEmpty(), "Instructor details not found!");
        Log.info("Successfully fetched Instructor details");
    }
}
