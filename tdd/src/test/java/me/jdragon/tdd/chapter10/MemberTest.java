package me.jdragon.tdd.chapter10;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import me.jdragon.tdd.chapter03.PayData;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

/**
 * @author choijaeyong on 2020/03/07.
 * @project tdd
 * @description
 */
class MemberTest {

  TestBizClock testBizClock = new TestBizClock();

  @AfterEach
  public void resetClock() {
    BizClock.reset();
  }

  @Test
  public void notExpired() {
    LocalDateTime expiry = LocalDateTime.of(2019, 12, 31, 0, 0, 0);
    Member member = Member.builder().expiryDate(expiry).build();
    assertThat(member.passedExpiryDate(LocalDateTime.of(2019,12,30,0,0,0))).isFalse();
  }

  @Test
  public void notExpired_using_bizclock() {
    testBizClock.setNow(LocalDateTime.of(2019,1,1,13,0,0));
    LocalDateTime expiry = LocalDateTime.of(2019, 12, 31, 0, 0, 0);
    Member m = Member.builder().expiryDate(expiry).build();
    assertThat(m.isExpired()).isFalse();
  }

  @Test
  public void expired_only_1ms() {
    LocalDateTime expiry = LocalDateTime.of(2019, 12, 31, 0, 0, 0);
    Member member = Member.builder().expiryDate(expiry).build();
    assertThat(member.passedExpiryDate(LocalDateTime.of(2019,12,30,0,0,0,1000000))).isFalse();
  }



}