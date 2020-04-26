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

  // 10% 할인 쿠폰을 적용했을 때 잘 계산하는지에 대한 테스트 케이스 인줄 알았는데
  // 사실 안에 있는 로직은 금액에 대한 할인을 계산하는 경우.
  // given_1000_won_discount_coupon_then_calculate_price

  @Test
  public void given_10_percent_discount_coupon_then_calculate_product_price() {
    DiscountCoupon discountCoupon = new DiscountCoupon(10);
    Product pencil = new Product("연필", 100);
    pencil.applyDiscountCoupon(discountCoupon);
    assertThat(pencil.getPrice()).isEqualTo(90);
  }

  @Test
  public void given_file_then_save() throws IOException {
    String path = "/Users/jdragon/exam/pay/results";
    if(System.getProperty("os.name").toLowerCase().indexOf("win")>=0){
      path = "c:"+ path;
    }
    Stream<Path> fileList = Files.list(Paths.get(path));
    for (Path filePath :  fileList.collect(Collectors.toList())) {
      payService.savePayResult(filePath);
    }
  }



}


