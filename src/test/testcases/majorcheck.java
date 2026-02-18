import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class majorcheck {
    @Test
    public void tests(){
        WebDriver driver= new ChromeDriver();
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
        JavascriptExecutor js=(JavascriptExecutor)driver;
        driver.manage().window().maximize();
        driver.get("https://www.coursera.org/");

        //external link test==>failed

        //C11 – Syllabus Expand/Collapse
        //Do: Expand each week/module in the course syllabus.
        //Assert: Module descriptions load without login.

        WebElement el= driver.findElement(By.xpath("//a[@class='cds-119 cds-113 cds-115 cds-CommonCard-titleLink css-fdx774 cds-142' and @id='cds-react-aria7889841089-:r7i:-product-card-title']"));
        wait.until(ExpectedConditions.visibilityOf(el));
        js.executeScript("arguments[0].scrollIntoView(true);",el);

        el.click();


    }
}
