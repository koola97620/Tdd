package me.jdragon.tdd.chapter07_2;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import me.jdragon.tdd.chapter07_2.user.DupIdException;
import me.jdragon.tdd.chapter07_2.user.RegisterReq;
import me.jdragon.tdd.chapter07_2.user.User;
import me.jdragon.tdd.chapter07_2.user.UserRegister;
import me.jdragon.tdd.chapter07_2.user.UserRegisterService;
import me.jdragon.tdd.chapter07_2.user.WeakPasswordException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author choijaeyong on 2020/03/07.
 * @project tdd
 * @description
 */
public class UserRegisterTest {
  private UserRegister userRegister;
  private StubWeakPasswordChecker stubPasswordChecker = new StubWeakPasswordChecker();
  private MemoryUserRepository fakeRepository = new MemoryUserRepository();
  private SpyEmailNotifier spyEmailNotifer = new SpyEmailNotifier();
  private UserRegisterService userRegisterService;

  @BeforeEach
  public void setUp() {
    userRegister = new UserRegister(stubPasswordChecker, fakeRepository, spyEmailNotifer);
    userRegisterService = new UserRegisterService();
  }

  @DisplayName("약한 암호면 가입 실패")
  @Test
  public void weakPassword() {
    stubPasswordChecker.setWeak(true);

    assertThatExceptionOfType(WeakPasswordException.class).isThrownBy(
        () -> userRegister.register("id","pw","email")
    );
  }

  @DisplayName("같은 ID가 존재하면 가입 실패")
  @Test
  public void dupIdExists() {
    // 이미 같은 ID 존재하는 상황 만들기
    fakeRepository.save(new User("id", "pw1", "email@email.com"));
    assertThatExceptionOfType(DupIdException.class).isThrownBy(
        () -> userRegister.register("id","pw2","email")
    );
  }

  @DisplayName("chapter10 - 같은 ID가 존재하면 가입 실패")
  @Test
  public void dupIdExists_using_chapter10() {
    // 이미 같은 ID 존재하는 상황 만들기 . 검증 범위를 벗어나는 값은 빼라.
    fakeRepository.save(User.builder()
        .id("dupid")
//        .email("koo@gmail.com")
//        .password("abcd")
        .build());

    RegisterReq req = RegisterReq.builder()
        .id("dupid")
//        .name("다른이름")
//        .email("koo@gmail.com")
//        .password("abcd")
        .build();

    assertThatExceptionOfType(DupIdException.class).isThrownBy(
        () -> userRegisterService.register(req)
    );
  }

  @DisplayName("같은 ID가 없으면 가입 성공")
  @Test
  public void noDupId_RegisterSuccess() {
    userRegister.register("id","pw","email");

    User savedUser = fakeRepository.findById("id");
    assertThat(savedUser.getId()).isEqualTo("id");
    assertThat(savedUser.getEmail()).isEqualTo("email");
  }

  @DisplayName("가입하면 메일을 전송함")
  @Test
  public void whenRegisteThenSendMail() {
    userRegister.register("id","pw","email@email.com");

    assertThat(spyEmailNotifer.isCalled()).isTrue();
    assertThat(spyEmailNotifer.getEmail()).isEqualTo("email@email.com");
  }

}
