package me.jdragon.junitinaction.chapter01;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author choijaeyong on 2020/01/19.
 * @project junitinaction
 * @description
 */
class CalculatorTest {

  @Test
  public void calculate_add_test() {
    Calculator calculator = new Calculator();
    double result = calculator.add(10,50);
    assertThat(result).isEqualTo(10+50);
  }

}