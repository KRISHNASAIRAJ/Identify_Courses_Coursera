package dataproviders;

import org.testng.annotations.DataProvider;
import utilities.ExcelReader;

public class FormDataProviders {

    private static final String FILE_PATH = "test-data/FormData.xlsx";

    @DataProvider(name = "validFormData")
    public static Object[][] validFormData() {
        return ExcelReader.readSheetAsMatrix(FILE_PATH, "ValidData");
    }

    @DataProvider(name = "invalidFormData")
    public static Object[][] invalidFormData() {
        return ExcelReader.readSheetAsMatrix(FILE_PATH, "InvalidData");
    }
}