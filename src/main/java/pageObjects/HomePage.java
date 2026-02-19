package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;
    @FindBy(id = "search-autocomplete-input")
    WebElement searchBar;
    @FindBy(xpath = "//button[@data-testid='filter-dropdown-productDifficultyLevel']")
    WebElement difficultyLevel;
    @FindBy(xpath = "//span[text()='View']")
    WebElement viewBtn;
    @FindBy(xpath = "//a[@data-e2e='header-login-button']")
    WebElement loginButton;
    @FindBy(xpath = "//button[@data-testid='filter-dropdown-language']")
    WebElement languageOptions;
    @FindBy(xpath = "//h3[starts-with(@class,'cds-CommonCard-title')]")
    List<WebElement> title;
    public HomePage(WebDriver driver,WebDriverWait wait){
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
    public boolean difficultyLevelVisibility(){
        return wait.until(ExpectedConditions.visibilityOf(difficultyLevel)).isDisplayed();
    }
    public void selectDifficultyLevel(String difficultyInput){
        difficultyLevel.click();
        By beginnerOption=By.xpath("//span[text()='"+difficultyInput+"']");
        driver.findElement(beginnerOption).click();
    }
    public boolean isViewButtonEnabled(){
        return wait.until(ExpectedConditions.visibilityOf(viewBtn)).isDisplayed();
    }
    public void clickViewButton(){
        viewBtn.click();
    }

    public boolean areLanguageOptionsClickable(){
        //clickable
        return wait.until(ExpectedConditions.elementToBeClickable(languageOptions)).isEnabled();
    }
    public void selectLanguage(String language){
        languageOptions.click();
        By englishLanguage =By.xpath("//span[text()='"+language+"']");
        driver.findElement(englishLanguage).click();
    }

    public void getListOfTitles(){
        List<WebElement> titles=wait.until(ExpectedConditions.visibilityOfAllElements(title));
        for(WebElement title:titles){
            System.out.println(title.getText());
        }
    }

    public boolean isLoginButtonEnabled(){
        return (wait.until(ExpectedConditions.elementToBeClickable(loginButton)).isEnabled());
    }
}
