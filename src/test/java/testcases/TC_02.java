package testcases;

import basetest.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import java.util.List;

public class TC_02 extends BaseTest {
    @Test
    void testSearchPartnerAndBadge(){
        List<WebElement> courseCards = driver.findElements(By.xpath("//div[@class='cds-CommonCard-interactiveArea']"));

        for(WebElement card : courseCards){
//            System.out.println(card.getText());
//            System.out.println("--");
            boolean companyName = !card.getText().isEmpty();
            Assert.assertTrue(companyName);
        }

    }
}
