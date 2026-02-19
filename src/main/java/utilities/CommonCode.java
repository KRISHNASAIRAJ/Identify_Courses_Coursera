package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonCode {
    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;
    public CommonCode(WebDriver driver,WebDriverWait wait){
        this.driver=driver;
        this.wait=wait;
        this.js=(JavascriptExecutor) driver;
    }
    public void scrollIntoViewer(WebElement ele){
        js.executeScript("arguments[0].scrollIntoView({block:'center'});",ele);
    }

    public void elementClickableFunc(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public WebElement visibilityElementFunc(WebElement element){
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

}
