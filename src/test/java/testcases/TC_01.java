package testcases;

import basetest.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class TC_01 extends BaseTest {

        @Test(priority = 0)
        public void testSearchProductName(){
            //removing the popup
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            try{
                WebElement notNow = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id=\"ior2l\"]")));
                notNow.click();
            } catch (Exception e) {
                System.out.println("WhatsApp popup didn't appear or was already closed.");
            }

            //searching python course
            WebElement search = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search-autocomplete-input")));
            search.sendKeys("Python");
            search.submit();

            //for fetching the courses name of python
            //locating all course card with common class name
            List<WebElement> courseCards = driver.findElements(By.xpath("//h3[contains(@class,'cds-CommonCard-title')]"));

            for(WebElement card : courseCards){
                //System.out.println(card.getText());
                //System.out.println("--");
                boolean courseName = !card.getText().isEmpty();
                Assert.assertTrue(courseName);

            }


        }

}
