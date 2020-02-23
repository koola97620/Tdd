package me.jdragon.tdd.chapter02;

/**
 * @author choijaeyong on 2020/02/23.
 * @project tdd
 * @description
 */
public class PasswordStrengthMeter {

  public PasswordStrength meter(String s) {
    if (s.length() < 8) {
      return PasswordStrength.NORMAL;
    }
    return PasswordStrength.STRONG;
  }
}
