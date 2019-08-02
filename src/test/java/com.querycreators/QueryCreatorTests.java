package com.querycreators;

import com.ExcelSheetReader;
import org.apache.poi.ss.usermodel.Sheet;
import org.junit.Assert;
import org.junit.Test;

public class QueryCreatorTests {

  @Test
  public void checkCorrectInsertionQueryFormed() {
    ExcelSheetReader excelSheetReader = new ExcelSheetReader();
    Sheet sheet = excelSheetReader.readExcelSheetByName("payment-request");
    QueryCreator queryCreator = QueryCreatorFactory.getQueryCreator("insertion");
    String query = queryCreator.createQueryFromSheet(sheet);
    Assert.assertEquals(ICommonKeys.INSERTION_QUERY, query);
  }

}
