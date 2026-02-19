import basetest.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.Guidedproject;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class TC_018 extends BaseTest {
    @Test
    public void tests() throws InterruptedException {
        Guidedproject guidedproject = new Guidedproject(driver,wait);
        guidedproject.nextpage();
        Assert.assertTrue(guidedproject.stepByInstructionsCheck());

    }
}
