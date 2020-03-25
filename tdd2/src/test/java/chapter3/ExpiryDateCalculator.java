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
    //int addedMonths = payData.getPayAmount() / 10_000;
    int addedMonths = payData.getPayAmount() == 100_000 ? 12 : payData.getPayAmount() / 10_000;

    if (payData.getFirstBillingDate() != null) {
      return expiryDateUsingFirstBillingDate(payData, addedMonths);
    } else {
      return payData.getBillingDate().plusMonths(addedMonths);
    }
  }

  private LocalDate expiryDateUsingFirstBillingDate(PayData payData, int addedMonths) {
    LocalDate candidateExp = payData.getBillingDate().plusMonths(addedMonths);
    int dayOfFirstBilling = payData.getFirstBillingDate().getDayOfMonth();

    if (dayOfFirstBilling != candidateExp.getDayOfMonth()) {
      int dayLenOfCandiMon = YearMonth.from(candidateExp).lengthOfMonth();
      if(dayLenOfCandiMon < dayOfFirstBilling) {
        return candidateExp.withDayOfMonth(dayLenOfCandiMon);
      }
      return candidateExp.withDayOfMonth(dayOfFirstBilling);
    } else {
      return candidateExp;
    }
  }
}
