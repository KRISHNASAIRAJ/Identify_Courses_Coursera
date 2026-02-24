package testcases;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.ResultsPage;

public class TC_19_CheckFaq extends BaseTest {
    ResultsPage resultsPage;

    @BeforeTest
    void setUp()
    {
        resultsPage=new ResultsPage(driver,wait);
    }

    @Test
    void CheckForFaq()
    {
        Assert.assertTrue(resultsPage.clickCourse_Switch_CheckFAQ_Return(),"FAQ section is not displayed");
    }
}
