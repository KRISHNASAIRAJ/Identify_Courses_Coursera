package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;

public class CourseDetailsPage {
    WebDriver driver;
    WebDriverWait wait;
    String setupInstructionsExtractor;
    @FindBy(xpath = "//a[contains(@id,'product-card-title')]")
    List<WebElement> specificElement;
    @FindBy(xpath = "//div/h3[text()='Learn step-by-step']//parent::div")
    WebElement stepByStep;
    @FindBy(xpath = "//div[text()='No downloads or installation required']")
    WebElement installationCheck;

    @FindBy(xpath = "//*[@id='reviews']//*[@class='cds-9 css-0 cds-10 cds-11 cds-grid-item cds-13 cds-76']")
    WebElement reviews;
    @FindBy(xpath = "//*[@class='cds-119 cds-113 cds-115 css-1fg25fw cds-142']")
    WebElement instructor;
    @FindBy(xpath = "//*[text()='Bio']/following-sibling::div")
    WebElement bio;

    public CourseDetailsPage(WebDriver driver, WebDriverWait wait) {
        this.driver=driver;
        this.wait=wait;
        PageFactory.initElements(driver,this);
    }

    public void courseDetails() throws InterruptedException {
        JavascriptExecutor js=(JavascriptExecutor) driver;
        wait.until(ExpectedConditions.visibilityOfAllElements(specificElement));
        String ans=specificElement.get(0).getAttribute("href");
        driver.navigate().to(ans);
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

    public void CheckReviews()
    {
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",reviews);
        List<WebElement>ratings=driver.findElements(By.xpath("//*[@class='css-1xgm7zn']//*[@class='css-kimdhf']"));
        for(WebElement it:ratings)
        {
//            System.out.println(it.getText());
        }
    }

    public void InstructorDetails()
    {
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({block:'center'});",instructor);
        js.executeScript("arguments[0].click();",instructor);
        List<WebElement> links=driver.findElements(By.xpath("//*[@class='cds-119 cds-113 cds-115 m-l-1s css-1qn2qsw cds-142']"));
        if(!links.isEmpty())
        {
            for(WebElement it:links)
            {
                System.out.println(it.getText());
            }
        }
//        System.out.println(bio.getText());
    }

}
