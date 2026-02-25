package testcases;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.DegreeCoursesPage;

public class TC_021_ProgramOverview extends BaseTest {
    //Krishna
    @Test(priority = 23)
    void programOverview() {
        DegreeCoursesPage obj=new DegreeCoursesPage(driver,wait);
        obj.findCourses();
        Assert.assertTrue(obj.isCourseNamePresent());
        Assert.assertTrue(obj.isUniversityNamePresent());
    }
}
