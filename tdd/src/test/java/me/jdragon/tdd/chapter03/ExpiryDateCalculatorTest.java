package me.jdragon.tdd.chapter03;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
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
    LocalDate billingDate = LocalDate.of(2020, 3, 1);
    int payAmount = 10_000;
    ExpiryDateCalculator cal = new ExpiryDateCalculator();
    LocalDate expiryDate = cal.calculateExpiryDate(billingDate, payAmount);

    assertThat(expiryDate).isEqualTo(LocalDate.of(2020,4,1));


  }



}
