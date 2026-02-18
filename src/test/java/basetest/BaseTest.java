package basetest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeClass;
import utilities.ConfigReader;

import java.io.IOException;
import java.util.Properties;

public class BaseTest {
    private WebDriver driver;
    public BaseTest() throws IOException {
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
        }
    }
}
