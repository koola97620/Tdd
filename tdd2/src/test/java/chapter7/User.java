package chapter7;

/**
 * @author choijaeyong on 2020/04/08.
 * @project tdd2
 * @description
 */
public class User {

  private final String id;
  private final String pw;
  private final String email;

  public User(String id, String pw, String email) {
    this.id = id;
    this.pw = pw;
    this.email = email;
  }

  public String getId() {
    return id;
  }

  public String getEmail() {
    return email;
  }
}
