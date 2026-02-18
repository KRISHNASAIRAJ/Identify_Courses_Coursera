package testcases;

import basetest.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TC_021 extends BaseTest {
    @Test(priority = 21)
    void programOverview(){
        By courseLocator= By.xpath("//a[contains(@class,'cds-CommonCard-titleLink')][1]");
        
    }
}
