package chapter3;

import java.time.LocalDate;

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
    if (payData.getFirstBillingDate() != null) {
      LocalDate candidateExp = payData.getBillingDate().plusMonths(1);
      if (payData.getFirstBillingDate().getDayOfMonth() != candidateExp.getDayOfMonth()) {
        return candidateExp.withDayOfMonth(payData.getFirstBillingDate().getDayOfMonth());
      }
    }
    return payData.getBillingDate().plusMonths(1);
  }
}
