package utilities;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.List;

public final class ExcelWriter {

    private static final String FILE_NAME = "Coursera.xlsx";
    private static final Object LOCK = new Object();
    private static XSSFWorkbook WB;

    static {
        // Load existing workbook if present; else create new
        File f = new File(FILE_NAME);
        if (f.exists()) {
            try (FileInputStream in = new FileInputStream(f)) {
                WB = new XSSFWorkbook(in);
            } catch (IOException e) {
                System.err.println("[ExcelWriter] Couldn't open '" + FILE_NAME + "'. New workbook will be created. Reason: " + e.getMessage());
                WB = new XSSFWorkbook();
            }
        } else {
            WB = new XSSFWorkbook();
        }

        // Save once at JVM shutdown
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try (FileOutputStream out = new FileOutputStream(FILE_NAME)) {
                synchronized (LOCK) { WB.write(out); }
            } catch (IOException e) {
                System.err.println("[ExcelWriter] Failed final save of '" + FILE_NAME + "': " + e.getMessage());
            } finally {
                try { WB.close(); } catch (IOException ignored) {}
            }
        }, "ExcelWriter-Shutdown"));
    }

    private ExcelWriter() {}

    public static void writeList(String sheetName, List<String> data, String columnName) {
        synchronized (LOCK) {
            Sheet sheet = getOrCreateSheet(sheetName);
            Row header = getOrCreateRow(sheet, 0);
            int col = findOrCreateColumn(header, columnName);

            for (int i = 0; i < data.size(); i++) {
                Row row = getOrCreateRow(sheet, i + 1);
                Cell cell = row.getCell(col, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                cell.setCellValue(data.get(i));
            }
            sheet.autoSizeColumn(col);
        }
    }

    // Optional: call manually (e.g., @AfterSuite) if you want to persist before JVM exit.
    public static void flush() throws IOException {
        synchronized (LOCK) {
            try (FileOutputStream out = new FileOutputStream(FILE_NAME)) {
                WB.write(out);
            }
        }
    }

    private static Sheet getOrCreateSheet(String name) {
        Sheet s = WB.getSheet(name);
        return (s != null) ? s : WB.createSheet(name);
    }

    private static Row getOrCreateRow(Sheet s, int idx) {
        Row r = s.getRow(idx);
        return (r != null) ? r : s.createRow(idx);
    }

    private static int findOrCreateColumn(Row header, String name) {
        short last = header.getLastCellNum(); // -1 if empty
        int limit = Math.max(last, 0);
        for (int i = 0; i < limit; i++) {
            Cell c = header.getCell(i);
            if (c != null && name.equalsIgnoreCase(c.getStringCellValue())) return i;
        }
        header.createCell(limit).setCellValue(name);
        return limit;
    }
}