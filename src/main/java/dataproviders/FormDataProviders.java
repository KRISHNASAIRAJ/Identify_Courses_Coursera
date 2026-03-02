package dataproviders;

import org.testng.annotations.DataProvider;
import utilities.ConfigReader;
import utilities.ExcelReader;
import java.io.IOException;

public class FormDataProviders {

    ConfigReader configReader;
    private static String FILE_PATH;
    public FormDataProviders() throws IOException {
        configReader=new ConfigReader();
        FILE_PATH=configReader.getProp("EXCEL_FILE_PATH");
    }
    //Return type is object because it can allow various data types(String,Integer)
    @DataProvider(name = "validFormData")
    public Object[][] validFormData() {
        return ExcelReader.readSheetAsMatrix(FILE_PATH, "ValidData");
    }

    @DataProvider(name = "invalidFormData")
    public Object[][] invalidFormData() {
        return ExcelReader.readSheetAsMatrix(FILE_PATH, "InvalidData");
    }
}