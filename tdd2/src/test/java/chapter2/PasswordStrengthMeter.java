package chapter2;

/**
 * @author choijaeyong on 2020/03/17.
 */
public class PasswordStrengthMeter {

  public PasswordStrength meter(String s) {
    if(s == null || "".equals(s)) return PasswordStrength.INVALID;

    int metCounts = 0;

    boolean lengthEnough = s.length() >= 8;
    if (lengthEnough) metCounts++;

    boolean isContainNum = isContainNum(s);
    if (isContainNum) metCounts++;

    boolean containUpper = isContainUpper(s);
    if (containUpper) metCounts++;

    if (metCounts == 1) return PasswordStrength.WEAK;
    // 조건이 하나만 충족하지 못하고 나머지 2개는 충족하는 경우.
//    if (!lengthEnough) {
//      return PasswordStrength.NORMAL;
//    }
//    if (!isContainNum) {
//      return PasswordStrength.NORMAL;
//    }
//    if (!containUpper) return PasswordStrength.NORMAL;
    if (metCounts == 2) return PasswordStrength.NORMAL;

    return PasswordStrength.STRONG;
  }

  private boolean isContainUpper(String s) {
    boolean containUpper = false;
    for (char ch : s.toCharArray()) {
      if (Character.isUpperCase(ch)) {
        containUpper = true;
        break;
      }
    }
    return containUpper;
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
