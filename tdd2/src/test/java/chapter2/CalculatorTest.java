package chapter2;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/**
 * @author choijaeyong on 2020/03/17.
 * @project tdd2
 * @description
 */
public class CalculatorTest {

  @Test
  public void plus() {
    int result = Calculator.plus(1,2);
    assertThat(result).isEqualTo(3);
    assertThat(Calculator.plus(2,3)).isEqualTo(5);
  }
}
