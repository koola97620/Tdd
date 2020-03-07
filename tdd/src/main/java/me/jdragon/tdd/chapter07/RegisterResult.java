package me.jdragon.tdd.chapter07;

/**
 * @author choijaeyong on 2020/03/07.
 * @project tdd
 * @description
 */
public class RegisterResult {

  public static RegisterResult error(CardValidity validity) {
    return null;
  }

  public static RegisterResult success() {

    return null;
  }

  public CardValidity getValidity() {
    return CardValidity.VALID;
  }
}
