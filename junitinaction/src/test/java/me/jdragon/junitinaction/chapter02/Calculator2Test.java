package me.jdragon.junitinaction.chapter02;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;
import org.assertj.core.internal.Numbers;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * @author choijaeyong on 2020/01/19.
 * @project junitinaction
 * @description
 */
class Calculator2Test {

  @ParameterizedTest
  @ValueSource(doubles = {1,3,5,7,9})
  public void calculate_multiply_two_test(double number) {
    Calculator2 calculator2 = new Calculator2();
    double result = calculator2.multiple_two(number);
    assertThat(result).isEqualTo(number * 2);
  }

  @ParameterizedTest
  @MethodSource("provideOddDouble")
  public void is_not_double(double num, boolean expected) {
    assertThat(num % 2 == 0).isEqualTo(expected);
  }

  private static Stream<Arguments> provideOddDouble() {
    return Stream.of(
        Arguments.of(1, false),
        Arguments.of(2, true),
        Arguments.of(4, true),
        Arguments.of(6, true),
        Arguments.of(7,false)
    );
  }

}