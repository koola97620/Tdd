package tistory;

/**
 * @author choijaeyong on 2020/04/08.
 * @project tdd2
 * @description
 */
public class Product {
  private String name;
  private Money price;

  public Product(String name, int price) {
    this.name = name;
    this.price = new Money(price);
  }

  public void applyDiscountCoupon(DiscountCoupon discountCoupon) {
    this.price = new Money(this.price.getValue() - discountCoupon.getMoney());
  }

  public String getName() {
    return name;
  }

  public int getPrice() {
    return price.getValue();
  }

}
