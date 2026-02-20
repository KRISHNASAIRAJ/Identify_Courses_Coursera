package testcases;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.DegreeCoursesPage;

public class TC_027_programOverview extends BaseTest {
    @Test(priority = 29)
    void programOverview() throws InterruptedException {
        DegreeCoursesPage obj=new DegreeCoursesPage(driver,wait);
        obj.find_courses();
        Assert.assertTrue(obj.isCourseNamePresent());
        Assert.assertTrue(obj.isUniversityNamePresent());
    }
}
