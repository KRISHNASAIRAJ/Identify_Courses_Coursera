package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    Properties properties;
    public ConfigReader() throws IOException{
        properties=new Properties();
        FileInputStream fis=new FileInputStream("src/test/resources/config.properties");
        properties.load(fis);
    }
    public String getProp(String key) throws IOException {
        return properties.getProperty(key);
          }
}
