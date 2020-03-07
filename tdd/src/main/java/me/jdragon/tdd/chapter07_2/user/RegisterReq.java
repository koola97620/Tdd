package me.jdragon.tdd.chapter07_2.user;

import lombok.Builder;

/**
 * @author choijaeyong on 2020/03/07.
 * @project tdd
 * @description
 */
@Builder
public class RegisterReq {
  private String id;
  private String name;
  private String email;
  private String password;


}
