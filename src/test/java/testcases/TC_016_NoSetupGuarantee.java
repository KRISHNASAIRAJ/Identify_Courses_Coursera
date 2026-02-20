package testcases;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.CourseSearchPage;

public class TC_016_NoSetupGuarantee extends BaseTest {
    @Test
    public void noinstallationCheck(){
        CourseSearchPage courserasearchresultspage = new CourseSearchPage(driver,wait);
        Assert.assertTrue(courserasearchresultspage.noinstallation());
    }

}
