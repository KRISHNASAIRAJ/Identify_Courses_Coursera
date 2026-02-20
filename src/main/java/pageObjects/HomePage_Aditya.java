package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.CommonCode;

import java.io.IOException;
import java.util.List;

public class HomePage_Aditya {
        WebDriver driver;
        WebDriverWait wait;
        @FindBy(xpath = "//a[@data-click-key='front_page.front_page_story.click.navigation_meta_nav_Individuals']")
        WebElement logo;
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
        @FindBy(id="search-autocomplete-input")
        WebElement search;
        @FindBy(xpath = "//button[@id='ior2l']")
        WebElement notNow;
        @FindBy(xpath = "//h3[contains(@class,'cds-CommonCard-title')]")
        List<WebElement> title;
        @FindBy(xpath = "//div[@class='cds-CommonCard-interactiveArea']")
        List<WebElement> companyName;
        @FindBy(xpath = "//div[contains(text(),'reviews')]")
        List<WebElement> review;
        @FindBy(xpath = "//div[@class='cds-CommonCard-metadata']")
        List<WebElement> level;
        CommonCode commonCode;
        public HomePage_Aditya(WebDriver driver, WebDriverWait wait){
            this.driver=driver;
            this.wait=wait;
            commonCode=new CommonCode(driver,wait);
            PageFactory.initElements(driver,this);
        }

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
        public void dismissPopup(){
            wait.until(ExpectedConditions.elementToBeClickable((By) notNow)).click();
        }
        public void searchAndLoadCards() throws IOException {
            try {
                commonCode.takeScreenshot();
                wait.until(ExpectedConditions.visibilityOf(search)).sendKeys("Python");
                search.submit();
                List<WebElement> courseCards = title;
                boolean bool = false;
                for (WebElement card : courseCards) {
//                    System.out.println(card.getText());
//                    System.out.println("---------");
                    bool = !card.getText().isEmpty();
                }
            } catch (ElementClickInterceptedException e) {
                dismissPopup();
            }
        }

}


