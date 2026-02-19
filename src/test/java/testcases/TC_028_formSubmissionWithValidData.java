package testcases;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.BusinessFormSubmission;

public class TC_028_formSubmissionWithValidData extends BaseTest {

    @Test(priority = 28)
    void formSubmissionWithValidData() throws InterruptedException{
        BusinessFormSubmission businessFormSubmission=new BusinessFormSubmission(driver,wait);
        businessFormSubmission.moveToFormArea();
        businessFormSubmission.formFilling("Krishna","Sai","kri@cognizant.com","1234567890",1,"SDE",1,2,"India","Telangana");
        Assert.assertFalse(businessFormSubmission.emailCheck());
        Assert.assertTrue(businessFormSubmission.formSubmissionStatus());
    }

}
