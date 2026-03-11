package basetest;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import utilities.ConfigReader;

import java.io.IOException;
import java.time.Duration;

public class BaseTest {
    public WebDriver driver;
    public WebDriverWait wait;
    public ConfigReader configReader;
    @BeforeClass
    public void getDriver() throws IOException {
        configReader = new ConfigReader();
        String browser = configReader.getProp("browser");
        if (browser != null) {
            if (browser.equalsIgnoreCase("edge")) {
                driver = new EdgeDriver();
            } else {
                driver = new ChromeDriver();

//                ChromeOptions options = new ChromeOptions();
//                options.addArguments("--headless");
//                options.addArguments("--window-size=1920,1080");
//                driver = new ChromeDriver(options);
//                options.addArguments("--disable-gpu");
//                options.addArguments("--no--sandbox");
//                options.addArguments("--disable-dev-shm-usage");

            }
            driver.manage().window().maximize();
            driver.get(configReader.getProp("URL"));
            wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        }
    }
    @AfterClass
    public void tearDown(){
        if(driver!=null){
            driver.quit();
            driver=null;
        }
    }
}
