import basetest.BaseTest;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Tc_c17 extends BaseTest {
    @Test
    public void tests() throws InterruptedException {
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
            String str=search.findElement(By.xpath("//div[@class='cds-CommonCard-metadata']")).getText();
            Assert.assertEquals(str.contains("Less Than 2 Hours"),true);
        }



        }



    }

