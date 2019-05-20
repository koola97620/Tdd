package study;

/**
 * @author choijaeyong on 20/05/2019.
 * @project tddExamSpringCamp
 * @description
 */
public class UserRegist {

  private PasswordChecker passwordChecker;

  public UserRegist(PasswordChecker passwordChecker) {
    this.passwordChecker = passwordChecker;
  }

  public void regist(RegistRequest req) {
    if(passwordChecker.checkWeakPassword(req.getPw())) {
      throw new WeakPasswordException();
    }

  }
}
