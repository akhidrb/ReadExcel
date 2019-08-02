
public class ReadExcel {

  public static void main(String[] args) throws Exception {
    ExcelSheetReader excelSheetReader = new ExcelSheetReader();
    String insertionQuery = excelSheetReader.readExcelSheet();
    System.out.println(insertionQuery);
  }

}
