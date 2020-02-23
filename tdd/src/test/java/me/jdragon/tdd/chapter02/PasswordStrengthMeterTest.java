package me.jdragon.tdd.chapter02;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author choijaeyong on 2020/02/23.
 * @project tdd
 * @description
 */
class PasswordStrengthMeterTest {
  @Test
  public void meetsAllCriteira_Then_Strong() {
    PasswordStrengthMeter passwordStrengthMeter = new PasswordStrengthMeter();
    PasswordStrength result = passwordStrengthMeter.meter("abab2121");
    assertThat(result).isEqualTo(PasswordStrength.STRONG);

    PasswordStrength result2 = passwordStrengthMeter.meter("abc12311");
    assertThat(result2).isEqualTo(PasswordStrength.STRONG);
  }

  @Test
  public void meetsOtherCriteria_expect_for_Length_Then_Normal() {
    PasswordStrengthMeter meter = new PasswordStrengthMeter();
    PasswordStrength result = meter.meter("ab12!@A");
    assertThat(result).isEqualTo(PasswordStrength.NORMAL);

    PasswordStrength result2 = meter.meter("ABC12!");
    assertThat(result2).isEqualTo(PasswordStrength.NORMAL);
  }

}