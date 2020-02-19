package me.jdragon.atddsubway.presentation;

import java.net.URI;
import java.util.Optional;
import me.jdragon.atddsubway.domain.CreateMemberRequestDTO;
import me.jdragon.atddsubway.domain.CreateMemberResponseDTO;
import me.jdragon.atddsubway.domain.Member;
import me.jdragon.atddsubway.domain.MemberRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author choijaeyong on 2020/02/17.
 * @project atddsubway
 * @description
 */

@RestController
public class MemberController {

  private MemberRepository memberRepository;

  public MemberController(MemberRepository memberRepository) {
    this.memberRepository = memberRepository;
  }

  @PostMapping("/members")
  public ResponseEntity createMember(@RequestBody CreateMemberRequestDTO requestDTO) {
    Member persistMember = memberRepository.save(requestDTO.toMember());
    return ResponseEntity.created(URI.create("/members" + persistMember.getId()) )
        .body(CreateMemberResponseDTO.of(persistMember));
  }

  @GetMapping("/members/{id}")
  public ResponseEntity getMember(@PathVariable Long id) {
    // todo null 일때 예외처리 할거 필요
    Member member = memberRepository.findById(id).get();
    return ResponseEntity.ok(CreateMemberResponseDTO.of(member));
  }

  @DeleteMapping("/members/{id}")
  public ResponseEntity deleteMember(@PathVariable Long id) {
    return ResponseEntity.noContent().build();
  }

}
