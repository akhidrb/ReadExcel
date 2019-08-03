package com.querycreators;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.omg.CORBA.IntHolder;

public class QueryCreatorFactory {

  public static QueryCreator getQueryCreator(Sheet sheet, IntHolder rowNumber) {
    QueryCreator queryCreator = null;
    String queryCreatorType = getQueryCreatorName(sheet, rowNumber);
    switch (queryCreatorType.toLowerCase()) {
      case "insert":
        queryCreator = new InsertionQueryCreator(sheet, rowNumber);
        break;
      case "delete":
        queryCreator = new DeleteQueryCreator(sheet, rowNumber);
        break;
      case "alter-sequence":
        queryCreator = new AlterSequenceQueryCreator(sheet, rowNumber);
        break;
    }
    return queryCreator;
  }


  private static String getQueryCreatorName(Sheet sheet, IntHolder startingRowNumber) {
    Row row = sheet.getRow(startingRowNumber.value);
    Cell cell = row.getCell(0);
    return cell.toString();
  }

}
