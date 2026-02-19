package pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utilities.ConfigReader;

import java.io.IOException;
import java.security.Key;
import java.time.Duration;
import java.util.List;

public class Base {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(id = "search-autocomplete-input")
    WebElement searchBar;
    @FindBy(xpath = "//button[@data-testid='filter-dropdown-productDifficultyLevel']")
    WebElement difficultyLevel;
    @FindBy(xpath = "//span[text()='View']")
    WebElement viewBtn;
    @FindBy(xpath = "//button[@data-testid='filter-dropdown-language']")
    WebElement languageOptions;
    @FindBy(xpath = "//h3[starts-with(@class,'cds-CommonCard-title')]")
    List<WebElement> title;
    public Base(WebDriver driver,WebDriverWait wait){
        this.driver=driver;
        this.wait=wait;
    }


    public void test() {
//        wait.until(ExpectedConditions.visibilityOf(searchBar));
//        (searchBar).sendKeys("Web Development");
//        (searchBar).sendKeys(Keys.ENTER);
//        wait.until(ExpectedConditions.visibilityOf(difficultyLevel)).click();
//        By beginner_option=By.xpath("//span[text()='Beginner']");
//        driver.findElement(beginner_option).click();
//        (viewBtn).click();
//        wait.until(ExpectedConditions.visibilityOf(languageOptions)).click();
//        By english_lang=By.xpath("//span[text()='English']");
//        driver.findElement(english_lang).click();
//        driver.findElement(viewBtn).click();
//        List<WebElement> titles=wait.until(ExpectedConditions.visibilityOfAllElements(title));

    }
}
