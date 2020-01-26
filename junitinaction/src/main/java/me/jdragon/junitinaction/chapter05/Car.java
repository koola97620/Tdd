package me.jdragon.junitinaction.chapter05;

/**
 * @author choijaeyong on 2020/01/26.
 * @project junitinaction
 * @description
 */
public class Car {
  private Driver driver;
  public Car(Context context) {
    this.driver = context.getDriver();
  }
//  public Car(Driver driver) {
//    this.driver=driver;
//  }
}
