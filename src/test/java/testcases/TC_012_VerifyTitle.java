package testcases;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.CourseSearchPage;

public class TC_012_VerifyTitle extends BaseTest {
    @Test
    public void verifytitle(){
        CourseSearchPage courserasearchresultspage = new CourseSearchPage(driver,wait);
        String actualTitle = courserasearchresultspage.getTitle();
        Assert.assertTrue(actualTitle.contains("Coursera"), "Page title does not contain expected text. Actual title: " + actualTitle);
    }
}
