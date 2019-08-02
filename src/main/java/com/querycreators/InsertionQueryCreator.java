package com.querycreators;

import java.util.List;
import org.apache.poi.ss.usermodel.Sheet;

public class InsertionQueryCreator extends QueryCreator {

  InsertionQueryCreator(Sheet sheet, int startingRow) {
    super(sheet, startingRow);
  }

  @Override
  public String formQuery() {
    String query = "insert into " + tableName + " (";
    query += joinListToCommaSeparatedString(columnNames) + ") values (";
    query += joinListToCommaSeparatedString(valuesByType) + ");";
    return query;
  }

  private String joinListToCommaSeparatedString(List<String> columnNames) {
    return String.join(", ", columnNames);
  }


}
