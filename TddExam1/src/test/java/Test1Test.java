import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * @author choijaeyong on 05/05/2019.
 * @project TddExam1
 * @description
 */
public class Test1Test {

  @Test
  public void sum() {
    Dollar five = new Dollar(5);
    five.times(2);
    assertThat(five.amount).isEqualTo(10);
  }
}