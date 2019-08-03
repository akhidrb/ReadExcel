package com.querycreators;

import org.apache.poi.ss.usermodel.Sheet;

public class AlterSequenceQueryCreator extends QueryCreator {

  AlterSequenceQueryCreator(Sheet sheet, int startingRow) {
    super(sheet, startingRow);
  }

  @Override
  public String formQuery() {
    String query = "alter sequence " + tableName + " restart with " + valuesByType.get(0);
    return query + ";";
  }

}
