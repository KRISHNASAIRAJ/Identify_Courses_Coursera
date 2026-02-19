package testcases;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.Base;
import pageObjects.BusinessFormSubmission;

public class TC_024 extends BaseTest {
    @Test(priority = 24)
    void formSubmissionWithInvalidData() throws InterruptedException{
        BusinessFormSubmission businessFormSubmission=new BusinessFormSubmission(driver,wait);
        businessFormSubmission.moveToFormArea();
        businessFormSubmission.formFilling("Krishna","Sai","kri@gmail.com","1234567890",1,"SDE",1,2,"India","Telangana");
        Assert.assertTrue(businessFormSubmission.emailCheck());
    }
}
