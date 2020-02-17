package me.jdragon.atddsubway.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;
import javax.persistence.EntityNotFoundException;
import me.jdragon.atddsubway.application.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

/**
 * @author choijaeyong on 2020/02/17.
 * @project atddsubway
 * @description
 */
@DataJpaTest
class MemberRepositoryTest {

  @Autowired
  private MemberRepository memberRepository;

  @DisplayName("회원 저장")
  @Test
  public void create_member() {
    Member member = new Member("email", "name", "pw");
    Member persistMember = memberRepository.save(member);
    assertThat(persistMember.getId()).isEqualTo(1L);
  }

  @DisplayName("회원 조회시 회원 없을 때")
  @Test
  public void get_member() {
//    Optional<Member> byId = memberRepository.findById(1L);
//    System.out.println(byId);
    assertThatExceptionOfType(NotFoundMemberException.class).isThrownBy(() ->
        memberRepository.findById(1L).orElseThrow(NotFoundMemberException::new));
    //MemberService memberService = new MemberService(memberRepository);
    //assertThatExceptionOfType(EntityNotFoundException.class).isThrownBy(() -> memberService.getMember(1L));



  }

}