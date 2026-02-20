package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;
    @FindBy(xpath = "//a[@data-click-key='front_page.front_page_story.click.navigation_meta_nav_Individuals']")
    WebElement logo ;
    @FindBy(id = "search-autocomplete-input")
    WebElement searchBar;
    @FindBy(xpath = "//button[@id='ior2l']")
    WebElement notNow;
    public HomePage(WebDriver driver, WebDriverWait wait) {
        this.driver=driver;
        this.wait=wait;
        PageFactory.initElements(driver,this);
    }

    public String getURL(){
        return driver.getCurrentUrl();
    }
    public  String getTitle(){
        return driver.getTitle();
    }
    public boolean checkLogo(){
        return logo.isDisplayed();
    }

    public boolean searchBarVisibility(){
        return wait.until(ExpectedConditions.visibilityOf(searchBar)).isDisplayed();
    }
    public void sendInputToSearchBar(String input){
        searchBar.sendKeys(input);
        searchBar.sendKeys(Keys.ENTER);
    }
    public void dismissPopup(){
        wait.until(ExpectedConditions.elementToBeClickable((By) notNow)).click();
    }


}
