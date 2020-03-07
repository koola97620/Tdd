package me.jdragon.tdd.chapter07_2;

/**
 * @author choijaeyong on 2020/03/07.
 * @project tdd
 * @description
 */
public class UserRegister {

  private WeakPasswordChecker passwordChecker;
  private UserRepository repository;

  public UserRegister(WeakPasswordChecker passwordChecker,
      UserRepository repository, SpyEmailNotifier spyEmailNotifer) {
    this.passwordChecker = passwordChecker;
    this.repository = repository;
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
  }
}
