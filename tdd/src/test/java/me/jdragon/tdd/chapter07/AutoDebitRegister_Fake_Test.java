package me.jdragon.tdd.chapter07;

import java.time.LocalDateTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author choijaeyong on 2020/03/07.
 * @project tdd
 * @description
 */
public class AutoDebitRegister_Fake_Test {

  private StubCardNumberValidator validator;
  private MemoryAutoDebitInfoRepository memoryAutoDebitInfoRepository;
  private AutoDebitRegister autoDebitRegister;

  @BeforeEach
  public void setUp() {
    validator = new StubCardNumberValidator();
    memoryAutoDebitInfoRepository = new MemoryAutoDebitInfoRepository();
    autoDebitRegister = new AutoDebitRegister(validator, memoryAutoDebitInfoRepository);
  }

  @Test
  public void already_Registered_InfoUpdated() {
    memoryAutoDebitInfoRepository.save(new AutoDebitInfo("userId","11223344", LocalDateTime.now()));

    AutoDebitInfo saved = memoryAutoDebitInfoRepository.findOne("userId");
  }

}
