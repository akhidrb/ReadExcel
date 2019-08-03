package com.querycreators;

import com.SheetQueryForm;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class QueryCreatorTests {

  private List<String> paymentRequestQueries;

  @Before
  public void setup() {
    SheetQueryForm sheetQueryForm = new SheetQueryForm("testSheet");
    paymentRequestQueries = sheetQueryForm.getQueries();
  }

  @Test
  public void checkCorrectInsertionQueryFormed() {
    Assert.assertEquals(ITestKeys.INSERTION_QUERY, paymentRequestQueries.get(0));
  }

  @Test
  public void checkCorrectInsertionQueryFormedWithNullValue() {
    Assert.assertEquals(ITestKeys.INSERTION_QUERY_WITH_NULL, paymentRequestQueries.get(1));
  }

  @Test
  public void checkCorrectInsertionQueryFormedWithEmptyString() {
    Assert.assertEquals(ITestKeys.INSERTION_QUERY_WITH_EMPTY_STRING, paymentRequestQueries.get(2));
  }

  @Test
  public void checkCorrectDeleteQuery() {
    Assert.assertEquals(ITestKeys.DELETE_QUERY, paymentRequestQueries.get(3));
  }

  @Test
  public void checkCorrectDeleteQueryWithWhereClause() {
    Assert.assertEquals(ITestKeys.DELETE_QUERY_WITH_WHERE_CLAUSE, paymentRequestQueries.get(4));
  }

  @Test
  public void checkCorrectAlterSequenceQuery() {
    Assert.assertEquals(ITestKeys.ALTER_SEQUENCE_QUERY, paymentRequestQueries.get(5));
  }

}
