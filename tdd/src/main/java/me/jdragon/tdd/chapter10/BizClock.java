package me.jdragon.tdd.chapter10;

import java.time.LocalDateTime;

/**
 * @author choijaeyong on 2020/03/07.
 * @project tdd
 * @description
 */
public class BizClock {
  private static BizClock DEFAULT = new BizClock();
  private static BizClock instance = DEFAULT;

  public static void reset() {
    instance = DEFAULT;
  }

  public static LocalDateTime now() {
    return instance.timeNow();
  }

  protected  void setInstance(BizClock bizClock) {
    BizClock.instance = bizClock;
  }

  public LocalDateTime timeNow() {
    return LocalDateTime.now();
  }


}
