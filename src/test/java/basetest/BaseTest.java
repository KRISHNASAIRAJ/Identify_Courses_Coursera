package basetest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import utilities.ConfigReader;

import java.io.IOException;
import java.time.Duration;

public class BaseTest {
    protected static WebDriver driver;
    protected static WebDriverWait wait;
    @BeforeSuite
    public void getDriver() throws IOException {
        ConfigReader configReader = new ConfigReader();
        String browser = configReader.getProp("browser");
        if (browser != null) {
            if (browser.equalsIgnoreCase("edge")) {
                driver = new EdgeDriver();
            } else {
                driver = new ChromeDriver();
            }
            driver.manage().window().maximize();
            driver.get(configReader.getProp("URL"));
            wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        }
    }
    @AfterSuite
    public void tearDown(){
        if(driver!=null){
            driver.quit();
            driver=null;
        }
    }
}
