import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.Guidedproject;
import utilities.ConfigReader;

import java.io.IOException;

public class TC_020 extends BaseTest {
    @Test
    public void testurl() throws IOException {
        Guidedproject guidedproject= new Guidedproject(driver,wait);
        ConfigReader configReader= new ConfigReader();
        Assert.assertEquals(guidedproject.getURL(),configReader.getProp("URL"));
    }
}
