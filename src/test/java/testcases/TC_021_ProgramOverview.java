package testcases;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.DegreeCoursesPage;
import pageObjects.HomePage;

public class TC_021_ProgramOverview extends BaseTest {
    //Krishna
    DegreeCoursesPage degreeCoursesPage;
    HomePage homePage;
    @Test(priority = 30)
    void programOverview() {
        homePage=new HomePage(driver,wait);
        degreeCoursesPage=new DegreeCoursesPage(driver,wait);
        degreeCoursesPage.findCourses();
        Assert.assertTrue(degreeCoursesPage.isCourseNamePresent());
        Assert.assertTrue(degreeCoursesPage.isUniversityNamePresent());
    }
}
