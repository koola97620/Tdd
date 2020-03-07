package me.jdragon.tdd.chapter10;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import me.jdragon.tdd.chapter07_2.UserGivenHelper;
import me.jdragon.tdd.chapter07_2.user.DupIdException;
import me.jdragon.tdd.chapter07_2.user.UserRegister;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

/**
 * @author choijaeyong on 2020/03/07.
 * @project tdd
 * @description
 */

@JdbcTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MemberDaoJdbcTest {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  private MemberDao memberDao;

  @BeforeEach
  public void setUp() {

  }


}
