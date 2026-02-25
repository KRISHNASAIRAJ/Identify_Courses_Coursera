package testcases;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.ResultsPage;

import java.io.IOException;

public class TC_08_SkillsExtraction extends BaseTest {
    //By Irfan
    ResultsPage resultsPage;
    HomePage homePage;

    @Test(priority = 11)
    public void extractSkills(){
        homePage=new HomePage(driver,wait);
        resultsPage=new ResultsPage(driver,wait);
        homePage.sendInputToSearchBar("Python");
        resultsPage.guidedProject();
        Assert.assertTrue(resultsPage.getSkills());
    }
}
