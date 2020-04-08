package chapter7;

import java.util.HashMap;
import java.util.Map;

/**
 * @author choijaeyong on 2020/04/08.
 * @project tdd2
 * @description
 */
public class FakeUserRepository implements UserRepository{
  Map<String,User> users = new HashMap<>();

  @Override
  public void save(User user) {
    users.put(user.getId() , user);
  }

  @Override
  public User findById(String id) {
    return users.get(id);
  }
}
