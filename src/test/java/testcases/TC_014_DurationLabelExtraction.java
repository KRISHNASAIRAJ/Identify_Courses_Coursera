package testcases;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.ResultsPage;

import java.io.IOException;

public class TC_014_DurationLabelExtraction extends BaseTest {
    //By Irfan
    ResultsPage resultsPage;
    @BeforeTest
    void setUp() throws IOException {
        resultsPage =new ResultsPage(driver,wait);
    }
    @Test
    public void extractTimeline() throws InterruptedException {
        Assert.assertTrue(resultsPage.getTimeline());
    }
}

