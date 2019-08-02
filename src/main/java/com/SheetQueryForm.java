package com;

import com.querycreators.QueryCreator;
import com.querycreators.QueryCreatorFactory;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.Sheet;

public class SheetQueryForm {

  private List<String> queries;

  public SheetQueryForm(String sheetName) {
    ExcelSheetReader excelSheetReader = new ExcelSheetReader();
    Sheet sheet = excelSheetReader.readExcelSheetByName(sheetName);
    formQueries(sheet);
  }

  private void formQueries(Sheet sheet) {
    int startingRowNumber = 0;
    queries = new ArrayList<>();
    while (startingRowNumber < sheet.getLastRowNum()) {
      formQueryByRowNumber(sheet, startingRowNumber);
      startingRowNumber += 5;
    }
  }

  private void formQueryByRowNumber(Sheet sheet, int startingRowNumber) {
    QueryCreator queryCreator = QueryCreatorFactory.getQueryCreator(sheet, startingRowNumber);
    queries.add(queryCreator.formQuery());
  }

  public List<String> getQueries() {
    return queries;
  }

}
