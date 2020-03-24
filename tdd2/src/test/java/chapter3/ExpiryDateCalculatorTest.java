package chapter3;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;

/**
 * @author choijaeyong on 2020/03/21.
 * @project tdd2
 * @description
 */
public class ExpiryDateCalculatorTest {

  @Test
  public void 만원_납부하면_한달_뒤가_만료일이됨() {
    assertExpiryDate(
        PayData.builder()
            .billingDate(LocalDate.of(2019,3,1))
            .payAmount(10_000)
            .build()
         ,  LocalDate.of(2019,4,1));

    assertExpiryDate(
        PayData.builder()
            .billingDate(LocalDate.of(2019,5,5))
            .payAmount(10_000)
            .build()
        ,  LocalDate.of(2019,6,5));

    assertExpiryDate(
        PayData.builder()
            .billingDate(LocalDate.of(2019,6,4))
            .payAmount(10_000)
            .build()
        ,  LocalDate.of(2019,7,4));
  }

  @Test
  public void 납부일과_한달_뒤_일자가_같지않음() {
    assertExpiryDate(
        PayData.builder()
            .billingDate(LocalDate.of(2019,1,31))
            .payAmount(10_000)
            .build()
        ,  LocalDate.of(2019,2,28));
  }

  private void assertExpiryDate(PayData payData, LocalDate expectedExpiryDate) {
    ExpiryDateCalculator cal = new ExpiryDateCalculator();
    LocalDate realExpiryDate = cal.calculateExpiryDate(payData);

    assertThat(realExpiryDate).isEqualTo(expectedExpiryDate);
  }

}
