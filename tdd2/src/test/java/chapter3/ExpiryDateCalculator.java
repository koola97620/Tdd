package chapter3;

import java.time.LocalDate;
import java.time.YearMonth;

/**
 * @author choijaeyong on 2020/03/21.
 * @project tdd2
 * @description
 */
public class ExpiryDateCalculator {

  public LocalDate calculateExpiryDate(LocalDate billingDate, int payAmount) {
    return billingDate.plusMonths(1);
  }

  public LocalDate calculateExpiryDate(PayData payData) {
    int addedMonths = payData.getPayAmount() / 10_000;

    if (payData.getFirstBillingDate() != null) {
      LocalDate candidateExp = payData.getBillingDate().plusMonths(addedMonths);
      if (payData.getFirstBillingDate().getDayOfMonth() != candidateExp.getDayOfMonth()) {

        if(YearMonth.from(candidateExp).lengthOfMonth() < payData.getFirstBillingDate().getDayOfMonth()) {
          return candidateExp.withDayOfMonth(YearMonth.from(candidateExp).lengthOfMonth());
        }

        return candidateExp.withDayOfMonth(payData.getFirstBillingDate().getDayOfMonth());
      }
    }
    return payData.getBillingDate().plusMonths(addedMonths);
  }
}
