package testcases;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.CourseSearchPage;
import utilities.ConfigReader;

import java.io.IOException;

public class TC_011_VerifyUrl extends BaseTest {
    @Test
    public void verifyURl() throws IOException {
        CourseSearchPage courserasearchresultspage = new CourseSearchPage(driver,wait);
        ConfigReader configReader= new ConfigReader();
        Assert.assertEquals(courserasearchresultspage.getURL(),configReader.getProp("URL"));
    }
}
