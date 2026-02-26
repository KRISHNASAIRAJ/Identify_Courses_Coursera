package testcases;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.CourseDetailsPage;
import pageObjects.HomePage;
import pageObjects.ResultsPage;

import java.io.IOException;

public class TC_011_NoSetupGuarantee extends BaseTest {
    //By Irfan
    CourseDetailsPage courseDetailsPage;
    HomePage homePage;
    ResultsPage resultsPage;
    @Test
    public void noInstallationCheck() throws InterruptedException {
        homePage=new HomePage(driver,wait);
        resultsPage=new ResultsPage(driver,wait);
        courseDetailsPage=new CourseDetailsPage(driver,wait);
        homePage.sendInputToSearchBar("Python");
        resultsPage.guidedProject();
        courseDetailsPage.courseDetails();
        Assert.assertTrue(courseDetailsPage.noInstallation());
    }

}
