package me.jdragon.junitinaction.chapter05;

/**
 * @author choijaeyong on 2020/01/26.
 * @project junitinaction
 * @description
 */
public class Vehicle {
//  Driver d = new Driver();
//  boolean hasDriver = true;
//  private void setHasDriver(boolean hasDriver) {
//    this.hasDriver = hasDriver;
//  }

  Driver d;
  boolean hasDriver = true;
  Vehicle(Driver d) {
    this.d = d;
  }
  private void setHasDriver(boolean hasDriver) {
    this.hasDriver = hasDriver;
  }

}
