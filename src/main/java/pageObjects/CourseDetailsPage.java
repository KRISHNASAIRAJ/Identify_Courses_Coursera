package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ExcelWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CourseDetailsPage {
    WebDriver driver;
    WebDriverWait wait;
    String setupInstructionsExtractor;

    @FindBy(xpath = "//a[contains(@id,'product-card-title')]")
    List<WebElement> productCards;

    @FindBy(xpath = "//div/h3[text()='Learn step-by-step']//parent::div")
    WebElement stepByStep;

    @FindBy(xpath = "//div[text()='No downloads or installation required']")
    WebElement installationCheck;

    @FindBy(xpath = "//h2[contains(text(),'Learner reviews')]")
    WebElement reviews;

    @FindBy(xpath = "//a[starts-with(@href, '/instructor/')]")
    WebElement instructorClk;

    @FindBy(xpath = "(//p[@class='css-kimdhf'])[position()<=1]/preceding-sibling::h2")
    WebElement instructorName;

    @FindBy(xpath = "//div[@data-unit='reviews-bar-graph']//p[@class='css-kimdhf']")
    List<WebElement> ratings;

    @FindBy(xpath = "//ul[contains(@class,'rc-PartnerLinksV2')]//a | //div[contains(@class,'rc-ExternalLinks')]//a")
    List<WebElement> lnks;

    public CourseDetailsPage(WebDriver driver, WebDriverWait wait) {
        this.driver=driver;
        this.wait=wait;
        PageFactory.initElements(driver,this);
    }

    public void courseDetails() throws InterruptedException {
        JavascriptExecutor js=(JavascriptExecutor) driver;
        wait.until(ExpectedConditions.visibilityOfAllElements(productCards));
        String ans= productCards.get(0).getAttribute("href");
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

    public List<String> fetchRatings() throws IOException {
        List<String> ratingsList = new ArrayList<>();

        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView({block:'center'});", reviews);

            for (WebElement r : ratings) {
                String text = r.getText().trim();
                if (!text.isEmpty()) {
                    ratingsList.add(text);
                }
            }
        } catch (Exception e) {
        }
        ExcelWriter.writeList("Reviews",ratingsList,"Reviews");
        return ratingsList;
    }

    public List<String> instructorDetails() throws IOException {
        List<String> resultLinks = new ArrayList<>();
        List<String> resultName = new ArrayList<>();
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", instructorClk);
            wait.until(ExpectedConditions.visibilityOf(instructorClk));
            String name= instructorName.getText();
            resultName.add(name);
            ExcelWriter.writeList("Instructor Details",resultName ,"Name");
            if (!lnks.isEmpty()) {
                for (WebElement it : lnks) {
                    String text = it.getText().trim();
                    resultLinks.add(text);
                }
            }
        } catch (Exception ignored) {
        }
        ExcelWriter.writeList("Instructor Details",resultLinks,"Links");
        return resultLinks;
    }
}
