package me.jdragon.tdd.chapter07;

/**
 * @author choijaeyong on 2020/03/07.
 * @project tdd
 * @description
 */
public enum CardValidity {
  VALID(),INVALID(),EXPIRED(),THEFT(), ERROR(),UNKNOWN(),TIMEOUT();

  public CardValidity getValidity() {
    return this;
  }

}
