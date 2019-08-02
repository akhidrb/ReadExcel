package com.querycreators;

import com.ExcelSheetReader;
import com.SheetQueryForm;
import java.util.List;
import org.apache.poi.ss.usermodel.Sheet;
import org.junit.Assert;
import org.junit.Test;

public class QueryCreatorTests {

  @Test
  public void checkCorrectInsertionQueryFormed() {
    SheetQueryForm sheetQueryForm = new SheetQueryForm("payment-request");
    List<String> formQueries = sheetQueryForm.getQueries();
    for (String query : formQueries) {
      Assert.assertEquals(ICommonKeys.INSERTION_QUERY, query);
    }
  }

  @Test
  public void assertNumberOfRows() {
    ExcelSheetReader excelSheetReader = new ExcelSheetReader();
    Sheet sheet = excelSheetReader.readExcelSheetByName("payment-request");
    Assert.assertEquals(13, sheet.getLastRowNum());
  }

}
