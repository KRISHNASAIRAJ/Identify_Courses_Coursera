package pageObjects;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class CourseDetailsPage {
    WebDriver driver;
    WebDriverWait wait;
    String setupInstructionsExtractor;
    @FindBy(xpath = "//a[@aria-label='Introduction to Python, offered by Coursera, GUIDED PROJECT']")
    WebElement specificElement;
    @FindBy(xpath = "//div/h3[text()='Learn step-by-step']//parent::div")
    WebElement stepByStep;
    @FindBy(xpath = "//div[text()='No downloads or installation required']")
    WebElement installationCheck;

    public CourseDetailsPage(WebDriver driver, WebDriverWait wait) {
        this.driver=driver;
        this.wait=wait;
        PageFactory.initElements(driver,this);
    }

    public void courseDetails() throws InterruptedException {
        JavascriptExecutor js=(JavascriptExecutor) driver;
        wait.until(ExpectedConditions.visibilityOf(specificElement));
        specificElement.click();
        String parentWindow = driver.getWindowHandle();
        Set<String> windows = driver.getWindowHandles();
        String child = "";
        for (String s : windows) {
            if (!s.equals(parentWindow)) {
                child = s;
            }
        }
        driver.switchTo().window(child);
        js.executeScript("arguments[0].scrollIntoView(true);", stepByStep);
        setupInstructionsExtractor = stepByStep.getText();
    }

    public boolean stepByInstructionsCheck(){
        return setupInstructionsExtractor.contains("Learn step-by-step");
    }
    public boolean noInstallation(){
        return installationCheck.isDisplayed();
    }
}
