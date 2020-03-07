package me.jdragon.tdd.chapter07_2;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author choijaeyong on 2020/03/07.
 * @project tdd
 * @description
 */
public class UserGivenHelper {

  private JdbcTemplate jdbcTemplate;

  public UserGivenHelper(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  public void givenUser(String id, String pw, String email) {
        jdbcTemplate.update(
        "insert into user values (?,?,?) " +
            "on duplicate key update password = ?, email = ?",
        "cbk", "pw", "cbk@cbk.com", "pw", "cbk@cbk.com");
  }
}
