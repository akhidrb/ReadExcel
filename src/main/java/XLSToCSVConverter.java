import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLSToCSVConverter {

  public InputStream convertxlstoCSV() throws IOException {
    File file = new File("src/main/resources/Fakha.xlsx");
    FileInputStream fIP = new FileInputStream(file);
    XSSFWorkbook workbook = new XSSFWorkbook(fIP);
    if(file.isFile() && file.exists()) {
      return csvConverter(workbook.getSheetAt(0));
    }
    return null;
  }

  private InputStream csvConverter(Sheet sheet) {
    Row row = null;
    String str = new String();
    for (int i = 0; i < sheet.getLastRowNum()+1; i++) {
      row = sheet.getRow(i);
      String rowString = new String();
      for (int j = 0; j < 3; j++) {
        try {
          if(row.getCell(j)==null) {
            rowString = rowString + " ,";
          }
          else {
            rowString = rowString + row.getCell(j)+ ',';
          }
        }catch (NullPointerException e) {
          break;
        }
      }
      str = str + rowString.substring(0,rowString.length()-1)+ '\n';
    }
    return new ByteArrayInputStream(str.getBytes(StandardCharsets.UTF_8));
  }
}
