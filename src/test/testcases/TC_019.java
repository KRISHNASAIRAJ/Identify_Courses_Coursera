import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.Guidedproject;

public class TC_019 extends BaseTest {
    @Test
    public void testc19(){
        Guidedproject guidedproject= new Guidedproject(driver,wait);
        Assert.assertTrue(guidedproject.noinstallation());
    }

}
