package com.sheetquerycreator;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExcelSheetReader {

  private static final Logger log = LoggerFactory.getLogger(ExcelSheetReader.class);


  public Sheet readExcelSheetByName(String name) {
    try {
      File file = new File("src/main/resources/Fakha.xlsx");
      FileInputStream fIP = new FileInputStream(file);
      XSSFWorkbook workbook = new XSSFWorkbook(fIP);
      if (file.isFile() && file.exists()) {
        return workbook.getSheet(name);
      }
    } catch (IOException e) {
      log.error("", e);
    }

    return null;
  }


}
