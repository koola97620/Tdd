package chapter7;

/**
 * @author choijaeyong on 2020/04/08.
 * @project tdd2
 * @description
 */
public interface UserRepository {

  void save(User user);

  User findById(String id);
}
