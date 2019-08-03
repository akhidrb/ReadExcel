package com.sheetquerycreator.querycreators;

import org.apache.poi.ss.usermodel.Sheet;
import org.omg.CORBA.IntHolder;

public class AlterSequenceQueryCreator extends QueryCreator {

  AlterSequenceQueryCreator(Sheet sheet, IntHolder startingRow) {
    super(sheet, startingRow);
  }

  @Override
  public String formQuery() {
    String query = "alter sequence " + tableName + " restart with " + valuesByType.get(0);
    return query + ";";
  }

}
