package com;

import com.querycreators.QueryCreator;
import com.querycreators.QueryCreatorFactory;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.Sheet;
import org.omg.CORBA.IntHolder;

public class SheetQueryForm {

  private List<String> queries;

  public SheetQueryForm(String sheetName) {
    ExcelSheetReader excelSheetReader = new ExcelSheetReader();
    Sheet sheet = excelSheetReader.readExcelSheetByName(sheetName);
    formQueries(sheet);
  }

  private void formQueries(Sheet sheet) {
    IntHolder rowNumber = new IntHolder();
    queries = new ArrayList<>();
    while (rowNumber.value <= sheet.getLastRowNum()) {
      formQueryByRowNumber(sheet, rowNumber);
    }
  }

  private void formQueryByRowNumber(Sheet sheet, IntHolder rowNumber) {
    QueryCreator queryCreator = QueryCreatorFactory.getQueryCreator(sheet, rowNumber);
    queries.add(queryCreator.formQuery());
  }

  public List<String> getQueries() {
    return queries;
  }

}
