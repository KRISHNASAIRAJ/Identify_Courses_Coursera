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

    @FindBy(xpath = "//h2[contains(text(),'Explore categories')]")
    WebElement gotoExploreCategories;

    @FindBy(xpath = "//a[@class='cds-149 cds-Pill-root css-1bw26k7']")
    WebElement verifyCategories;

    @FindBy(xpath = "//div[@class='rc-CopyrightV2 lohp-rebrand']//span")
    WebElement footer;

    @FindBy(xpath = "//span[contains(text(),'Log In')]")
    WebElement logInBtn;

    @FindBy(xpath = "//label[contains(text(),'Email')]")
    WebElement emailLabel;

    @FindBy(xpath = "//div[@role='listitem']/a[@href='/browse/computer-science']")
    WebElement computerScienceCategoryBtn;

    @FindBy(xpath = "//button/span[contains(text(),'7-day')]")
    WebElement freeTrial;

    @FindBy(xpath = "//h1[contains(text(),'Coursera Plus')]")
    WebElement afterFreeTrialClick;

    @FindBy(xpath = "//button[@data-e2e='close-modal-button']")
    WebElement closeBtn;

    @FindBy(xpath = "//a[contains(@href,'help') and contains(text(),'Help')]")
    WebElement help;

    @FindBy(xpath = "//div[@class='category_tile-title']")
    List<WebElement> helpSections;

    @FindBy(xpath = "//div[@class='css-fxrpmp']")
    WebElement credentialsComputerScience;


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

    public boolean searchBarVisibility() {
        return wait.until(ExpectedConditions.visibilityOf(searchBar)).isDisplayed();
    }

    public void sendInputToSearchBar(String input) {
        wait.until(ExpectedConditions.visibilityOf(searchBar));
        searchBar.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
        searchBar.sendKeys(input);
        searchBar.sendKeys(Keys.ENTER);
    }

    public void dismissPopup() {
        wait.until(ExpectedConditions.elementToBeClickable((By) notNowBtn)).click();
    }

    public boolean exploreCategoriesTitle() {
        wait.until(ExpectedConditions.visibilityOf(gotoExploreCategories));
        return gotoExploreCategories.isDisplayed();
    }

    public boolean categoriesNames() {
        wait.until(ExpectedConditions.visibilityOf(verifyCategories));
        return verifyCategories.isDisplayed();
    }

    public boolean footerCheck(){
        commonCode.scrollIntoViewer(footer);
        return footer.isDisplayed();
    }

    public boolean isLogInButtonClickable(WebDriverWait wait) throws Exception {
        wait.until(ExpectedConditions.visibilityOf(logInBtn));
        wait.until(ExpectedConditions.elementToBeClickable(logInBtn));
        return true;
    }
    public void clickLogInButton() {
        logInBtn.click();
    }
    public boolean isEmailLabelVisible(WebDriverWait wait) throws Exception {
        wait.until(ExpectedConditions.visibilityOf(emailLabel));
        return emailLabel.isDisplayed();
    }

    public void closeLoginForm(){
        closeBtn.click();
    }

    public boolean isComputerScienceClickable() throws Exception {
        computerScienceCategoryBtn.click();
        return true;
    }

    public void clickFreeTrialButton() throws Exception {
        wait.until(ExpectedConditions.elementToBeClickable(freeTrial));
        freeTrial.click();
    }
    public boolean isFreeTrialPageOpens() throws Exception {
        WebElement courseraPlusHeading = wait.until(ExpectedConditions.visibilityOf(afterFreeTrialClick));
        return courseraPlusHeading.isDisplayed();
    }

    public boolean checkForHelpSection()
    {
        wait.until(ExpectedConditions.visibilityOf(help));
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",help);
        return help.isDisplayed();
    }

    public void clickHelpSection() throws IOException {
        JavascriptExecutor js=(JavascriptExecutor) driver;
        wait.until(ExpectedConditions.visibilityOf(help));
        js.executeScript("arguments[0].click();",help);

        List<String> sections = new ArrayList<>();
        wait.until(ExpectedConditions.visibilityOfAllElements(helpSections));
        for(WebElement it:helpSections)
        {
            sections.add(it.getText());
        }
        ExcelWriter.writeList("Help Section",sections,"Sections");
    }

    public void getComputerScienceCredentials() throws IOException{
        wait.until(ExpectedConditions.visibilityOfAllElements(credentialsComputerScience));
//        System.out.println(credentialsComputerScience.getText());
        //data to save in excel pending
    }
}
