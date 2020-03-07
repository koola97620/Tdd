package me.jdragon.tdd.chapter07_2.user;

import me.jdragon.tdd.chapter07_2.user.RegisterReq;

/**
 * @author choijaeyong on 2020/03/07.
 * @project tdd
 * @description
 */
public class UserRegisterService {


  public void register(RegisterReq req) {
    throw new DupIdException();
  }
}
