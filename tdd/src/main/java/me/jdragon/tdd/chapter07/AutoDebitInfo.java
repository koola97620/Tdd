package me.jdragon.tdd.chapter07;

import java.time.LocalDateTime;

/**
 * @author choijaeyong on 2020/03/07.
 * @project tdd
 * @description
 */
public class AutoDebitInfo {

  private final Object userId;
  private final String cardNumber;
  private final LocalDateTime now;

  public AutoDebitInfo(Object userId, String cardNumber, LocalDateTime now) {

    this.userId = userId;
    this.cardNumber = cardNumber;
    this.now = now;
  }

  public void changeCardNumber(Object userId, String cardNumber, LocalDateTime now) {


  }

  public String getUserId() {
    return null;
  }
}
