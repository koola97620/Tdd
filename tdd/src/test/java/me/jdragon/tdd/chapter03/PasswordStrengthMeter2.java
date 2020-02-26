package me.jdragon.tdd.chapter03;

import me.jdragon.tdd.chapter02.PasswordStrength;

/**
 * @author choijaeyong on 2020/02/24.
 * @project tdd
 * @description
 */
public class PasswordStrengthMeter2 {

  public PasswordStrength meter(String s) {
    int count = 0;
    if (s.length() < 8) {
      count++;
    }

    boolean hasNumber=false;
    for (char ch : s.toCharArray()) {
      if ( ch >= '0' && ch <= '9') {
        hasNumber=true;
      }
    }

    if (!hasNumber) {
      count++;
    }

    if (count == 1) {
      return PasswordStrength.NORMAL;
    } else if (count == 2) {
      return PasswordStrength.WEAK;
    }

    return PasswordStrength.STRONG;
  }
}
