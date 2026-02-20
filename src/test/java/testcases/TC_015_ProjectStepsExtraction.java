package testcases;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.CourseSearchPage;

public class TC_015_ProjectStepsExtraction extends BaseTest {
    @Test
    public void extractinstructions() throws InterruptedException {
        CourseSearchPage courserasearchresultspage = new CourseSearchPage(driver,wait);
        courserasearchresultspage.nextpage();
        Assert.assertTrue(courserasearchresultspage.stepByInstructionsCheck());

    }
}
