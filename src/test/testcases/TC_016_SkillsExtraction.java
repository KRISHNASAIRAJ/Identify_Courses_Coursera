import basetest.BaseTest;
import org.testng.annotations.Test;
import pageObjects.Coursera_search_results_page;

public class TC_016_SkillsExtraction extends BaseTest {
    @Test
    public void extractskills(){
        Coursera_search_results_page courserasearchresultspage =new Coursera_search_results_page(driver,wait);
        courserasearchresultspage.Gotogp();
        courserasearchresultspage.getSkills();

    }
}
