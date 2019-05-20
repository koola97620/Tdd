package study;


import static org.junit.Assert.fail;

import org.junit.Test;
import sun.security.util.Password;

/**
 * @author choijaeyong on 20/05/2019.
 * @project tddExamSpringCamp
 * @description
 */
public class UserRegistTest {

  @Test
  public void context() {

  }

  @Test
  public void 암호가_약하면_가입실패() {
    StubPasswordChecker passwordChecker = new StubPasswordChecker();
    UserRegist userRegist = new UserRegist(passwordChecker);

    passwordChecker.setWeak(true);

    try {
      RegistRequest req = new RegistRequest("id","pw","email");
      userRegist.regist(req);
      fail();
    } catch (WeakPasswordException e) {

    }

//    RegistRequest userRequest = new RegistRequest("id","pw","email");
//    userRegist.regist(userRequest);




  }


  private class StubPasswordChecker implements PasswordChecker {

    private boolean weak;
    public void setWeak(boolean weak) {
      this.weak = weak;
    }
    @Override
    public boolean checkWeakPassword(String pw) {
      return weak;
    }
  }
}
