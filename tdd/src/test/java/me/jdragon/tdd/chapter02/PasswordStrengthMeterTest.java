package me.jdragon.tdd.chapter02;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/**
 * @author choijaeyong on 2020/02/23.
 * @project tdd
 * @description
 */
class PasswordStrengthMeterTest {
  private PasswordStrengthMeter meter = new PasswordStrengthMeter();
  @Test
  public void meetsAllCriteira_Then_Strong() {
    assertStrength("abAb2121" , PasswordStrength.STRONG);
    assertStrength("abC12311" , PasswordStrength.STRONG);
  }

  @Test
  public void meetsOtherCriteria_except_for_Length_Then_Normal() {
    assertStrength("ab12!@A" , PasswordStrength.NORMAL);
    assertStrength("ABC12!" , PasswordStrength.NORMAL);
  }

  @Test
  public void meetsOtherCriteria_except_for_number_Then_Normal() {
    assertStrength("ab!@ABQWER" , PasswordStrength.NORMAL);
  }

  private void assertStrength(String password, PasswordStrength expStr) {
    PasswordStrength result = meter.meter(password);
    assertThat(result).isEqualTo(expStr);
  }

  @Test
  public void nullInput_Then_Invalid() {
    assertStrength(null, PasswordStrength.INVALID);
  }

  @Test
  public void emptyInput_Then_Invalid() {
    assertStrength("",PasswordStrength.INVALID);
  }

  @Test
  public void meetsOtherCriteria_except_for_Uppercase_Then_Normal() {
    assertStrength("ab12!@#$" , PasswordStrength.NORMAL);
  }

  @Test
  public void meetsOnlyLengthCriteria_Then_Weak() {
    assertStrength("abcdefghi" , PasswordStrength.WEAK);
  }

  @Test
  public void meetsOnlyNumCriteira_Then_Weak() {
    assertStrength("12345", PasswordStrength.WEAK);
  }

  @Test
  public void meetsOnlyUpperCritera_Then_Weak() {
    assertStrength("ABZFF" , PasswordStrength.WEAK);
  }

  @Test
  public void meetsNoCriteria_Then_Weak() {
    assertStrength("abc" , PasswordStrength.WEAK);
  }

}