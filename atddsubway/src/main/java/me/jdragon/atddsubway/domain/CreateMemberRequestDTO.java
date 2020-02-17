package me.jdragon.atddsubway.domain;

import lombok.Getter;
import lombok.Setter;
import me.jdragon.atddsubway.domain.Member;

/**
 * @author choijaeyong on 2020/02/17.
 * @project atddsubway
 * @description
 */
@Getter
public class CreateMemberRequestDTO {

  private String email;
  private String name;
  private String password;

  public CreateMemberRequestDTO(String email, String name, String password) {
    this.email = email;
    this.name = name;
    this.password = password;
  }

  public Member toMember() {
    return new Member(email,name,password);
  }

}
