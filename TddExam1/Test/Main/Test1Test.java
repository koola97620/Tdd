package Main;

import static org.junit.Assert.*;

import org.junit.Test;

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
    assertEquals(10,five.amount);
  }
}