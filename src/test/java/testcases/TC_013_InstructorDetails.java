package testcases;

import basetest.BaseTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.CourseDetailsPage;
import pageObjects.HomePage;
import pageObjects.ResultsPage;

public class TC_013_InstructorDetails extends BaseTest {
    //Harsh
    CourseDetailsPage courseDetailsPage;
    HomePage homePage;
    ResultsPage resultsPage;
    @Test
    void getLinks() throws InterruptedException {
        homePage=new HomePage(driver,wait);
        resultsPage=new ResultsPage(driver,wait);
        courseDetailsPage=new CourseDetailsPage(driver,wait);
        homePage.sendInputToSearchBar("Python");
        resultsPage.guidedProject();
        courseDetailsPage.courseDetails();
        courseDetailsPage.instructorDetails();
    }
}
