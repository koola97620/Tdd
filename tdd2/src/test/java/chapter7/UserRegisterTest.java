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
  private FakeUserRepository fakeRepository = new FakeUserRepository();

  @BeforeEach
  public void setUp() {
    userRegister = new UserRegister(stubPasswordChecker, fakeRepository);
  }

  @Test
  public void 약한_암호면_가입_실패() {
    stubPasswordChecker.setWeak(true);

    assertThatExceptionOfType(WeakPasswordException.class)
        .isThrownBy( () -> userRegister.register("id","pw","email"));
  }

  @Test
  public void 이미_같은_ID가_존재하면_가입_실패() {
    fakeRepository.save(new User("id","pw1","email@email.com"));

    assertThatExceptionOfType(DupIdException.class)
        .isThrownBy(() -> userRegister.register("id","pw2","email"));
  }

  @Test
  public void 같은_ID가_없으면_가입_성공함() {
    userRegister.register("id","pw","email");
    User savedUser = fakeRepository.findById("id");
    assertThat(savedUser.getId()).isEqualTo("id");
    assertThat(savedUser.getEmail()).isEqualTo("email");
  }
}
