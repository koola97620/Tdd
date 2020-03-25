package chapter3;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import org.assertj.core.internal.bytebuddy.asm.Advice.Local;
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

  @Test
  public void 첫_납부일과_만료일_일자가_다를때_만원_납부() {
    PayData payData = PayData.builder()
        .firstBillingDate(LocalDate.of(2019,1,31))
        .billingDate(LocalDate.of(2019,2,28))
        .payAmount(10_000)
        .build();
    assertExpiryDate(payData, LocalDate.of(2019,3,31));

    PayData payData2 = PayData.builder()
        .firstBillingDate(LocalDate.of(2019, 1, 30))
        .billingDate(LocalDate.of(2019, 2, 28))
        .payAmount(10_000)
        .build();
    assertExpiryDate(payData2, LocalDate.of(2019,3,30));

    PayData payData3 = PayData.builder()
        .firstBillingDate(LocalDate.of(2019, 5, 31))
        .billingDate(LocalDate.of(2019, 6, 30))
        .payAmount(10_000)
        .build();
    assertExpiryDate(payData3, LocalDate.of(2019,7,31));
  }

  @Test
  public void 이만원_이상_납부하면_비례해서_만료일_계산() {
    PayData payData = PayData.builder()
        .billingDate(LocalDate.of(2019,3,1))
        .payAmount(20_000)
        .build();
    assertExpiryDate(payData, LocalDate.of(2019,5,1));
  }


  @Test
  public void 첫_납부일과_만료일_일자가_다를때_이만원_이상_납부() {
    PayData payData = PayData.builder()
        .firstBillingDate(LocalDate.of(2019,1,31))
        .billingDate(LocalDate.of(2019,2,28))
        .payAmount(20_000)
        .build();
    assertExpiryDate(payData, LocalDate.of(2019,4,30));

    PayData payData2 = PayData.builder()
        .firstBillingDate(LocalDate.of(2019,1,31))
        .billingDate(LocalDate.of(2019,2,28))
        .payAmount(40_000)
        .build();
    assertExpiryDate(payData2, LocalDate.of(2019,6,30));

    PayData payData3 = PayData.builder()
        .firstBillingDate(LocalDate.of(2019,3,31))
        .billingDate(LocalDate.of(2019,4,30))
        .payAmount(30_000)
        .build();
    assertExpiryDate(payData3, LocalDate.of(2019,7,31));
  }

  @Test
  public void 십만원을_납부하면_1년_제공() {
    assertExpiryDate(
        PayData.builder()
            .billingDate(LocalDate.of(2019,1,28))
            .payAmount(100_000)
            .build(),
        LocalDate.of(2020,1,28)
    );
  }


  private void assertExpiryDate(PayData payData, LocalDate expectedExpiryDate) {
    ExpiryDateCalculator cal = new ExpiryDateCalculator();
    LocalDate realExpiryDate = cal.calculateExpiryDate(payData);

    assertThat(realExpiryDate).isEqualTo(expectedExpiryDate);
  }

}
