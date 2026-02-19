import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.Guidedproject;

public class TC_021 extends BaseTest {
    @Test
    public void verifytitle(){
        Guidedproject guidedproject= new Guidedproject(driver,wait);
        String actualTitle = guidedproject.getTitle();
        Assert.assertTrue(actualTitle.contains("Coursera"), "Page title does not contain expected text. Actual title: " + actualTitle);
    }
}
