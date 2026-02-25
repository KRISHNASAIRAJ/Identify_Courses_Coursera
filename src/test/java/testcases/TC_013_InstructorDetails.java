package testcases;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.CourseDetailsPage;
import utilities.Log;

import java.io.IOException;
import java.util.List;

public class TC_013_InstructorDetails extends BaseTest {
    //Harsh
    CourseDetailsPage courseDetailsPage;
    @BeforeTest
    void setUp()
    {
        courseDetailsPage=new CourseDetailsPage(driver,wait);
    }

    @Test
    void getInstructorDetails() throws IOException {
        List<String> details = courseDetailsPage.instructorDetails();
        Assert.assertFalse(details.isEmpty(), "Instructor details not found!");
        Log.info("Successfully fetched Instructor details");
    }
}
