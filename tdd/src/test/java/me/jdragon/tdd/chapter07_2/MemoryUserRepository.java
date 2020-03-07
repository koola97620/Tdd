package me.jdragon.tdd.chapter07_2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author choijaeyong on 2020/03/07.
 * @project tdd
 * @description
 */
public class MemoryUserRepository implements UserRepository{
  private Map<String, User> users = new HashMap<>();

  @Override
  public void save(User user) {
    users.put(user.getId(), user);
  }

  @Override
  public User findById(String id) {
    return users.get(id);
  }
}
