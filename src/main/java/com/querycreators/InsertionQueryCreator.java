package com.querycreators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class InsertionQueryCreator implements QueryCreator {

  @Override
  public String createQueryFromSheet(Sheet sheet) {
    String tableName = getTableName(sheet);
    List<String> columnNames = getRowValuesInList(sheet.getRow(1));
    List<String> valuesByType = getValuesByType(sheet);
    return formInsertionQueryString(tableName, columnNames, valuesByType);
  }

  private List<String> getValuesByType(Sheet sheet) {
    List<String> values = getRowValuesInList(sheet.getRow(2));
    List<String> valueTypes = getRowValuesInList(sheet.getRow(3));
    return convertValuesByType(values, valueTypes);
  }

  private List<String> convertValuesByType(List<String> values, List<String> valueTypes) {
    List<String> valuesByType = new ArrayList<>();
    for (int i = 0; i < values.size(); i++) {
      String valueByType = convertValueByType(values.get(i), valueTypes.get(i));
      valuesByType.add(valueByType);
    }
    return valuesByType;
  }

  private String convertValueByType(String value, String valueType) {
    Object valueByType;
    switch (valueType) {
      case "String":
      case "Date":
        valueByType = value;
        break;
      case "Long":
        valueByType = (long) Float.parseFloat(value);
        break;
      case "Float":
        valueByType = Float.parseFloat(value);
        break;
      default:
        valueByType = value;
    }
    return valueByType.toString();
  }

  private String formInsertionQueryString(String tableName, List<String> columnNames,
      List<String> values) {
    String query = "insert into " + tableName + " (";
    query += joinListToCommaSeparatedString(columnNames) + ") values (";
    query += joinListToCommaSeparatedString(values) + ");";
    return query;
  }

  private String joinListToCommaSeparatedString(List<String> columnNames) {
    return String.join(", ", columnNames);
  }

  private List<String> getRowValuesInList(Row row) {
    List<String> rowValues = new ArrayList<>();
    Iterator<Cell> cellIterator = row.cellIterator();
    while (cellIterator.hasNext()) {
      addCellToList(cellIterator, rowValues);
    }
    return rowValues;
  }

  private void addCellToList(Iterator<Cell> cellIterator, List<String> columnNames) {
    Cell cell = cellIterator.next();
    columnNames.add(cell.toString());
  }

  private String getTableName(Sheet sheet) {
    Row row = sheet.getRow(0);
    Cell cell = row.getCell(0);
    return cell.toString();
  }

}
