package exam;

/**
 * @author choijaeyong on 19/05/2019.
 * @project junit5test2
 * @description
 */
public class User {


  private String id;
  private String pw;

  public User(String id, String pw) {
    this.id = id;
    this.pw = pw;
  }

  public String getId() {
    return id;
  }

  public String getPw() {
    return pw;
  }
}
