import basetest.BaseTest;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.Guidedproject;

import java.time.Duration;
import java.util.List;

public class TC_017 extends BaseTest {
    @Test
    public void tests() throws InterruptedException {
        Guidedproject guidedproject= new Guidedproject(driver,wait);
        guidedproject.getTimeline();
    }
}

