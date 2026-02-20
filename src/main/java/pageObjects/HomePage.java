package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;
    @FindBy(id = "search-autocomplete-input")
    WebElement searchBar;

    public HomePage(WebDriver driver, WebDriverWait wait) {
        this.driver=driver;
        this.wait=wait;
        PageFactory.initElements(driver,this);
    }

    public boolean searchBarVisibility(){
        return wait.until(ExpectedConditions.visibilityOf(searchBar)).isDisplayed();
    }
    public void sendInputToSearchBar(String input){
        searchBar.sendKeys(input);
        searchBar.sendKeys(Keys.ENTER);
    }
}
