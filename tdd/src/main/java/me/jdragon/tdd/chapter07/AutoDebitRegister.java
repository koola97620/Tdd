package me.jdragon.tdd.chapter07;

import java.time.LocalDateTime;

/**
 * @author choijaeyong on 2020/03/07.
 * @project tdd
 * @description
 */
public class AutoDebitRegister {

  private final CardNumberValidator validator;
  private final AutoDebitInfoRepository repository;

  public AutoDebitRegister(CardNumberValidator validator, AutoDebitInfoRepository repository) {

    this.validator = validator;
    this.repository = repository;
  }

  public RegisterResult register(AutoDebitReq req) {
    CardValidity validity = validator.validate(req.getCardNumber());
    if (validity != CardValidity.VALID) {
      return RegisterResult.error(validity);
    }
    AutoDebitInfo info =  repository.findOne(req.getUserId());
    if (info != null) {
      info.changeCardNumber(req.getUserId(), req.getCardNumber(), LocalDateTime.now());
    } else {
      AutoDebitInfo newInfo = new AutoDebitInfo(req.getUserId(), req.getCardNumber(),
          LocalDateTime.now());
      repository.save(newInfo);
    }
    return RegisterResult.success();
  }

}
