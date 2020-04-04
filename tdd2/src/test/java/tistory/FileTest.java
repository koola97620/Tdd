package tistory;

import static org.assertj.core.api.Assertions.assertThat;

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
  public void given_1000_won_discount_coupon_then_calculate_price() {
    DiscountCoupon discountCoupon = new DiscountCoupon(1000);
    Product pencil = new Product("연필", 5000);
    pencil.applyDiscountCoupon(discountCoupon);
    assertThat(pencil.getPrice()).isEqualTo(4000);
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

  private class DiscountCoupon {
    private int value;

    public DiscountCoupon(int value) {
      this.value = value;
    }

    public int getValue() {
      return value;
    }
  }

  private class Product {

    private String name;
    private int price;

    public Product(String name, int price) {
      this.name = name;
      this.price = price;
    }

    public void applyDiscountCoupon(DiscountCoupon discountCoupon) {
      this.price -= discountCoupon.value;
    }

    public String getName() {
      return name;
    }

    public int getPrice() {
      return price;
    }
  }
}
