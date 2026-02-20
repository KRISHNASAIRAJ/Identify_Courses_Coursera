package testcases;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.ResultsPage;

import java.io.IOException;

public class TC_011_SkillsExtraction extends BaseTest {
    //By Irfan
    ResultsPage resultsPage;
    @BeforeTest
    void setUp() throws IOException {
        resultsPage =new ResultsPage(driver,wait);
    }
    @Test(priority = 11)
    public void extractSkills(){
        resultsPage.guidedProject();
        Assert.assertTrue(resultsPage.getSkills());
    }
}
