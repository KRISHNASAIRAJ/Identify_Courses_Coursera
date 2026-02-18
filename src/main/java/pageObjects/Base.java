package pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utilities.ConfigReader;

import java.io.IOException;
import java.security.Key;
import java.time.Duration;
import java.util.List;

public class Base {
    protected WebDriver driver;
    protected WebDriverWait wait;
    public Base(WebDriver driver,WebDriverWait wait){
        this.driver=driver;
        this.wait=wait;
    }
    @Test
    public void test() throws IOException {
        By search_bar= By.id("search-autocomplete-input");
        wait.until(ExpectedConditions.visibilityOfElementLocated(search_bar));
        driver.findElement(search_bar).sendKeys("Web Development");
        driver.findElement(search_bar).sendKeys(Keys.ENTER);
        By difficulty_level=By.xpath("//button[@data-testid='filter-dropdown-productDifficultyLevel']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(difficulty_level)).click();
        By beginner_option=By.xpath("//span[text()='Beginner']");
        driver.findElement(beginner_option).click();
        By view_btn=By.xpath("//span[text()='View']");
        driver.findElement(view_btn).click();
        By language=By.xpath("//button[@data-testid='filter-dropdown-language']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(language)).click();
        By english_lang=By.xpath("//span[text()='English']");
        driver.findElement(english_lang).click();
        driver.findElement(view_btn).click();
        By title=By.xpath("//h3[starts-with(@class,'cds-CommonCard-title')]");
        List<WebElement> titles=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(title));

    }
}
