package tistory;

/**
 * @author choijaeyong on 2020/04/08.
 * @project tdd2
 * @description
 */
public class DiscountCoupon {
  private Money value;

  public DiscountCoupon(int value) {
    this.value = new Money(value);
  }

  public Money getValue() {
    return value;
  }

  public int getMoney() {
    return value.getValue();
  }

}
