package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;
    @FindBy(xpath = "//a[@data-e2e='header-login-button']")
    WebElement loginButton;

    public HomePage(WebDriver driver,WebDriverWait wait){
        this.driver=driver;
        this.wait=wait;
        PageFactory.initElements(driver,this);
    }
    public boolean isLoginButtonEnabled(){
        return (wait.until(ExpectedConditions.elementToBeClickable(loginButton)).isEnabled());
    }
}
