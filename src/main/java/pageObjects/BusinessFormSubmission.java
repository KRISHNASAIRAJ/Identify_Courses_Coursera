package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.CommonCode;

public class BusinessFormSubmission {
    WebDriver driver;
    WebDriverWait wait;
    @FindBy(xpath = "//span[text()=' Businesses']")
    WebElement business;
    @FindBy(xpath = "//form[contains(@id,'mktoForm')]")
    WebElement form;
    @FindBy(id="FirstName")
    WebElement firstName;
    @FindBy(id="LastName")
    WebElement lastName;
    @FindBy(id="Email")
    WebElement emailAddress;
    @FindBy(id="Phone")
    WebElement phone;
    @FindBy(id = "Company")
    WebElement company;
    @FindBy(id="rentalField9")
    WebElement organizationType;
    @FindBy(id="Title")
    WebElement jobTitle;
    @FindBy(id="Self_reported_employees_to_buy_for__c")
    WebElement employeeRange;
    @FindBy(id="Self_Reported_Needs__c")
    WebElement needs;
    @FindBy(id="Country")
    WebElement country;
    @FindBy(id="State")
    WebElement state;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement submit;
    @FindBy(className="mktoError")
    WebElement invalidEId;
    public BusinessFormSubmission(WebDriver driver,WebDriverWait wait){
        this.driver=driver;
        this.wait=wait;
        PageFactory.initElements(driver,this);
    }


    public void moveToFormArea(){
        CommonCode commonCode=new CommonCode(driver,wait);
        business.click();
        commonCode.scrollIntoViewer(form);
    }

    public void formFilling(
            String firstNameInp, String lastNameInp, String mailIdInp, String phoneInp, int organizationTypeIndex,
            String jobTitleInp, int needDescInp, int employeeRangeInp, String countryInp, String stateInp
    ) throws InterruptedException {
        firstName.sendKeys(firstNameInp);
        lastName.sendKeys(lastNameInp);
        emailAddress.sendKeys(mailIdInp);
        phone.sendKeys(phoneInp);
        Select organization= new Select(organizationType);
        organization.selectByIndex(organizationTypeIndex);
        jobTitle.sendKeys(jobTitleInp);
        Select needsDescription=new Select(needs);
        needsDescription.selectByIndex(needDescInp);
        Select rangeOfEmployee=new Select(employeeRange);
        rangeOfEmployee.selectByIndex(employeeRangeInp);
        Select countries=new Select(country);
        countries.selectByValue(countryInp);
        Select states=new Select(state);
        states.selectByValue(stateInp);
        submit.click();
    }
    public boolean emailCheck(){
        try {
            return (wait.until(ExpectedConditions.visibilityOf(invalidEId)).isDisplayed());
        } catch (Exception e) {
            return false;
        }
    }
}
