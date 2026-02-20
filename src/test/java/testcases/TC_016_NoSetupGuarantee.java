package testcases;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.CourseDetailsPage;

import java.io.IOException;

public class TC_016_NoSetupGuarantee extends BaseTest {
    //By Irfan
    CourseDetailsPage courseDetailsPage;
    @BeforeTest
    void setUp() throws IOException {
        courseDetailsPage =new CourseDetailsPage(driver,wait);
    }
    @Test
    public void noInstallationCheck(){
        Assert.assertTrue(courseDetailsPage.noInstallation());
    }

}
