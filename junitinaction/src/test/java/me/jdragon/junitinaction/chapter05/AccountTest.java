package me.jdragon.junitinaction.chapter05;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author choijaeyong on 2020/01/26.
 * @project junitinaction
 * @description
 */
class AccountTest {
  // getBalanceOk 메서드는 Account 의 getBalance 가 반환하는 잔고량이 Account 생성자에
  // 넣었던 값과 동일한지 확인한다.

  @Test
  public void getBalanceOk() {
    long balance = 1000L;
    Account account = new Account(balance);
    long result = account.getBalance();
    assertThat(result).isEqualTo(balance);
  }

}