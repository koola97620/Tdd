package me.jdragon.junitinaction.chapter05;

/**
 * @author choijaeyong on 2020/01/26.
 * @project junitinaction
 * @description
 */
public class ReservationClient {
  public void reserve() {
    DBManager manager = new DBManager();
    manager.initDatabase();
    Reservation r = new Reservation();
    r.reserve();
  }

  public void reserve2() {
    DBManager manager = new DBManager();
    manager.initDatabase();
    Reservation reservation = new Reservation(manager);
    reservation.reserve();
  }

}
