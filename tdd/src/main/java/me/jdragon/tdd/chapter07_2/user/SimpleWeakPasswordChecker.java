package me.jdragon.tdd.chapter07_2.user;

import org.springframework.stereotype.Component;

/**
 * @author choijaeyong on 2020/03/07.
 * @project tdd
 * @description
 */

@Component
public class SimpleWeakPasswordChecker implements WeakPasswordChecker {

  @Override
  public boolean checkPasswordWeak(String pw) {
    return pw == null || pw.length() < 5;
  }
}
