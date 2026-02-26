package testcases;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.BusinessFormPage;
import pageObjects.HomePage;

public class TC_023_FormSubmissionWithInvalidData extends BaseTest {
    //Krishna
    HomePage homePage;
    BusinessFormPage businessFormPage;
    @Test(priority = 32)
    void formSubmissionWithInvalidData() {
        homePage=new HomePage(driver,wait);
        businessFormPage =new BusinessFormPage(driver,wait);
        businessFormPage.moveToFormArea();
        businessFormPage.formFilling("Krishna","Sai","kri@gmail","1234567890",1,"SDE",1,2,"India","Telangana","CTS");
        Assert.assertTrue(businessFormPage.emailCheck());
        Assert.assertFalse(businessFormPage.formSubmissionStatus());
    }
}
