package pageObjects;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;
//pending
public class CourseDetailsPage {
    WebDriver driver;
    WebDriverWait wait;
    WebElement box;
    @FindBy(xpath = "//div/h3[text()='Learn step-by-step']//parent::div")
    WebElement stepByStep;
    @FindBy(xpath = "//div[text()='No downloads or installation required']")
    WebElement installationCheck;
    String str;

    public CourseDetailsPage(WebDriver driver, WebDriverWait wait) {
        this.driver=driver;
        this.wait=wait;
    }

    public void courseDetails(){
        JavascriptExecutor js=(JavascriptExecutor) driver;
        Actions actions=new Actions(driver);
        wait.until(ExpectedConditions.visibilityOf(box));
        String parentWindow = driver.getWindowHandle();
        actions.moveToElement(box).click().build().perform();
        Set<String> windows = driver.getWindowHandles();
        String child = "";
        for (String s : windows) {
            if (!s.equals(parentWindow)) {
                child = s;
            }
        }
        driver.switchTo().window(child);
        js.executeScript("arguments[0].scrollIntoView(true);", stepByStep);
        str = stepByStep.getText();
    }

    public boolean stepByInstructionsCheck(){
        return str.contains("Learn step-by-step");
    }
    public boolean noInstallation(){
        return installationCheck.isDisplayed();
    }
}
