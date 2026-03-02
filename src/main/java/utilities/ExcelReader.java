package utilities;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelReader {

    public static Object[][] readSheetAsMatrix(String filePath, String sheetName) {
        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {
            Sheet sheet = workbook.getSheet(sheetName);
            if (sheet == null) {
                throw new IllegalArgumentException("Sheet not found: " + sheetName);
            }
            Iterator<Row> rowIterator = sheet.iterator();
            if (!rowIterator.hasNext()) {
                return new Object[0][0];
            }
            Row headerRow = rowIterator.next();
            int colCount = headerRow.getLastCellNum();
            List<Object[]> rows = new ArrayList<>();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Object[] cells = new Object[colCount];
                for (int c = 0; c < colCount; c++) {
                    cells[c] = getCellValueAsString(row.getCell(c));
                }
                rows.add(cells);
            }
            Object[][] data = new Object[rows.size()][];
            for (int i = 0; i < rows.size(); i++) {
                data[i] = rows.get(i);
            }
            return data;
        } catch (IOException e) {
            throw new RuntimeException("Error reading Excel: " + filePath, e);
        }
    }

    //Any format is converted into String
    private static String getCellValueAsString(Cell cell) {
        if (cell == null) return "";
        DataFormatter formatter = new DataFormatter();
        return formatter.formatCellValue(cell).trim();
    }
}