package me.jdragon.tdd.chapter10;

import java.util.Collections;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * @author choijaeyong on 2020/03/07.
 * @project tdd
 * @description
 */

@Component
public class MemberDao {
  private JdbcTemplate jdbcTemplate;

  public MemberDao(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  public List<Member> selectAll() {
    return Collections.emptyList();
  }

}
