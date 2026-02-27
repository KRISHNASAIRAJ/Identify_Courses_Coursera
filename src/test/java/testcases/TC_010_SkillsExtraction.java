package testcases;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.ResultsPage;

public class TC_010_SkillsExtraction extends BaseTest {
    //By Irfan
    ResultsPage resultsPage;
    HomePage homePage;
    @Test(priority = 15)
    public void extractSkills(){
        homePage=new HomePage(driver,wait);
        resultsPage=new ResultsPage(driver,wait);
        homePage.sendInputToSearchBar("Python");
        resultsPage.guidedProject();
        Assert.assertTrue(resultsPage.getSkills());
    }
}
