import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class SheetToQueryCreator {

  public String createInsertionQueryFromSheet(Sheet sheet) {
    String tableName = getTableName(sheet);
    List<String> columnNames = getRowValuesInList(sheet.getRow(1));
    List<String> values = getRowValuesInList(sheet.getRow(2));
    return formInsertionQueryString(tableName, columnNames, values);
  }

  private String formInsertionQueryString(String tableName, List<String> columnNames,
      List<String> values) {
    String query = "insert into " + tableName + " (";
    query += joinListToCommaSeparatedString(columnNames) + ") values (";
    query += joinListToCommaSeparatedString(values) + ");";
    return query;
  }

  private String joinListToCommaSeparatedString(List<String> columnNames) {
    return String.join(", ", columnNames);
  }

  private List<String> getRowValuesInList(Row row) {
    List<String> rowValues = new ArrayList<>();
    Iterator<Cell> cellIterator = row.cellIterator();
    while (cellIterator.hasNext()) {
      addCellToList(cellIterator, rowValues);
    }
    return rowValues;
  }

  private void addCellToList(Iterator<Cell> cellIterator, List<String> columnNames) {
    Cell cell = cellIterator.next();
    columnNames.add(cell.toString());
  }

  private String getTableName(Sheet sheet) {
    Row row = sheet.getRow(0);
    Cell cell = row.getCell(0);
    return cell.toString();
  }

}
