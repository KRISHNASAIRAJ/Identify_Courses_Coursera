package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ResultsPage {
    WebDriver driver;
    WebDriverWait wait;
    @FindBy(xpath = "//button[@data-testid='filter-dropdown-productDifficultyLevel']")
    WebElement difficultyLevel;
    @FindBy(xpath = "//span[text()='View']")
    WebElement viewBtn;
    @FindBy(xpath = "//a[@data-e2e='header-login-button']")
    WebElement loginButton;
    @FindBy(xpath = "//button[@data-testid='filter-dropdown-language']")
    WebElement languageOptions;
    @FindBy(xpath = "(//div[@class='cds-ProductCard-content'])[position()<=2]")
    List<WebElement> courseDetails;
    By titleElement=By.xpath(".//h3");
    By rating=By.xpath(".//div[@aria-label='Rating']");
    By duration=By.xpath("//div[@class='cds-CommonCard-metadata']/p");
    public ResultsPage(WebDriver driver, WebDriverWait wait){
        this.driver=driver;
        this.wait=wait;
        PageFactory.initElements(driver,this);
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
        wait.until(ExpectedConditions.visibilityOfAllElements(courseDetails));
        for(WebElement card:courseDetails){
            System.out.println(card.findElement(titleElement).getText()+
                    " | "+card.findElement(rating).getAttribute("aria-valuenow")+
                    " | "+card.findElement(duration).getText());
        }
    }



    public boolean isLoginButtonEnabled(){
        return (wait.until(ExpectedConditions.elementToBeClickable(loginButton)).isEnabled());
    }
}
