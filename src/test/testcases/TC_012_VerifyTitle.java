import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.Coursera_search_results_page;

public class TC_012_VerifyTitle extends BaseTest {
    @Test
    public void verifytitle(){
        Coursera_search_results_page courserasearchresultspage = new Coursera_search_results_page(driver,wait);
        String actualTitle = courserasearchresultspage.getTitle();
        Assert.assertTrue(actualTitle.contains("Coursera"), "Page title does not contain expected text. Actual title: " + actualTitle);
    }
}
