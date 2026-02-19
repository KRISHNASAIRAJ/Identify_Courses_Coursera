package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomePage {
        WebDriver driver;
        WebDriverWait wait;
        @FindBy(id="search-autocomplete-input")
        WebElement search;
        @FindBy(xpath = "//button[@id='ior2l']")
        WebElement notNow;
        @FindBy(xpath = "//h3[contains(@class,'cds-CommonCard-title')]")
        List<WebElement> title;
        @FindBy(xpath = "//div[@class='cds-CommonCard-interactiveArea']")
        List<WebElement> companyName;
        public HomePage(WebDriver driver,WebDriverWait wait){
            this.driver=driver;
            this.wait=wait;
            PageFactory.initElements(driver,this);
        }

        public void dismissPopup(){
            wait.until(ExpectedConditions.elementToBeClickable((By) notNow)).click();
        }

        public void searchAndLoadCards(){
            try {
                wait.until(ExpectedConditions.visibilityOf(search)).sendKeys("Python");
                search.submit();
                List<WebElement> courseCards = title;
                boolean bool = false;
                for (WebElement card : courseCards) {
                    bool = !card.getText().isEmpty();
                }
            } catch (ElementClickInterceptedException e) {
                dismissPopup();
            }
        }
        public boolean test2(){
            List<WebElement> courseCards = companyName;
            boolean bool = false;
            for(WebElement card : courseCards){
                bool = !card.getText().isEmpty();
            }
            return bool;

//            List<WebElement> badgeName = driver.findElements();



        }
}
