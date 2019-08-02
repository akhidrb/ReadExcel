package com.querycreators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public abstract class QueryCreator {

  String tableName;
  List<String> columnNames;
  List<String> valuesByType;

  private int startinRow;
  private int columnNamesRowNumber;
  private int valuesRowNumber;
  private int valueTypesRowNumber;

  QueryCreator(Sheet sheet, int startingRow) {
    this.startinRow = startingRow;
    columnNamesRowNumber = startingRow + 1;
    valuesRowNumber = startingRow + 2;
    valueTypesRowNumber = startingRow + 3;
    createQueryPropertiesFromSheet(sheet);
  }

  public abstract String formQuery();

  private void createQueryPropertiesFromSheet(Sheet sheet) {
    tableName = getTableName(sheet);
    columnNames = getRowValuesInList(sheet.getRow(columnNamesRowNumber));
    valuesByType = getValuesByType(sheet);
  }

  private String getTableName(Sheet sheet) {
    Row row = sheet.getRow(startinRow);
    Cell cell = row.getCell(0);
    return cell.toString();
  }

  private List<String> getValuesByType(Sheet sheet) {
    List<String> values = getRowValuesInList(sheet.getRow(valuesRowNumber));
    List<String> valueTypes = getRowValuesInList(sheet.getRow(valueTypesRowNumber));
    return convertValuesByType(values, valueTypes);
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


}
