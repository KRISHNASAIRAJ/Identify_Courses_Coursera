package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class DegreeCoursesPage {
    WebDriver driver;
    WebDriverWait wait;
    By degreesBtn= By.xpath("//a[@data-testid='nav-link-grid-item-degrees']");
    By filter1=By.xpath("//span[contains(@class,'cds-multiSelect-label') and text()='Program Level']");
    By mastersDegr=By.xpath("//li[@data-key='MastersDegree']");
    By appplyButton=By.xpath("//button[@aria-label='Apply selections']");
    By filter2=By.xpath("//span[contains(@class,'cds-multiSelect-label') and text()='Subject']");
    By cseBtn=By.xpath("//li[@data-key='computer-science']");
    By gridEle=By.className("cds-ProductCard-content");
    By course=By.xpath("//h1[contains(@class,'cds-121')]");
    By university=By.xpath("//h1[contains(@class,'cds-119')]/following-sibling::h2");
    public DegreeCoursesPage(WebDriver driver,WebDriverWait wait){
        this.driver=driver;
        this.wait=wait;
    }
    public boolean isUniversityNamePresent(){
        return !driver.findElement(university).getText().isEmpty();
    }

    public boolean isCourseNamePresent(){
        return !driver.findElement(course).getText().isEmpty();
    }
    public void find_courses(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(degreesBtn)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(filter1)).click();
        wait.until(ExpectedConditions.elementToBeClickable(mastersDegr)).click();
        wait.until(ExpectedConditions.elementToBeClickable(appplyButton)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(filter2)).click();
        wait.until(ExpectedConditions.elementToBeClickable(cseBtn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(appplyButton)).click();
        String currentWindow=driver.getWindowHandle();
        wait.until(ExpectedConditions.elementToBeClickable(gridEle)).click();
        String parentWindow="";
        Set<String> windowHandles=driver.getWindowHandles();
        for(String handle:windowHandles){
            if(handle!=currentWindow){
                driver.switchTo().window(handle);
                currentWindow=handle;
            }
        }
    }
}
