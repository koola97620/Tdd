package me.jdragon.atddsubway.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author choijaeyong on 2020/02/17.
 * @project atddsubway
 * @description
 */

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Member {

  @Id
  @GeneratedValue
  private Long id;

  @Column(length=100, nullable = false)
  private String email;

  @Column(length=100, nullable = false, unique = true)
  private String name;

  @Column(length=30, nullable = false)
  private String password;

  @Builder
  public Member(String email, String name, String password) {
    this.email = email;
    this.name = name;
    this.password = password;
  }

}
