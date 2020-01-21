package me.jdragon.junitinaction.chapter03;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author choijaeyong on 2020/01/22.
 * @project junitinaction
 * @description
 */
public class MatcherTest {
  private List<String> values;

  @BeforeEach
  public void setUpList() {
    values = new ArrayList<>();
    values.add("x");
    values.add("y");
    values.add("z");
  }

  @Test
  public void testWithoutMatcher() {
    assertThat(values.contains("one") || values.contains("two") || values.contains("three"))
        .isTrue();
  }

  @Test
  public void testWithMatcher() {
    assertThat(values).containsAnyOf("one","two","three");
  }

}
