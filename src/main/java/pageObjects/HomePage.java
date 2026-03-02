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

    @FindBy(xpath = "//button[@data-e2e='close-modal-button']")
    WebElement closeBtn;

    @FindBy(xpath = "//a[contains(@href,'help') and contains(text(),'Help')]")
    WebElement helpClk;

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

    public boolean exploreCategoriesTitle() {
        commonCode.visibilityElementFunc(gotoExploreCategories);
        return gotoExploreCategories.isDisplayed();
    }

    public boolean categoriesNames() {
        commonCode.visibilityElementFunc(verifyCategories);
        return verifyCategories.isDisplayed();
    }

    public boolean footerCheck(){
        commonCode.scrollIntoViewer(footer);
        return footer.isDisplayed();
    }

    public boolean isLogInButtonClickable() {
        commonCode.visibilityElementFunc(logInBtn);
        commonCode.elementClickableFunc(logInBtn);
        return true;
    }
    public void clickLogInButton() {
        logInBtn.click();
    }

    public boolean isEmailLabelVisible() {
        commonCode.visibilityElementFunc(emailLabel);
        return emailLabel.isDisplayed();
    }

    public void closeLoginForm(){
        closeBtn.click();
    }

    public boolean isComputerScienceClickable() {
        computerScienceCategoryBtn.click();
        return true;
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
        commonCode.takeScreenshot();
        List<String> sections = new ArrayList<>();
        commonCode.visibilityOfAllElementsFunc(helpSections);
        for(WebElement it:helpSections)
        {
            sections.add(it.getText());
        }
        ExcelWriter.writeList("Help Section",sections,"Sections");
    }

    public void getComputerScienceCredentials(){
        wait.until(ExpectedConditions.visibilityOfAllElements(credentialsComputerScience));
//        System.out.println(credentialsComputerScience.getText());
        //data to save in excel pending
    }
}
