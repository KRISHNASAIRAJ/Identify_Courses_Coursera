package testcases;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.CourseDetailsPage;
import pageObjects.HomePage;
import pageObjects.ResultsPage;

public class TC_013_NoSetupGuarantee extends BaseTest {
    //By Irfan
    CourseDetailsPage courseDetailsPage;
    HomePage homePage;
    ResultsPage resultsPage;
    @Test(priority = 18)
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
