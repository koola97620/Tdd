package me.jdragon.tdd.chapter10;

import java.time.LocalDateTime;

/**
 * @author choijaeyong on 2020/03/07.
 * @project tdd
 * @description
 */
public class TestBizClock extends BizClock {
  private LocalDateTime now;

  public TestBizClock() {
    setInstance(this);
  }

  public void setNow(LocalDateTime now) {
    this.now = now;
  }

  public LocalDateTime timeNow() {
    return now != null ? now : super.now();
  }

}
