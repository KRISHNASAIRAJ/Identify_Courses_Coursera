package utilities;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.*;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelWriter {

    public static void writeData(String fileName,String sheetName, String[][] data) throws IOException {

        XSSFWorkbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet(sheetName);
        for (int i = 0; i < data.length; i++) {
            Row row = sheet.createRow(i);

            for (int j = 0; j < data[i].length; j++) {
                row.createCell(j).setCellValue(data[i][j]);
            }
        }
//        sheet.autoSizeColumn(0);
//        sheet.autoSizeColumn(1);
        FileOutputStream out = new FileOutputStream(new File(fileName));
        workbook.write(out);
        out.close();
        workbook.close();
    }
}