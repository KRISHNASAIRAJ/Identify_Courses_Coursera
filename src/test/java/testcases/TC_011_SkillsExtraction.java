package testcases;

import basetest.BaseTest;
import org.testng.annotations.Test;
import pageObjects.CourseSearchPage;

public class TC_011_SkillsExtraction extends BaseTest {
    @Test
    public void extractSkills(){
        CourseSearchPage courserasearchresultspage =new CourseSearchPage(driver,wait);
        courserasearchresultspage.Gotogp();
        courserasearchresultspage.getSkills();
    }
}
