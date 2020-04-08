package chapter7;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author choijaeyong on 2020/04/08.
 * @project tdd2
 * @description
 */
public class UserRegisterTest {

  private StubWeakPasswordChecker stubPasswordChecker = new StubWeakPasswordChecker();
  private UserRegister userRegister;

  @BeforeEach
  public void setUp() {
    userRegister = new UserRegister(stubPasswordChecker);
  }

  @Test
  public void 약한_암호면_가입_실패() {
    stubPasswordChecker.setWeak(true);

    assertThatExceptionOfType(WeakPasswordException.class)
        .isThrownBy( () -> userRegister.register("id","pw","email"));
  }

}
