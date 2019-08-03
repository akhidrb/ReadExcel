package com.querycreators;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class QueryCreatorFactory {

  public static QueryCreator getQueryCreator(Sheet sheet, int startingRowNumber) {
    QueryCreator queryCreator = null;
    String queryCreatorType = getQueryCreatorName(sheet, startingRowNumber);
    switch (queryCreatorType.toLowerCase()) {
      case "insert":
        queryCreator = new InsertionQueryCreator(sheet, startingRowNumber);
        break;
    }
    return queryCreator;
  }


  private static String getQueryCreatorName(Sheet sheet, int startingRowNumber) {
    Row row = sheet.getRow(startingRowNumber);
    Cell cell = row.getCell(0);
    return cell.toString();
  }

}
