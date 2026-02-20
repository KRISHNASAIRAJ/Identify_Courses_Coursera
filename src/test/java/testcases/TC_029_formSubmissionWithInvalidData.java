package testcases;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.BusinessFormSubmission;

public class TC_029_formSubmissionWithInvalidData extends BaseTest {
    @Test(priority = 31)
    void formSubmissionWithInvalidData() throws InterruptedException{
        BusinessFormSubmission businessFormSubmission=new BusinessFormSubmission(driver,wait);
        businessFormSubmission.moveToFormArea();
        businessFormSubmission.formFilling("Krishna","Sai","kri@gmail","1234567890",1,"SDE",1,2,"India","Telangana");
        Assert.assertTrue(businessFormSubmission.emailCheck());
        Assert.assertFalse(businessFormSubmission.formSubmissionStatus());
    }
}
