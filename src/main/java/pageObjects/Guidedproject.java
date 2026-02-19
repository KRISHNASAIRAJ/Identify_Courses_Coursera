package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;
import java.util.Set;

public class Guidedproject {
    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(xpath = "//input[@name='query']")
    WebElement inp;
    @FindBy(xpath = "//button[@data-testid='filter-dropdown-productTypeDescription']")
    WebElement gpscroll;
    @FindBy(xpath = "//span[contains(text(),'Guided Projects')]")
    WebElement guidedprojectcheckbox;
    @FindBy(xpath = "//span[contains(@class,'cds-button-label') and contains(.,'View')]")
    WebElement viewbtn;
    @FindBy(xpath = "cds-ProductCard-content")
    List<WebElement> productcard;
    @FindBy(xpath = "cds-ProductCard-body")
    WebElement productcardbody;
    @FindBy(xpath = "cds-ProductCard-content")
    List<WebElement> productcardcontent;
    @FindBy(xpath = "//div[@class='cds-CommonCard-metadata']")
    WebElement metadata;
    @FindBy(xpath = "//h3[contains(text(),'Introduction to Python')]")
    WebElement box;
    @FindBy(xpath = "//div[@class='css-15ko5n9']")
    WebElement stepbystep;
    @FindBy(xpath = "//div[text()='No downloads or installation required']")
    WebElement noinstall;
    String str;
    public Guidedproject(WebDriver driver,WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public String getURL(){
        return driver.getCurrentUrl();
    }

    public  String getTitle(){
        return driver.getTitle();
    }
    public  void Gotogp(){
        JavascriptExecutor js=(JavascriptExecutor) driver;
        Actions actions=new Actions(driver);
        inp.clear();
        inp.sendKeys("Python");
        inp.sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOf(gpscroll));
        gpscroll.click();

        wait.until(ExpectedConditions.visibilityOf(guidedprojectcheckbox));
        guidedprojectcheckbox.click();

        wait.until(ExpectedConditions.visibilityOf(viewbtn));
        viewbtn.click();
    }

    public void getSkills(){
        List<WebElement> l= productcard;
        for(WebElement search: l){
            String str= search.getText();
            // Assert that skills are displayed
            Assert.assertTrue(productcardbody.isDisplayed(), "Skills section is not displayed");
            Assert.assertFalse(str.isEmpty(), "Skills section is empty");
        }
    }

    public void getTimeline(){
        List<WebElement> l= productcardcontent;
        for(WebElement search: l){
            String str=search.findElement((By) metadata).getText();
            Assert.assertTrue(str.contains("Less Than 2 Hours"));
        }
    }

    public void nextpage(){
        JavascriptExecutor js=(JavascriptExecutor) driver;
        Actions actions=new Actions(driver);
        wait.until(ExpectedConditions.visibilityOf(box));
        String Fatherwindow = driver.getWindowHandle();
        actions.moveToElement(box).click().build().perform();

        Set<String> windows = driver.getWindowHandles();
        String child = "";
        for (String s : windows) {
            if (!s.equals(Fatherwindow)) {
                child = s;
            }
        }
        driver.switchTo().window(child);
        js.executeScript("arguments[0].scrollIntoView(true);", stepbystep);
        str = stepbystep.getText();
    }
    public boolean stepByInstructionsCheck(){
        return str.contains("Learn step-by-step");
    }

    public boolean noinstallation(){
       return noinstall.isDisplayed();

    }

}
