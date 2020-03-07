package me.jdragon.tdd.chapter07_2;

/**
 * @author choijaeyong on 2020/03/07.
 * @project tdd
 * @description
 */
public interface UserRepository {
  void save(User user);

  User findById(String id);
}
