import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.Coursera_search_results_page;

public class TC_019_NoSetupGuarantee extends BaseTest {
    @Test
    public void noinstallationCheck(){
        Coursera_search_results_page courserasearchresultspage = new Coursera_search_results_page(driver,wait);
        Assert.assertTrue(courserasearchresultspage.noinstallation());
    }

}
