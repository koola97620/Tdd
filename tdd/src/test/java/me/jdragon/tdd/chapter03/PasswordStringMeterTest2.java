package me.jdragon.tdd.chapter03;

import static org.assertj.core.api.Assertions.assertThat;

import me.jdragon.tdd.chapter02.PasswordStrength;
import me.jdragon.tdd.chapter02.PasswordStrengthMeter;
import org.junit.jupiter.api.Test;

/**
 * @author choijaeyong on 2020/02/24.
 * @project tdd
 * @description
 */
public class PasswordStringMeterTest2 {

  @Test
  public void meetsOnlyUpperCriteria_Then_Weak() {
    PasswordStrengthMeter2 passwordStrengthMeter = new PasswordStrengthMeter2();
    PasswordStrength result = passwordStrengthMeter.meter("abcDef");
    assertThat(result).isEqualTo(PasswordStrength.WEAK);
  }

  @Test
  public void meetsAllCriteria_Then_Weak() {
    PasswordStrengthMeter2 passwordStrengthMeter2 = new PasswordStrengthMeter2();
    PasswordStrength result = passwordStrengthMeter2.meter("abcDef12");
    assertThat(result).isEqualTo(PasswordStrength.STRONG);

    PasswordStrength result2 = passwordStrengthMeter2.meter("aZcDef12");
    assertThat(result2).isEqualTo(PasswordStrength.STRONG);
  }

  @Test
  public void meetsOtherCreteria_except_for_Length_Then_Normal() {
    PasswordStrengthMeter2 meter = new PasswordStrengthMeter2();
    PasswordStrength result = meter.meter("ab12!@A");
    assertThat(result).isEqualTo(PasswordStrength.NORMAL);

    PasswordStrength result2 = meter.meter("Ab12!c");
    assertThat(result2).isEqualTo(PasswordStrength.NORMAL);
  }

}
