package me.jdragon.tdd.chapter07_2;

import me.jdragon.tdd.chapter07_2.user.EmailNotifier;

/**
 * @author choijaeyong on 2020/03/07.
 * @project tdd
 * @description
 */
public class SpyEmailNotifier implements EmailNotifier {
  private boolean called;
  private String email;

  public boolean isCalled() {
    return called;
  }

  public String getEmail() {
    return email;
  }

  @Override
  public void sendRegisterEmail(String email) {
    this.called = true;
    this.email = email;
  }
}
