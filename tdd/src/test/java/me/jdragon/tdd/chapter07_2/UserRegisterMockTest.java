package me.jdragon.tdd.chapter07_2;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.BDDMockito;

/**
 * @author choijaeyong on 2020/03/07.
 * @project tdd
 * @description
 */
public class UserRegisterMockTest {

  private UserRegister userRegister;
  private WeakPasswordChecker mockPasswordChecker = mock(WeakPasswordChecker.class);
  private UserRepository fakeRepository = mock(UserRepository.class);
  private EmailNotifier mockEmailNotifer = mock(EmailNotifier.class);

  @BeforeEach
  public void setUp() {
    userRegister = new UserRegister(mockPasswordChecker, fakeRepository, mockEmailNotifer);

  }

  @DisplayName("약한 암호면 가입 실패")
  @Test
  public void weakPassword() {
    BDDMockito.given(mockPasswordChecker.checkPasswordWeak("pw")).willReturn(true);

    assertThatExceptionOfType(WeakPasswordException.class).isThrownBy(
        () -> userRegister.register("id","pw","email")
    );
  }

  @DisplayName("회원 가입시 암호 검사 수행함")
  @Test
  public void checkPassword() {
    userRegister.register("id","pw","email");
    BDDMockito.then(mockPasswordChecker)
        .should()
        .checkPasswordWeak(BDDMockito.anyString());
  }

  @DisplayName("가입하면 메일을 전송함 ")
  @Test
  public void whenRegisterThenSendMail() {
    userRegister.register("id","pw","email@email.com");

    ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
    BDDMockito.then(mockEmailNotifer)
        .should()
        .sendRegisterEmail(captor.capture());

    String realEmail = captor.getValue();
    assertThat(realEmail).isEqualTo("email@email.com");
  }

}
