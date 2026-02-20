package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.CommonCode;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;
    @FindBy(xpath = "//a[@data-click-key='front_page.front_page_story.click.navigation_meta_nav_Individuals']")
    WebElement logo;
    @FindBy(id = "search-autocomplete-input")
    WebElement searchBar;
    @FindBy(xpath = "//button[@id='ior2l']")
    WebElement notNow;
    @FindBy(xpath = "//h3[text()='Drive your business forward and empower your teams']")
    WebElement gotoBusiness;
    @FindBy(xpath = "//h1[@data-testid='how_module_hero_heading']")
    WebElement verifybusinessdata;
    @FindBy(xpath = "//div[@class='rc-CopyrightV2 lohp-rebrand']//span")
    WebElement footer;
    CommonCode commonCode;

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
        return logo.isDisplayed();
    }

    public boolean searchBarVisibility() {
        return wait.until(ExpectedConditions.visibilityOf(searchBar)).isDisplayed();
    }

    public void sendInputToSearchBar(String input) {
        searchBar.sendKeys(input);
        searchBar.sendKeys(Keys.ENTER);
    }

    public void dismissPopup() {
        wait.until(ExpectedConditions.elementToBeClickable((By) notNow)).click();
    }

    public boolean businessTitle() {
        return gotoBusiness.isDisplayed();
    }

    public boolean businessHome() {
            gotoBusiness.click();
            return verifybusinessdata.isDisplayed();
    }

    public boolean footerCheck(){
        commonCode.scrollIntoViewer(footer);
        return footer.isDisplayed();
    }

    //---------------------------------------------
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
    public boolean isLogInButtonClickable(WebDriverWait wait) throws Exception {
        wait.until(ExpectedConditions.elementToBeClickable(logInButton));
        return true;
    }
    public void clickLogInButton() {
        logInButton.click();
    }
    public boolean isEmailLabelVisible(WebDriverWait wait) throws Exception {
        wait.until(ExpectedConditions.visibilityOf(emailLabel));
        return emailLabel.isDisplayed();
    }
    public void closeLoginForm(){
        driver.findElement(By.xpath("//button[@data-e2e='close-modal-button']")).click();

    }
    public boolean isTenThousandTextVisible() throws Exception {
        wait.until(ExpectedConditions.visibilityOf(tenThousandText));
        //System.out.println(tenThousandText.getText());
        return tenThousandText.isDisplayed();
    }
    public void clickFreeTrialButton() throws Exception {
        wait.until(ExpectedConditions.elementToBeClickable(freeTrial));
        freeTrial.click();
    }
    public boolean isFreeTrialPageOpens() throws Exception {
        WebElement courseraPlusHeading = wait.until(ExpectedConditions.visibilityOf(afterFreeTrialClick));
        //System.out.println(courseraPlusHeading.getText());
        return courseraPlusHeading.isDisplayed();
    }

}
