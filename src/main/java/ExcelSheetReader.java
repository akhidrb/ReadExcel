import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelSheetReader {

  public String readExcelSheet() throws IOException {
    File file = new File("src/main/resources/Fakha.xlsx");
    FileInputStream fIP = new FileInputStream(file);
    XSSFWorkbook workbook = new XSSFWorkbook(fIP);
    if (file.isFile() && file.exists()) {
      SheetToQueryCreator sheetToQueryCreator = new SheetToQueryCreator();
      return sheetToQueryCreator.createInsertionQueryFromSheet(workbook.getSheetAt(0));
    }
    return null;
  }


}
