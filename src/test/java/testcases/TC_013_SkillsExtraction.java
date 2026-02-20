package testcases;

import basetest.BaseTest;
import org.testng.annotations.Test;
import pageObjects.CourseSearchPage;

public class TC_013_SkillsExtraction extends BaseTest {
    @Test
    public void extractskills(){
        CourseSearchPage courserasearchresultspage =new CourseSearchPage(driver,wait);
        courserasearchresultspage.Gotogp();
        courserasearchresultspage.getSkills();
    }
}
