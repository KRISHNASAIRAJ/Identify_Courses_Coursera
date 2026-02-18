package testcases;

import basetest.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.DegreeCoursesPage;

import java.util.Set;

public class TC_021 extends BaseTest {
    @Test(priority = 21)
    void programOverview() throws InterruptedException {
        DegreeCoursesPage obj=new DegreeCoursesPage(driver,wait);
        obj.find_courses();
        Assert.assertTrue(obj.isCourseNamePresent());
        Assert.assertTrue(obj.isUniversityNamePresent());
    }
}
