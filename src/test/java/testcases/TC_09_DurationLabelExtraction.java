package testcases;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.ResultsPage;

import java.io.IOException;

public class TC_09_DurationLabelExtraction extends BaseTest {
    //By Irfan
    ResultsPage resultsPage;
    HomePage homePage;

    @Test
    public void extractTimeline() {
        homePage=new HomePage(driver,wait);
        resultsPage=new ResultsPage(driver,wait);
        homePage.sendInputToSearchBar("Python");
        resultsPage.guidedProject();
        Assert.assertTrue(resultsPage.getTimeline());
    }
}

