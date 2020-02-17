package me.jdragon.atddsubway.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author choijaeyong on 2020/02/17.
 * @project atddsubway
 * @description
 */
class MemberTest {

  @DisplayName("회원 생성")
  @Test
  public void create() {
    String name = "name";
    Member member = new Member("email", "name", "pw");
    assertThat(member.getName()).isEqualTo(name);
  }

}