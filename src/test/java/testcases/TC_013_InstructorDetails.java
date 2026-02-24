package testcases;

import basetest.BaseTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.CourseDetailsPage;

public class TC_013_InstructorDetails extends BaseTest {
    //Harsh
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
