package com.querycreators;

import org.apache.poi.ss.usermodel.Sheet;

public class DeleteQueryCreator extends QueryCreator {

  DeleteQueryCreator(Sheet sheet, int startingRow) {
    super(sheet, startingRow);
  }

  @Override
  public String formQuery() {
    String query = "delete from " + tableName;
    if (columnNames != null && columnNames.size() > 0) {
      query += " where " + formAndedWhereProperties();
    }
    return query + ";";
  }

  private String formAndedWhereProperties() {
    StringBuilder properties = new StringBuilder();
    properties.append(columnNames.get(0)).append("=").append(valuesByType.get(0));
    for (int i = 1; i < columnNames.size(); i++) {
      properties.append(" and ").append(columnNames.get(i)).append("=").append(valuesByType.get(i));
    }
    return properties.toString();
  }

}
