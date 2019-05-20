package study;

/**
 * @author choijaeyong on 20/05/2019.
 * @project tddExamSpringCamp
 * @description
 */
public class RegistRequest {

  private final String id;
  private final String pw;
  private final String email;

  public RegistRequest(String id, String pw, String email) {

    this.id = id;
    this.pw = pw;
    this.email = email;
  }

  public String getId() {
    return id;
  }

  public String getPw() {
    return pw;
  }

  public String getEmail() {
    return email;
  }
}
