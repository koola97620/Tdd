package me.jdragon.tdd.chapter03;

import java.time.LocalDate;
import java.time.YearMonth;

/**
 * @author choijaeyong on 2020/02/24.
 * @project tdd
 * @description
 */
public class ExpiryDateCalculator {

  public LocalDate calculateExpiryDate(PayData payData) {
    long addedMonths = payData.getPaymentAmount() >= 100_000 ?
        12 + ( payData.getPaymentAmount()-100_000 ) / 10_000 : payData.getPaymentAmount() / 10_000;
    if (payData.getFirstBillingDate() != null) {
      return expiryDateUsingFirstBillingDate(payData, addedMonths);
    } else {
      return payData.getBillingDate().plusMonths(addedMonths);
    }

  }

  private LocalDate expiryDateUsingFirstBillingDate(PayData payData, long addedMonths) {
    LocalDate candidateEXP = payData.getBillingDate().plusMonths(addedMonths);

    if (!isSameDayOfMonth(payData.getFirstBillingDate(), candidateEXP)) {
      final int dayLenOfCandiMon = lastDayOfMonth(candidateEXP);
      final int dayOfFirstBilling = payData.getFirstBillingDate().getDayOfMonth();
      if (dayLenOfCandiMon < dayOfFirstBilling) {
        return candidateEXP.withDayOfMonth(dayLenOfCandiMon);
      }
      return candidateEXP.withDayOfMonth(dayOfFirstBilling);
    } else {
      return candidateEXP;
    }
  }

  private int lastDayOfMonth(LocalDate date) {
    return YearMonth.from(date).lengthOfMonth();
  }

  private boolean isSameDayOfMonth(LocalDate date1, LocalDate date2) {
    return date1.getDayOfMonth() == date2.getDayOfMonth();
  }
}
