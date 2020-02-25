package me.jdragon.tdd.chapter03;

import java.time.LocalDate;

/**
 * @author choijaeyong on 2020/02/26.
 * @project tdd
 * @description
 */
public class PayData {
  private LocalDate billingDate;
  private int paymentAmount;
  private LocalDate firstBillingDate;

  private PayData() {}

  public PayData(LocalDate firstBillingDate, LocalDate billingDate , int paymentAmount) {
    this.firstBillingDate = firstBillingDate;
    this.billingDate = billingDate;
    this.paymentAmount = paymentAmount;
  }

  public LocalDate getBillingDate() {
    return billingDate;
  }

  public int getPaymentAmount() {
    return paymentAmount;
  }

  public LocalDate getFirstBillingDate() {
    return firstBillingDate;
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder {
    private PayData data = new PayData();

    public Builder billingDate(LocalDate billingDate) {
      data.billingDate = billingDate;
      return this;
    }
    public Builder payAmount(int payAmount) {
      data.paymentAmount = payAmount;
      return this;
    }
    public Builder firstBillingDate(LocalDate firstBillingDate) {
      data.firstBillingDate = firstBillingDate;
      return this;
    }
    public PayData build() {
      return data;
    }
  }
}
