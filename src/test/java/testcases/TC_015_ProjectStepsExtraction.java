package testcases;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.CourseDetailsPage;

import java.io.IOException;

public class TC_015_ProjectStepsExtraction extends BaseTest {
    //By Irfan
    CourseDetailsPage courseDetailsPage;
    @BeforeTest
    void setUp() throws IOException, InterruptedException {
        courseDetailsPage =new CourseDetailsPage(driver,wait);
    }
    @Test
    public void extractInstructions() throws InterruptedException {
        courseDetailsPage.courseDetails();
        Assert.assertTrue(courseDetailsPage.stepByInstructionsCheck());

    }
}
