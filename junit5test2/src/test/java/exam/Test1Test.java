package exam;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

import org.junit.jupiter.api.Test;

/**
 * @author choijaeyong on 11/05/2019.
 * @project junit5test2
 * @description
 */
class Test1Test {

  @Test
  public void context() {

  }

  // 비번 체크, 기존 유저 검색, 이메일 알림
  // UserRegist userRegist = new UserRegist();

  @Test
  public void userRegist() {
    UserRegist userRegist = new UserRegist();

    PasswordChecker checker = new StubPasswordChecker();
    checker.check("");

    userRegist.regist();

    assertThat("", equalTo(""));

  }

  @Test
  public void givenInvalidPassword() {
    PasswordChecker passwordChecker = new StubPasswordChecker();

    User user = new User("id","pw");

    passwordChecker.check("");

  }

}