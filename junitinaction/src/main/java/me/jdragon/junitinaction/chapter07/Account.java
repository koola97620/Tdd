package me.jdragon.junitinaction.chapter07;

/**
 * @author choijaeyong on 2020/02/02.
 * @project junitinaction
 * @description
 */
public class Account {

  private String accountId;
  private long balance;

  public Account(String accountId, long initialBalance) {
    this.accountId = accountId;
    this.balance = initialBalance;
  }

  public void debit(long amount) {
    this.balance -= amount;
  }

  public void credit(long amount) {
    this.balance += amount;
  }

  public long getBalance() {
    return this.balance;
  }
}
