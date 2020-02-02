package me.jdragon.junitinaction.chapter07;

/**
 * @author choijaeyong on 2020/02/02.
 * @project junitinaction
 * @description
 */
public interface AccountManager {
  Account findAccountForUser(String userId);
  void updateAccount(Account account);

}
