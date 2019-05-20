import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;


/**
 * @author choijaeyong on 19/05/2019.
 * @project tddExamSpringCamp
 * @description
 */


public class TestSpringCamp {

  @Test
  public void create() {
    AuthService authService = new AuthService();
    authService.authenticate();
    Exception thrownEx=null;
    assertThat(thrownEx , instanceOf(IllegalArgumentException.class));


  }

  @Test
  public void givenInvalidId_throwIllegalEx() {

  }


  private class AuthService {

    public void authenticate() {

    }
  }
}
