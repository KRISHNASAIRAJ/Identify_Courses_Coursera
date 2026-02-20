import basetest.BaseTest;
import org.testng.annotations.Test;
import pageObjects.Coursera_search_results_page;

public class TC_017_DurationLabelExtraction extends BaseTest {
    @Test
    public void extracttimeline() throws InterruptedException {
        Coursera_search_results_page courserasearchresultspage = new Coursera_search_results_page(driver,wait);
        courserasearchresultspage.getTimeline();
    }
}

