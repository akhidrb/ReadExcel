package com.querycreators;

import org.apache.poi.ss.usermodel.Sheet;

public interface QueryCreator {

  String createQueryFromSheet(Sheet sheet);

}
