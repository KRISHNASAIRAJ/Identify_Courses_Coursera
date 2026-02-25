package testcases;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.BusinessFormPage;

public class TC_023_FormSubmissionWithInvalidData extends BaseTest {
    //Krishna
    @Test(priority = 25)
    void formSubmissionWithInvalidData() throws InterruptedException{
        BusinessFormPage businessFormPage =new BusinessFormPage(driver,wait);
        businessFormPage.moveToFormArea();
        businessFormPage.formFilling("Krishna","Sai","kri@gmail","1234567890",1,"SDE",1,2,"India","Telangana","CTS");
        Assert.assertTrue(businessFormPage.emailCheck());
        Assert.assertFalse(businessFormPage.formSubmissionStatus());
    }
}
