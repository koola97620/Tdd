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
    assertExpiryDate(LocalDate.of(2019,3,1) , 10_000, LocalDate.of(2019,4,1));
    assertExpiryDate(LocalDate.of(2019,5,5) , 10_000, LocalDate.of(2019,6,5));
    assertExpiryDate(LocalDate.of(2019,6,4) , 10_000, LocalDate.of(2019,7,4));
  }

  private void assertExpiryDate(LocalDate billingDate, int payAmount, LocalDate expectedExpiryDate) {
    ExpiryDateCalculator cal = new ExpiryDateCalculator();
    LocalDate expiryDate = cal.calculateExpiryDate(billingDate, payAmount);

    assertThat(expiryDate).isEqualTo(expectedExpiryDate);
  }

}
