package chapter2;

/**
 * @author choijaeyong on 2020/03/17.
 */
public class PasswordStrengthMeter {

  public PasswordStrength meter(String s) {
    if (s.length() < 8) {
      return PasswordStrength.NORMAL;
    }

    boolean isContainNum = isContainNum(s);

    if (!isContainNum) {
      return PasswordStrength.NORMAL;
    }

    return PasswordStrength.STRONG;
  }

  private boolean isContainNum(String s) {
    boolean isContainNum = false;
    for (char ch : s.toCharArray()) {
      if (ch >= '0' && ch <= '9') {
        isContainNum = true;
        break;
      }
    }
    return isContainNum;
  }
}
