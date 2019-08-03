package com.querycreators;

public interface ITestKeys {

  String INSERTION_QUERY =
      "insert into dobpaymentrequest (id, code, creationdate, modifieddate, creationinfo, "
          + "modificationinfo, currentstates, paymentType, purchaseUnitId, paymentForm, amount) "
          + "values (1001, '2019000001', '2018-08-05 09:02:00', '2018-08-05 09:02:00', 'Amira.Atya', 'Amira.Atya', "
          + "'[\"Draft\"]', 'GENERAL', 20, 'CASH', 1000.0);";

  String INSERTION_QUERY_WITH_NULL =
      "insert into dobpaymentrequest (id, code, creationdate, modifieddate, creationinfo, "
          + "modificationinfo, currentstates, paymentType, purchaseUnitId, paymentForm, amount) "
          + "values (1001, '2019000001', '2018-08-05 09:02:00', '2018-08-05 09:02:00', 'Amira.Atya', 'Amira.Atya', "
          + "'[\"Draft\"]', 'GENERAL', 20, 'CASH', null);";

  String INSERTION_QUERY_WITH_EMPTY_STRING =
      "insert into dobpaymentrequest (id, code, creationdate, modifieddate, creationinfo, "
          + "modificationinfo, currentstates, paymentType, purchaseUnitId, paymentForm, amount) "
          + "values (1001, '2019000001', '2018-08-05 09:02:00', '2018-08-05 09:02:00', 'Amira.Atya', 'Amira.Atya', "
          + "'[\"Draft\"]', 'GENERAL', 20, '', 1000.0);";

}
