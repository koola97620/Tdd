package me.jdragon.tdd.chapter07_2.user;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.NoArgsConstructor;

/**
 * @author choijaeyong on 2020/03/07.
 * @project tdd
 * @description
 */

@Entity
@NoArgsConstructor
public class User {
  @Id
  private String id;
  private String password;
  private String email;

  public User(String id, String password, String email) {
    this.id = id;
    this.password = password;
    this.email = email;
  }

  public String getId() {
    return id;
  }

  public String getEmail() {
    return email;
  }
}
