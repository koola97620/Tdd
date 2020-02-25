package me.jdragon.tdd.chapter03;

import java.time.LocalDate;

/**
 * @author choijaeyong on 2020/02/24.
 * @project tdd
 * @description
 */
public class ExpiryDateCalculator {

  public LocalDate calculateExpiryDate(PayData payData) {
    return payData.getBillingDate().plusMonths(1L);
  }
}
