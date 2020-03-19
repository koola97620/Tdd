package chapter2;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author choijaeyong on 2020/03/17.
 * @project tdd2
 * @description
 */
public class PasswordStrengthMeterTest {

  private PasswordStrengthMeter meter;

  @BeforeEach
  public void setUp() {
    meter = new PasswordStrengthMeter();
  }

  @Test
  void meetsAllCriteria_Then_Strong() {
    //PasswordStrength passwordStrength = meter.meter("ab12!@AB");
    //assertThat(passwordStrength).isEqualTo(PasswordStrength.STRONG);
    assertStrength("ab12!@AB", PasswordStrength.STRONG);
  }

  @Test
  public void meetsOtherCriteria_except_for_Length_Then_Normal() {
    assertStrength("ab12!@A",PasswordStrength.NORMAL);
    assertStrength("Ab12!c",PasswordStrength.NORMAL);
  }

  @Test
  public void meetsOtherCriteria_except_for_number_Then_Normal() {
    PasswordStrength result = this.meter.meter("ab!@ABqwer");
    assertThat(result).isEqualTo(PasswordStrength.NORMAL);
  }

  private void assertStrength(String password, PasswordStrength expStr) {
    PasswordStrength meter = this.meter.meter(password);
    assertThat(meter).isEqualTo(expStr);

  }
}
