package me.jdragon.tdd.chapter07_2.user;


import org.springframework.data.repository.Repository;

/**
 * @author choijaeyong on 2020/03/07.
 * @project tdd
 * @description
 */
public interface UserRepository extends Repository<User,String> {
  void save(User user);

  User findById(String id);
}
