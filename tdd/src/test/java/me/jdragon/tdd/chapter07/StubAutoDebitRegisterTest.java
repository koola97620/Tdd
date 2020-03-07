package me.jdragon.tdd.chapter07;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author choijaeyong on 2020/03/07.
 * @project tdd
 * @description
 */
class StubAutoDebitRegisterTest {
  private AutoDebitRegister autoDebitRegister;
  private StubCardNumberValidator stubCardNumberValidator;
  private JpaAutoDebitInfoRepository jpaAutoDebitInfoRepository;


  @BeforeEach
  public void setUp() {
    stubCardNumberValidator = new StubCardNumberValidator();
    jpaAutoDebitInfoRepository = new JpaAutoDebitInfoRepository();
    autoDebitRegister = new AutoDebitRegister(stubCardNumberValidator,
        jpaAutoDebitInfoRepository);
  }

  @Test
  public void validCard() {
    stubCardNumberValidator.setInvalidNo("111222333");

    AutoDebitReq req = new AutoDebitReq("user1", "111222333");
    RegisterResult result = autoDebitRegister.register(req);

    assertThat(result.getValidity()).isEqualTo(CardValidity.VALID);
  }

}