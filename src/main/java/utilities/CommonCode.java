package utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

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

    public void takeScreenshot() throws IOException {
        File source=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Path outDir = Paths.get("screenshots");
        Files.createDirectories(outDir);
        String fileName = "snap-coursera-" + System.currentTimeMillis() + ".png";
        Path destination = outDir.resolve(fileName);
        Files.copy(source.toPath(), destination, StandardCopyOption.REPLACE_EXISTING);
//        System.out.println("Screenshot saved: " + destination.toAbsolutePath());
    }

    public void elementClickableFunc(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public WebElement visibilityElementFunc(WebElement element){
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

}
