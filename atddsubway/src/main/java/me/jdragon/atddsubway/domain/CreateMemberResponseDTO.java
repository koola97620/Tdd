package me.jdragon.atddsubway.domain;

/**
 * @author choijaeyong on 2020/02/17.
 * @project atddsubway
 * @description
 */
public class CreateMemberResponseDTO {

  private Long id;
  private String email;
  private String name;
  private String password;

  public CreateMemberResponseDTO() {

  }

  public CreateMemberResponseDTO(Member member) {
    id = member.getId();
    email = member.getEmail();
    name = member.getName();
    password = member.getPassword();
  }

  public Long getId() {
    return id;
  }

  public String getEmail() {
    return email;
  }

  public String getName() {
    return name;
  }

  public String getPassword() {
    return password;
  }

  public static CreateMemberResponseDTO of(Member member) {
    return new CreateMemberResponseDTO(member);
  }

}
