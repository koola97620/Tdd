package me.jdragon.tdd.chapter03;

import me.jdragon.tdd.chapter02.PasswordStrength;

/**
 * @author choijaeyong on 2020/02/24.
 * @project tdd
 * @description
 */
public class PasswordStrengthMeter2 {

  public PasswordStrength meter(String s) {
    if (s.length() < 8) {
      return PasswordStrength.NORMAL;
    }
    return PasswordStrength.STRONG;
  }
}
