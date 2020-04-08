package chapter7;

/**
 * @author choijaeyong on 2020/04/08.
 * @project tdd2
 * @description
 */
public class UserRegister {

  private WeakPasswordChecker passwordChecker;

  public UserRegister(WeakPasswordChecker passwordChecker) {
    this.passwordChecker = passwordChecker;
  }

  public void register(String id, String pw, String email) {
    if (passwordChecker.checkPasswordWeak(pw)) {
      throw new WeakPasswordException();
    }
  }
}
