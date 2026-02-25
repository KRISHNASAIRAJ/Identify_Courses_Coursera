package testcases;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.ResultsPage;
import utilities.Log;

public class TC_019_CheckFAQ extends BaseTest {
    //Harsh
    ResultsPage resultsPage;
    @BeforeTest
    void setUp()
    {
        resultsPage=new ResultsPage(driver,wait);
    }

    @Test
    void checkForFaq()
    {
        Assert.assertTrue(resultsPage.clickCourseSwitchCheckFAQReturn(),"FAQ section is not displayed");
        Log.info("FAQ verification completed");
    }
}
