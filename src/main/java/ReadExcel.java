import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

public class ReadExcel {

  public static void main(String[] args) throws Exception {
    XLSToCSVConverter xlsToCSVConverter = new XLSToCSVConverter();
    InputStream inputStream = xlsToCSVConverter.convertxlstoCSV();
    String bytes = convert(inputStream, StandardCharsets.UTF_8);
    System.out.println(bytes);
  }

  private static String convert(InputStream inputStream, Charset charset) throws IOException {

    try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, charset))) {
      return br.lines().collect(Collectors.joining(System.lineSeparator()));
    }
  }

}
