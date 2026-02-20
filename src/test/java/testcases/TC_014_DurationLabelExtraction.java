package testcases;

import basetest.BaseTest;
import org.testng.annotations.Test;
import pageObjects.CourseSearchPage;

public class TC_014_DurationLabelExtraction extends BaseTest {
    @Test
    public void extracttimeline() throws InterruptedException {
        CourseSearchPage courserasearchresultspage = new CourseSearchPage(driver,wait);
        courserasearchresultspage.getTimeline();
    }
}

