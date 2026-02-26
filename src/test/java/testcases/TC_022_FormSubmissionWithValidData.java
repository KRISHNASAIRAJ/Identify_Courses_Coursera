package testcases;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.BusinessFormPage;
import pageObjects.HomePage;

public class TC_022_FormSubmissionWithValidData extends BaseTest {
    //Krishna
    HomePage homePage;
    BusinessFormPage businessFormPage;
    @Test(priority = 31)
    void formSubmissionWithValidData(){
        homePage=new HomePage(driver,wait);
        businessFormPage =new BusinessFormPage(driver,wait);
        businessFormPage.moveToFormArea();
        businessFormPage.formFilling("Krishna","Sai","kri@cognizant.com","1234567890",1,"SDE",1,2,"India","Telangana","CTS");
        Assert.assertFalse(businessFormPage.emailCheck());
        Assert.assertTrue(businessFormPage.formSubmissionStatus());
    }

}
