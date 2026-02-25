package testcases;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.ResultsPage;

public class TC_019_CheckFAQ extends BaseTest {
    //Harsh
    ResultsPage resultsPage;
    @BeforeTest
    void setUp()
    {
        resultsPage=new ResultsPage(driver,wait);
    }

    @Test(priority = 21)
    void CheckForFaq()
    {
        Assert.assertTrue(resultsPage.clickCourse_Switch_CheckFAQ_Return(),"FAQ section is not displayed");
    }
}
