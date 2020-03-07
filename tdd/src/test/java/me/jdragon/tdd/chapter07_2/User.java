package me.jdragon.tdd.chapter07_2;

/**
 * @author choijaeyong on 2020/03/07.
 * @project tdd
 * @description
 */
public class User {

  private final String id;
  private final String pw1;
  private final String email;

  public User(String id, String pw1, String email) {
    this.id = id;
    this.pw1 = pw1;
    this.email = email;
  }

  public String getId() {
    return id;
  }

  public String getEmail() {
    return email;
  }
}
