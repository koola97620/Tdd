package me.jdragon.tdd.chapter07_2.user;

import org.springframework.stereotype.Service;

/**
 * @author choijaeyong on 2020/03/07.
 * @project tdd
 * @description
 */

@Service
public class UserRegister {

  private WeakPasswordChecker passwordChecker;
  private UserRepository repository;
  private EmailNotifier emailNotifer;

  public UserRegister(WeakPasswordChecker passwordChecker,
      UserRepository repository, EmailNotifier emailNotifer) {
    this.passwordChecker = passwordChecker;
    this.repository = repository;
    this.emailNotifer = emailNotifer;
  }

  public void register(String id, String pw, String email) {
    if (passwordChecker.checkPasswordWeak(pw)) {
      throw new WeakPasswordException();
    }
    User user = repository.findById(id);
    if (user != null) {
      throw new DupIdException();
    }

    repository.save(new User(id,pw,email));

    emailNotifer.sendRegisterEmail(email);
  }
}
