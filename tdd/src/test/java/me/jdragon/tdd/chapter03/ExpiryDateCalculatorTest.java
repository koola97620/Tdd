package me.jdragon.tdd.chapter03;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.time.YearMonth;
import org.apache.tomcat.jni.Local;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author choijaeyong on 2020/02/24.
 * @project tdd
 * @description
 * 서비스를 사용하려면 매달 1만원을 선불로 납부한다. 납부일 기준으로 한 달 뒤가 서비스 만료일이 된다
 * 2개월 이상 요금을 납부할 수 있다
 * 10만 원을 납부하면 서비스를 1년 제공한다.
 */
public class ExpiryDateCalculatorTest {

  @DisplayName("만원 납부하면 한달 뒤가 만료일이 됨 ")
  @Test
  public void pay_10000_and_3_1_Then_4_1_expiryDate() {
    assertExpiryDATE(PayData.builder()
        .billingDate(LocalDate.of(2020, 3, 1))
        .payAmount(10_000)
        .build(), LocalDate.of(2020,4,1));
    assertExpiryDATE(PayData.builder()
        .billingDate(LocalDate.of(2020, 5, 2))
        .payAmount(10_000)
        .build() , LocalDate.of(2020,6,2));
  }

  @DisplayName("납부일과 한달 뒤 일자가 같지 않음")
  @Test
  public void billingDate_is_not_same_ExpiryDate() {
    assertExpiryDATE(PayData.builder()
        .billingDate(LocalDate.of(2019, 1, 31))
        .payAmount(10_000)
        .build(), LocalDate.of(2019,2,28));
    assertExpiryDATE(PayData.builder()
        .billingDate(LocalDate.of(2019, 5, 31))
        .payAmount(10_000)
        .build(), LocalDate.of(2019,6,30));
    assertExpiryDATE(PayData.builder()
        .billingDate(LocalDate.of(2020, 1, 31))
        .payAmount(10_000)
        .build(),LocalDate.of(2020,2,29));
  }

  @DisplayName("첫 납부일과 만료일 일자가 다를 때 만원 납부")
  @Test
  public void firstBillingDate_is_not_same_ExpiryDate() {
    PayData payData = PayData.builder()
        .firstBillingDate(LocalDate.of(2019, 1, 31))
        .billingDate(LocalDate.of(2019, 2, 28))
        .payAmount(10_000)
        .build();
    assertExpiryDATE(payData,LocalDate.of(2019,3,31));

    PayData payData2 = PayData.builder()
        .firstBillingDate(LocalDate.of(2019, 1, 30))
        .billingDate(LocalDate.of(2019, 2, 28))
        .payAmount(10_000)
        .build();
    assertExpiryDATE(payData2,LocalDate.of(2019,3,30));

    PayData payData3 = PayData.builder()
        .firstBillingDate(LocalDate.of(2019, 5, 31))
        .billingDate(LocalDate.of(2019, 6, 30))
        .payAmount(10_000)
        .build();
    assertExpiryDATE(payData3,LocalDate.of(2019,7,31));

  }

  @DisplayName("이만원 이상 납부하면 비례해서 만료일 계산")
  @Test
  public void pay_more_20000_calculate_expiryDate() {
    assertExpiryDATE(
        PayData.builder()
        .billingDate(LocalDate.of(2019,3,1))
        .payAmount(20_000)
        .build() , LocalDate.of(2019,5,1));
  }

  @DisplayName("첫 납부일과 만료일 일자가 다를때 이만원 이상 납부")
  @Test
  public void pay_more_20000_And_FirstBillingDateDay_is_not_same_ExpiryDateDay() {
    assertExpiryDATE(
        PayData.builder()
            .firstBillingDate(LocalDate.of(2019,1,31))
            .billingDate(LocalDate.of(2019,2,28))
            .payAmount(20_000)
            .build() , LocalDate.of(2019,4,30));
  }

  @DisplayName("십만원을 납부하면 1년 제공")
  @Test
  public void pay_100000_receive_one_year() {
    assertExpiryDATE(PayData.builder()
        .billingDate(LocalDate.of(2019,1,28))
        .payAmount(100_000)
        .build() , LocalDate.of(2020,1,28));
  }

  // TODO: 2020-03-04 숙제
  @DisplayName("10만원 납부하면 1년 제공인데 2월29일에 납부 ")
  @Test
  public void pay_100000_receive_one_year_but_billingDate_2020_02_29() {
    assertExpiryDATE(PayData.builder()
        .billingDate(LocalDate.of(2020,2,29))
        .payAmount(100_000)
        .build() , LocalDate.of(2021,2,28));
  }

  // TODO: 2020-03-04 숙제
  @DisplayName("13만원 납부시 1년 3개월 뒤가 만료일이 되어야 한다")
  @Test
  public void pay_130000_receive_fifteen_months() {
    assertExpiryDATE(PayData.builder()
        .billingDate(LocalDate.of(2020,3,5))
        .payAmount(130_000)
        .build() , LocalDate.of(2021,6,5));
  }

  private void assertExpiryDATE(PayData payData, LocalDate expectedExpiryDate) {
    ExpiryDateCalculator cal = new ExpiryDateCalculator();
    LocalDate realExpiryDate = cal.calculateExpiryDate(payData);
    assertThat(realExpiryDate).isEqualTo(expectedExpiryDate);
  }

}
