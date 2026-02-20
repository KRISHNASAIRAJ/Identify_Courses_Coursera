import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.Coursera_search_results_page;
import utilities.ConfigReader;

import java.io.IOException;

public class TC_011_VerifyUrl extends BaseTest {
    @Test
    public void verifyURl() throws IOException {
        Coursera_search_results_page courserasearchresultspage = new Coursera_search_results_page(driver,wait);
        ConfigReader configReader= new ConfigReader();
        Assert.assertEquals(courserasearchresultspage.getURL(),configReader.getProp("URL"));
    }
}
