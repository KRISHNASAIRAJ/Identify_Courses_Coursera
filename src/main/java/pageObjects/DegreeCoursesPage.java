package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.CommonCode;

import java.util.Set;

public class DegreeCoursesPage {
    WebDriver driver;
    WebDriverWait wait;
    CommonCode commonCode;

    @FindBy(xpath = "//a[@data-testid='nav-link-grid-item-degrees']")
    WebElement degreesOption;

    @FindBy(xpath = "//span[contains(@class,'cds-multiSelect-label') and text()='Program Level']")
    WebElement filter1;

    @FindBy(xpath = "//li[@data-key='MastersDegree']")
    WebElement mastersDegree;

    @FindBy(xpath = "//button[@aria-label='Apply selections']")
    WebElement applyBtn;

    @FindBy(xpath = "//span[contains(@class,'cds-multiSelect-label') and text()='Subject']")
    WebElement filter2;

    @FindBy(xpath = "//li[@data-key='computer-science']")
    WebElement cseBtn;

    @FindBy(className = "cds-ProductCard-content")
    WebElement gridElement;

    @FindBy(xpath = "(//h3[contains(@class,'cds-CommonCard-title')])[1]")
    WebElement course;

    @FindBy(xpath = "//h1[contains(@class,'cds-119')]/following-sibling::h2")
    WebElement university;

    public DegreeCoursesPage(WebDriver driver,WebDriverWait wait){
        this.driver=driver;
        this.wait=wait;
        PageFactory.initElements(driver,this);
        this.commonCode=new CommonCode(driver,wait);
    }
    public boolean isUniversityNamePresent(){
        return !university.getText().isEmpty();
    }

    public boolean isCourseNamePresent(){
        return !course.getText().isEmpty();
    }

    public void findCourses(){
        commonCode.visibilityElementFunc(degreesOption).click();
        commonCode.visibilityElementFunc(filter1).click();
        commonCode.elementClickableFunc(mastersDegree).click();
        commonCode.elementClickableFunc(applyBtn).click();
        commonCode.visibilityElementFunc(filter2).click();
        commonCode.elementClickableFunc(cseBtn).click();
        commonCode.elementClickableFunc(applyBtn).click();
        commonCode.visibilityElementFunc(gridElement).click();
        commonCode.switchToNewWindow();
    }
}
