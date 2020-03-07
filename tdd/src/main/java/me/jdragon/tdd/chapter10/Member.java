package me.jdragon.tdd.chapter10;

import java.time.LocalDateTime;
import org.apache.tomcat.jni.Local;

/**
 * @author choijaeyong on 2020/03/07.
 * @project tdd
 * @description
 */
public class Member {
  private LocalDateTime expiryDate;

  public boolean isExpired() {
    return expiryDate.isBefore(BizClock.now());
  }

  public boolean passedExpiryDate(LocalDateTime time) {
    return expiryDate.isBefore(time);
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder {
    private Member member = new Member();

    public Builder expiryDate(LocalDateTime ldt) {
      member.expiryDate = ldt;
      return this;
    }

    public Member build() {
      return member;
    }
  }

}
