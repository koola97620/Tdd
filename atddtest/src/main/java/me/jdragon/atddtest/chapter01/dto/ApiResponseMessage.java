package me.jdragon.atddtest.chapter01.dto;

import lombok.Getter;

/**
 * @author choijaeyong on 2020/02/14.
 * @project atddtest
 * @description
 */
@Getter
public class ApiResponseMessage {
  private String status;
  private String message;

  public ApiResponseMessage(String status, String message) {
    this.status = status;
    this.message = message;
  }
}
