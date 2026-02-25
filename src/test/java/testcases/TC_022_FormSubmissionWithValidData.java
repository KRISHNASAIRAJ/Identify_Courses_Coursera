package testcases;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.BusinessFormPage;

public class TC_022_FormSubmissionWithValidData extends BaseTest {
    //Krishna
    @Test(priority = 24)
    void formSubmissionWithValidData() throws InterruptedException{
        BusinessFormPage businessFormPage =new BusinessFormPage(driver,wait);
        businessFormPage.moveToFormArea();
        businessFormPage.formFilling("Krishna","Sai","kri@cognizant.com","1234567890",1,"SDE",1,2,"India","Telangana");
        Assert.assertFalse(businessFormPage.emailCheck());
        Assert.assertTrue(businessFormPage.formSubmissionStatus());
    }

}
