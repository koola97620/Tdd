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
    LocalDate billingDate = LocalDate.of(2019, 3, 1);
    int payAmount=10_000;

    ExpiryDateCalculator cal = new ExpiryDateCalculator();
    LocalDate expiryDate = cal.calculateExpiryDate(billingDate, payAmount);

    assertThat(expiryDate).isEqualTo(LocalDate.of(2019,4,1));

    LocalDate billingDate2 = LocalDate.of(2019, 5, 5);
    int payAmount2=10_000;

    ExpiryDateCalculator cal2 = new ExpiryDateCalculator();
    LocalDate expiryDate2 = cal2.calculateExpiryDate(billingDate2, payAmount2);

    assertThat(expiryDate2).isEqualTo(LocalDate.of(2019,6,5));


  }

}
