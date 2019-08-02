package com.querycreators;

public class QueryCreatorFactory {

  public static QueryCreator getQueryCreator(String queryCreatorType) {
    QueryCreator queryCreator = null;
    switch (queryCreatorType.toLowerCase()) {
      case "insertion":
        queryCreator = new InsertionQueryCreator();
        break;
    }
    return queryCreator;
  }

}
