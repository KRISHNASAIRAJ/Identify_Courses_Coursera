package testcases;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.BusinessFormPage;

public class TC_028_formSubmissionWithValidData extends BaseTest {

    @Test(priority = 30)
    void formSubmissionWithValidData() throws InterruptedException{
        BusinessFormPage businessFormPage =new BusinessFormPage(driver,wait);
        businessFormPage.moveToFormArea();
        businessFormPage.formFilling("Krishna","Sai","kri@cognizant.com","1234567890",1,"SDE",1,2,"India","Telangana");
        Assert.assertFalse(businessFormPage.emailCheck());
        Assert.assertTrue(businessFormPage.formSubmissionStatus());
    }

}
