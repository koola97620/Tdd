package me.jdragon.tdd.chapter07;

/**
 * @author choijaeyong on 2020/03/07.
 * @project tdd
 * @description
 */
public class StubCardNumberValidator extends CardNumberValidator {
  private String invalidNo;
  public void setInvalidNo(String invalidNo) {
    this.invalidNo = invalidNo;
  }
  @Override
  public CardValidity validate(String cardNumber) {
    if(invalidNo != null && invalidNo.equals(cardNumber)) {
      return CardValidity.INVALID;
    }
    return CardValidity.VALID;
  }

}
