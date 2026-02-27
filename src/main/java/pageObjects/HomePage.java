package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.CommonCode;
import utilities.ExcelWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;
    CommonCode commonCode;

    @FindBy(xpath = "//*[@role='img' and @aria-label='Coursera']")
    WebElement logo;

    @FindBy(id = "search-autocomplete-input")
    WebElement searchBar;
    //WORK THIS
    @FindBy(xpath = "//button[@id='ior2l']")
    WebElement notNowBtn;

    @FindBy(xpath = "//h3[text()='Drive your business forward and empower your teams']")
    WebElement gotoBusiness;

    @FindBy(xpath = "//h1[@data-testid='how_module_hero_heading']")
    WebElement verifyBusinessData;

    @FindBy(xpath = "//div[@class='rc-CopyrightV2 lohp-rebrand']//span")
    WebElement footer;

    @FindBy(xpath = "//span[contains(text(),'Log In')]")
    WebElement logInBtn;

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

    @FindBy(xpath = "//a[contains(@href,'help') and contains(text(),'Help')]")
    WebElement helpClk;

    @FindBy(xpath = "//div[@class='category_tile-title']")
    List<WebElement> helpSections;

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
        commonCode.visibilityElementFunc(logo);
        return logo.isDisplayed();
    }

    public boolean searchBarVisibility() {
        return commonCode.visibilityElementFunc(searchBar).isDisplayed();
    }

    public void sendInputToSearchBar(String input) {
        commonCode.visibilityElementFunc(searchBar);
        searchBar.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
        searchBar.sendKeys(input);
        searchBar.sendKeys(Keys.ENTER);
    }

    public void dismissPopup() {
        wait.until(ExpectedConditions.elementToBeClickable((By) notNowBtn)).click();
    }

    public boolean businessTitle() {
        commonCode.visibilityElementFunc(gotoBusiness);
        return gotoBusiness.isDisplayed();
    }

    public boolean businessHome() {
        gotoBusiness.click();
        commonCode.visibilityElementFunc(verifyBusinessData);
        return verifyBusinessData.isDisplayed();
    }

    public boolean footerCheck(){
        commonCode.scrollIntoViewer(footer);
        return footer.isDisplayed();
    }

    public boolean isLogInButtonClickable(WebDriverWait wait) throws Exception {
        commonCode.visibilityElementFunc(logInBtn);
        commonCode.elementClickableFunc(logInBtn);
        return true;
    }
    public void clickLogInButton() {
        logInBtn.click();
    }
    public boolean isEmailLabelVisible(WebDriverWait wait) throws Exception {
        commonCode.visibilityElementFunc(emailLabel);
        return emailLabel.isDisplayed();
    }
    public void closeLoginForm(){
        closeBtn.click();
    }
    public boolean isTenThousandTextVisible() throws Exception {
        commonCode.visibilityElementFunc(tenThousandText);
        return tenThousandText.isDisplayed();
    }
    public void clickFreeTrialButton() throws Exception {
        commonCode.elementClickableFunc(freeTrial);
        freeTrial.click();
    }
    public boolean isFreeTrialPageOpens() throws Exception {
        WebElement courseraPlusHeading = commonCode.visibilityElementFunc(afterFreeTrialClick);
        return courseraPlusHeading.isDisplayed();
    }

    public boolean checkForHelpSection()
    {
        commonCode.visibilityElementFunc(helpClk);
        commonCode.scrollIntoViewer(helpClk);
        return helpClk.isDisplayed();
    }

    public void clickHelpSection() throws IOException {
        commonCode.visibilityElementFunc(helpClk);
        commonCode.jsClick(helpClk);

        List<String> sections = new ArrayList<>();
        commonCode.visibilityOfAllElementsFunc(helpSections);
        for(WebElement it:helpSections)
        {
            sections.add(it.getText());
        }
        ExcelWriter.writeList("Help Section",sections,"Sections");
    }
}
