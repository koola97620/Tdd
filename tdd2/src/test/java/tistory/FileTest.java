package tistory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author choijaeyong on 2020/04/01.
 * @project tdd2
 * @description
 */
public class FileTest {

  private PayService payService;

  @BeforeEach
  public void setUp() {
    payService = new PayService();
  }

  @Test
  public void given_file_then_save() throws IOException {
    String path = "/Users/jdragon/exam/pay/results";
    Stream<Path> fileList = Files.list(Paths.get(path));
//    if(System.getProperty("os.name").toLowerCase().indexOf("win")>=0){
//      targetDirPath = "c:"+ targetDirPath;
//    }
    for (Path filePath :  fileList.collect(Collectors.toList())) {
      payService.savePayResult(filePath);
    }
  }

}
