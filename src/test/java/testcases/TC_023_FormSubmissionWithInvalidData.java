//package testcases;
//
//import basetest.BaseTest;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//import pageObjects.BusinessFormPage;
//import pageObjects.HomePage;
//
//public class TC_023_FormSubmissionWithInvalidData extends BaseTest {
//    //Krishna
//    HomePage homePage;
//    BusinessFormPage businessFormPage;
//    @Test(priority = 32)
//    void formSubmissionWithInvalidData() {
//        homePage=new HomePage(driver,wait);
//        businessFormPage =new BusinessFormPage(driver,wait);
//        businessFormPage.moveToFormArea();
//        businessFormPage.formFilling("Krishna","Sai","kri@gmail","1234567890",1,"SDE",1,2,"India","Telangana","CTS");
//        Assert.assertTrue(businessFormPage.emailCheck());
//        Assert.assertFalse(businessFormPage.formSubmissionStatus());
//    }
//}
package testcases;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import dataproviders.FormDataProviders;
import pageObjects.BusinessFormPage;
import pageObjects.HomePage;

public class TC_023_FormSubmissionWithInvalidData extends BaseTest {
    HomePage homePage;
    BusinessFormPage businessFormPage;

    @Test(
            priority = 32,
            dataProvider = "invalidFormData",
            dataProviderClass = FormDataProviders.class
    )
    public void formSubmissionWithInvalidData(
            String firstName,
            String lastName,
            String email,
            String phone,
            String expYearsStr,
            String jobTitle,
            String countryIndexStr,
            String stateIndexStr,
            String country,
            String state,
            String company
    ) {
        homePage = new HomePage(driver, wait);
        businessFormPage = new BusinessFormPage(driver, wait);

        businessFormPage.moveToFormArea();

        int expYears = parseIntOrDefault(expYearsStr, 0);
        int countryIndex = parseIntOrDefault(countryIndexStr, 0);
        int stateIndex = parseIntOrDefault(stateIndexStr, 0);

        businessFormPage.formFilling(
                firstName,
                lastName,
                email,
                phone,
                expYears,
                jobTitle,
                countryIndex,
                stateIndex,
                country,
                state,
                company
        );

        Assert.assertTrue(businessFormPage.emailCheck(), "Email error should be shown for invalid email.");
        Assert.assertFalse(businessFormPage.formSubmissionStatus(), "Form must not submit with invalid data.");
    }

    private int parseIntOrDefault(String value, int defaultValue) {
        try { return Integer.parseInt(value.trim()); } catch (Exception e) { return defaultValue; }
    }
}