package testcases;

import basetest.BaseTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.CourseDetailsPage;

public class TC_18_InstructorDetails extends BaseTest {
    CourseDetailsPage courseDetailsPage;
    @BeforeTest
    void setUp()
    {
        courseDetailsPage=new CourseDetailsPage(driver,wait);
    }

    @Test
    void getLinks()
    {
        courseDetailsPage.InstructorDetails();
    }
}
