package me.jdragon.tdd.chapter07;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author choijaeyong on 2020/03/07.
 * @project tdd
 * @description
 */
class AutoDebitRegisterTest {
  private AutoDebitRegister autoDebitRegister;
  private CardNumberValidator cardNumberValidator;
  private MemoryAutoDebitInfoRepository jpaAutoDebitInfoRepository;

  @BeforeEach
  public void setUp() {
    cardNumberValidator = new CardNumberValidator();
    jpaAutoDebitInfoRepository = new MemoryAutoDebitInfoRepository();
    autoDebitRegister = new AutoDebitRegister(cardNumberValidator,
        jpaAutoDebitInfoRepository);
  }

  @Test
  public void validCard() {
    AutoDebitReq req = new AutoDebitReq("user1", "123412341234");
    RegisterResult result = autoDebitRegister.register(req);
    assertThat(result.getValidity()).isEqualTo(CardValidity.VALID);
  }

}