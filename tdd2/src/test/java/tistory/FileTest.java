package tistory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

/**
 * @author choijaeyong on 2020/04/01.
 * @project tdd2
 * @description
 */
public class FileTest {

  @Test
  public void fileTest() throws IOException {
    String path = "/Users/jdragon/exam";
    Stream<Path> fileList = Files.list(Paths.get(path));
    for (Path filePath :  fileList.collect(Collectors.toList())) {
      // code
      System.out.println(filePath);
    }
  }

}
