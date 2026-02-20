import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.Coursera_search_results_page;

public class TC_018_ProjectStepsExtraction extends BaseTest {
    @Test
    public void extractinstructions() throws InterruptedException {
        Coursera_search_results_page courserasearchresultspage = new Coursera_search_results_page(driver,wait);
        courserasearchresultspage.nextpage();
        Assert.assertTrue(courserasearchresultspage.stepByInstructionsCheck());

    }
}
