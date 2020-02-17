package me.jdragon.atddsubway.application;

import java.util.NoSuchElementException;
import java.util.Optional;
import javax.persistence.EntityNotFoundException;
import me.jdragon.atddsubway.domain.Member;
import me.jdragon.atddsubway.domain.MemberRepository;
import org.springframework.stereotype.Service;

/**
 * @author choijaeyong on 2020/02/17.
 * @project atddsubway
 * @description
 */
@Service
public class MemberService {

  private MemberRepository memberRepository;

  public MemberService(MemberRepository memberRepository) {
    this.memberRepository = memberRepository;
  }

  public Member getMember(Long id) {
    return null;
  }

}
