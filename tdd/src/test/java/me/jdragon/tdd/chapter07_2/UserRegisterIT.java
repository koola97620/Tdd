package me.jdragon.tdd.chapter07_2;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import me.jdragon.tdd.chapter07_2.user.DupIdException;
import me.jdragon.tdd.chapter07_2.user.UserRegister;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.test.context.jdbc.Sql;

/**
 * @author choijaeyong on 2020/03/07.
 * @project tdd
 * @description
 */

@SpringBootTest
@Sql("classpath:init-data.sql")
public class UserRegisterIT {

  @Autowired
  private UserRegister register;

  @Autowired
  private JdbcTemplate jdbcTemplate;
  private UserGivenHelper given;

  @BeforeEach
  public void setUp() {
    given = new UserGivenHelper(jdbcTemplate);
  }

  @DisplayName("동일ID가 존재하면 익셉션")
  @Test
  public void already_id_then_throw_exception() {
    // 상황
//    jdbcTemplate.update(
//        "insert into user values (?,?,?) " +
//            "on duplicate key update password = ?, email = ?",
//        "cbk", "pw", "cbk@cbk.com", "pw", "cbk@cbk.com");

    given.givenUser("cbk","pw","cbk@cbk.com");

    // 실행, 결과 확인
    assertThatExceptionOfType(DupIdException.class).isThrownBy(
        () -> register.register("cbk","strongpw","email@email.com")
    );
  }

  @DisplayName("존재하지 않으면 저장함")
  @Test
  public void not_exists_user_then_save() {
    // 상황
    jdbcTemplate.update("delete from user where id = ?", "cbk");

    // 실행
    register.register("cbk","strongpw","koola976@gmail.com");

    // 결과 확인
    SqlRowSet rs = jdbcTemplate.queryForRowSet("select * from user where id=?", "cbk");
    rs.next();
    assertThat(rs.getString("email")).isEqualTo("koola976@gmail.com");

  }

}
