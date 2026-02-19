import basetest.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class TC_016 extends BaseTest {
    @Test
    public void test16(){
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
        JavascriptExecutor js=(JavascriptExecutor)driver;

        WebElement inp=driver.findElement(By.xpath("//input[@name='query']"));
        inp.sendKeys("Python");
        inp.sendKeys(Keys.ENTER);
        WebElement gp=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-testid='filter-dropdown-productTypeDescription']")));
        gp.click();
        WebElement guidedprojselect=driver.findElement(By.xpath("//span[text()='Guided Projects']"));
        guidedprojselect.click();


        WebElement viewbtn=driver.findElement(By.xpath("//span[contains(@class,'cds-button-label') and contains(.,'View')]"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@class,'cds-button-label') and contains(.,'View')]")));
        viewbtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("cds-ProductCard-content")));
        List<WebElement> l= driver.findElements(By.className("cds-ProductCard-content"));
        for(WebElement search: l){
            WebElement prod =search.findElement(By.className("cds-ProductCard-body"));
            String str= prod.getText();
            // Assert that skills are displayed
             Assert.assertTrue(prod.isDisplayed(), "Skills section is not displayed");
             Assert.assertFalse(str.isEmpty(), "Skills section is empty");
        }
    }
}
