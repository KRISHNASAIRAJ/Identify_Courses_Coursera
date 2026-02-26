package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.CommonCode;

import java.io.IOException;
import java.util.List;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;
    CommonCode commonCode;

    @FindBy(xpath = "//a[@data-click-key='front_page.front_page_story.click.navigation_meta_nav_Individuals']")
    WebElement logo;

    @FindBy(id = "search-autocomplete-input")
    WebElement searchBar;
    //WORK THIS
    @FindBy(xpath = "//button[@id='ior2l']")
    WebElement notNow;

    @FindBy(xpath = "//h3[text()='Drive your business forward and empower your teams']")
    WebElement gotoBusiness;
    @FindBy(xpath = "//h1[@data-testid='how_module_hero_heading']")
    WebElement verifyBusinessData;
    @FindBy(xpath = "//div[@class='rc-CopyrightV2 lohp-rebrand']//span")
    WebElement footer;
    @FindBy(xpath = "//span[contains(text(),'Log In')]")
    WebElement logInButton;
    @FindBy(xpath = "//label[contains(text(),'Email')]")
    WebElement emailLabel;
    @FindBy(xpath = "//h3[contains(text(),'10,000+')]")
    WebElement tenThousandText;
    @FindBy(xpath = "//button/span[contains(text(),'7-day')]")
    WebElement freeTrial;
    @FindBy(xpath = "//h1[contains(text(),'Coursera Plus')]")
    WebElement afterFreeTrialClick;
    @FindBy(xpath = "//button[@data-e2e='close-modal-button']")
    WebElement closeBtn;

    public HomePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        commonCode=new CommonCode(driver,wait);
        PageFactory.initElements(driver, this);
    }

    public String getURL() {
        return driver.getCurrentUrl();
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public boolean checkLogo() {
        wait.until(ExpectedConditions.visibilityOf(logo));
        return logo.isDisplayed();
    }

    public boolean searchBarVisibility() throws IOException {
        commonCode.takeScreenshot();
        return wait.until(ExpectedConditions.visibilityOf(searchBar)).isDisplayed();
    }

    public void sendInputToSearchBar(String input) {
        wait.until(ExpectedConditions.visibilityOf(searchBar));
        searchBar.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
        searchBar.sendKeys(input);
        searchBar.sendKeys(Keys.ENTER);
    }

    public boolean searchWithInvalid(String input)
    {
        searchBar.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
        searchBar.sendKeys(input);
        searchBar.sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h3")));
        List<WebElement> titles = driver.findElements(By.cssSelector("h3"));
        for (WebElement t : titles) {
            if (t.getText().toLowerCase().contains(input.toLowerCase())) {
                return false;
            }
        }
        return true;
    }

    public void dismissPopup() {
        wait.until(ExpectedConditions.elementToBeClickable((By) notNow)).click();
    }

    public boolean businessTitle() {
        return gotoBusiness.isDisplayed();
    }

    public boolean businessHome() {
            gotoBusiness.click();
            return verifyBusinessData.isDisplayed();
    }

    public boolean footerCheck(){
        commonCode.scrollIntoViewer(footer);
        return footer.isDisplayed();
    }

    public boolean isLogInButtonClickable(WebDriverWait wait){
        wait.until(ExpectedConditions.elementToBeClickable(logInButton));
        return true;
    }
    public void clickLogInButton() {
        logInButton.click();
    }
    public boolean isEmailLabelVisible(WebDriverWait wait){
        wait.until(ExpectedConditions.visibilityOf(emailLabel));
        return emailLabel.isDisplayed();
    }
    public void closeLoginForm(){
        closeBtn.click();
    }
    public boolean isTenThousandTextVisible() {
        wait.until(ExpectedConditions.visibilityOf(tenThousandText));
        return tenThousandText.isDisplayed();
    }
    public void clickFreeTrialButton(){
        wait.until(ExpectedConditions.elementToBeClickable(freeTrial));
        freeTrial.click();
    }
    public boolean isFreeTrialPageOpens(){
        WebElement courseraPlusHeading = wait.until(ExpectedConditions.visibilityOf(afterFreeTrialClick));
        return courseraPlusHeading.isDisplayed();
    }

}
