package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utilities.CommonCode;

import java.io.IOException;
import java.util.List;
import java.util.Set;

public class ResultsPage {
    WebDriver driver;
    WebDriverWait wait;
    CommonCode commonCode;
    @FindBy(xpath = "//button[@data-testid='filter-dropdown-productDifficultyLevel']")
    WebElement difficultyLevel;
    @FindBy(xpath = "//span[text()='View']")
    WebElement viewBtn;
    @FindBy(xpath = "//a[@data-e2e='header-login-button']")
    WebElement loginButton;
    @FindBy(xpath = "//h3[contains(@class,'cds-CommonCard-title')]")
    List<WebElement> allTitles;
    @FindBy(xpath = "//button[@data-testid='filter-dropdown-language']")
    WebElement languageOptions;
    @FindBy(xpath = "(//div[@class='cds-ProductCard-content'])[position()<=2]")
    List<WebElement> courseDetails;
    @FindBy(xpath = "//div[contains(@data-testid,'language')]/label/div/span")
    List<WebElement> languages;
    @FindBy(xpath = "//div[@class='cds-CommonCard-interactiveArea']")
    List<WebElement> companyName;
    @FindBy(xpath = "//div[contains(@data-testid,'productDifficultyLevel')]/label/div/span")
    List<WebElement> difficultyLevels;
    @FindBy(xpath = "//div[contains(text(),'reviews')]")
    List<WebElement> review;
    @FindBy(xpath = "//div[@class='cds-CommonCard-metadata']")
    List<WebElement> level;
    @FindBy(xpath = "//button[@data-testid='filter-dropdown-productTypeDescription']")
    WebElement guidedProjectElement;
    @FindBy(xpath = "//span[contains(text(),'Guided Projects')]")
    WebElement guidedProjectCheckbox;
    @FindBy(xpath = "cds-ProductCard-content")
    List<WebElement> productCard;
    @FindBy(xpath = "cds-ProductCard-body")
    WebElement productCardBody;
    @FindBy(xpath = "cds-ProductCard-content")
    List<WebElement> productCardContent;
    @FindBy(xpath = "//div[@class='cds-CommonCard-metadata']")
    WebElement metadata;
    By titleElement=By.xpath(".//h3");
    By rating=By.xpath(".//div[@aria-label='Rating']");
    By duration=By.xpath("//div[@class='cds-CommonCard-metadata']/p");
    public ResultsPage(WebDriver driver, WebDriverWait wait){
        this.driver=driver;
        this.wait=wait;
        commonCode=new CommonCode(driver,wait);
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
        return wait.until(ExpectedConditions.elementToBeClickable(languageOptions)).isEnabled();
    }
    public void selectLanguage(String language){
        languageOptions.click();
        By englishLanguage =By.xpath("//span[text()='"+language+"']");
        driver.findElement(englishLanguage).click();
    }
    public void getLanguages() throws IOException {
        languageOptions.click();
        wait.until(ExpectedConditions.visibilityOfAllElements(languages));
        int languageCount=languages.size();
        commonCode.takeScreenshot();
        for(WebElement language:languages){
            System.out.println(language.getText());
        }
    }

    public void getLevels() throws IOException {
        difficultyLevel.click();
        wait.until(ExpectedConditions.visibilityOfAllElements(difficultyLevels));
        int difficultyCount=difficultyLevels.size();
        commonCode.takeScreenshot();
//        for(WebElement difficulty:difficultyLevels){
//            System.out.println(difficulty.getText());
//        }
    }

    public boolean searchAndLoadCards(){
        wait.until(ExpectedConditions.visibilityOfAllElements(allTitles));
        List<WebElement> courseCards = allTitles;
        boolean check=false;
        for (WebElement card : courseCards) {
            check=!card.getText().isEmpty();
//            System.out.println(card.getText());
        }
        return check;
    }

    public boolean courseReviews(){
        List<WebElement> courseCards = review;
        boolean bool = false;
        for (WebElement card : courseCards){
            bool = !card.getText().isEmpty();
//            System.out.println(card.getText());
        }
        return bool;
    }

    public boolean courseLevel(){
        List<WebElement> courseCards = level;
        boolean bool = false;
        for(WebElement card: courseCards){
            bool = !card.getText().isEmpty();
//            System.out.println(card.getText());
        }
        return bool;
    }

    public boolean companyCourseName(){
        wait.until(ExpectedConditions.visibilityOfAllElements(companyName));
        List<WebElement> courseCards = companyName;
        boolean check = false;
        for(WebElement card : courseCards){
            check = !card.getText().isEmpty();
//            System.out.println(card.getText());
        }
        return check;
    }

    public void getListOfTitles(){
        wait.until(ExpectedConditions.visibilityOfAllElements(courseDetails));
        for(WebElement card:courseDetails){
            wait.until(ExpectedConditions.visibilityOfElementLocated(rating));
            System.out.println(card.findElement(titleElement).getText()+
                    " | "+card.findElement(rating).getAttribute("aria-valuenow")+
                    " | "+card.findElement(duration).getText());
        }
    }

    public boolean isLoginButtonEnabled(){
        return (wait.until(ExpectedConditions.elementToBeClickable(loginButton)).isEnabled());
    }

    public  void guidedProject(){
        wait.until(ExpectedConditions.visibilityOf(guidedProjectElement));
        guidedProjectElement.click();
        wait.until(ExpectedConditions.visibilityOf(guidedProjectCheckbox));
        guidedProjectCheckbox.click();
        clickViewButton();
    }

    public boolean getSkills(){
        List<WebElement> l= productCard;
        boolean check=true;
        for(WebElement search: l){
            String str= search.getText();
            if(!productCardBody.isDisplayed() && str.isEmpty()){
                    check=false;
            }
        }
        return check;
    }

    public boolean getTimeline(){
        List<WebElement> l= productCardContent;
        boolean check=true;
        for(WebElement search: l){
            String str=search.findElement((By) metadata).getText();
            if(!str.contains("Less Than 2 Hours")){
                check=false;
            }
        }
        return check;
    }

}
