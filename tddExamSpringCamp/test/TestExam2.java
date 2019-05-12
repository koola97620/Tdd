
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

/**
 * @author choijaeyong on 12/05/2019.
 * @project tddExamSpringCamp
 * @description
 *
 * 다시 처음부터 따라해보자.
 */
public class TestExam2 {

  public static final String USER_ID = "userId";
  public static final String WRONG_PASSWORD_ = "wrongPassword ";
  private final String USER_PASSWORD = "USER_PASSWORD";
  private AuthService authService;
  private String NO_USER_ID="noUserId";
  private UserRepository mockUserRepository;

  @Before
  public void setup() {
    authService = new AuthService();
    mockUserRepository = mock(UserRepository.class);
    authService.setUserRepository(mockUserRepository);
  }

  @Test
  public void givenInvalidId_throwIllegalArgEx() {
    assertIllegalArgExThrown(null, USER_PASSWORD);
    assertIllegalArgExThrown("", USER_PASSWORD);
    assertIllegalArgExThrown(USER_ID, null);
    assertIllegalArgExThrown(USER_ID, "");

  }


  private void assertIllegalArgExThrown(String id, String password) {
    assertExceptionThrown(id, password, IllegalArgumentException.class);
  }

  private void assertExceptionThrown(String id, String password, Class<? extends Exception> type) {
    Exception thrownEx = null;
    try {
      authService.authenticate(id, password);
    } catch (Exception e) {
      thrownEx = e;
    }
    assertThat(thrownEx, instanceOf(type));
  }


  private class AuthService {
    private UserRepository userRepository;

    public void setUserRepository(UserRepository userRepository) {
      this.userRepository = userRepository;
    }

    public Authentication authenticate(String id, String password) {
      if(id == null || id=="") throw new IllegalArgumentException();
      if(password == null || password =="") throw new IllegalArgumentException();

      User user = findUserById(id);
      if(user == null)
        throw new NonExistingUserException();

      throwExIfPasswordIsWrong(user);

      return new Authentication(user.getId());

    }

    private void throwExIfPasswordIsWrong(User user) {
      if(!user.getId().equals(USER_ID))
        throw new WrongPasswordException();
    }


    private User findUserById(String id) {
      return userRepository.findById(id);
//      if(id.equals("userId"))
//        return new User(id,"1234");
//      return null;
    }
  }



  @Test
  public void whenUserNotFound_throwNonExistUserEx() {
    assertExceptionThrown(NO_USER_ID, USER_PASSWORD, NonExistingUserException.class);
    for(int i=1 ; i <= 10 ; i++) {
      assertExceptionThrown(NO_USER_ID +i, USER_PASSWORD, NonExistingUserException.class);
    }

  }

  private class NonExistingUserException extends RuntimeException {

  }

  private class User {
    String id;

    public User(String id, String password) {

    }

    public String getId() {
      return id;
    }
  }


  @Test
  public void whenUserFoundButWrongPw_throwWrongPasswordEx() {
    givenUserExists(USER_ID,USER_PASSWORD);
    assertExceptionThrown(USER_ID, WRONG_PASSWORD_, WrongPasswordException.class);
    verifyUserFound(USER_ID);
  }

  private void givenUserExists(String id, String password) {
    when(mockUserRepository.findById(id)).thenReturn(new User(id,password));
  }

  private void verifyUserFound(String id) {
    verify(mockUserRepository).findById(id);
  }

  private class WrongPasswordException extends RuntimeException {

  }

  private interface UserRepository {
    User findById(String id);

  }


  @Test
  public void whenUserFoundAndRightPw_returnAuth() {
    givenUserExists(USER_ID,USER_PASSWORD);
    Authentication auth = authService.authenticate(USER_ID,USER_PASSWORD);
    assertThat(auth.getId() , equalTo(USER_ID));
  }

  private class Authentication {
    String id;

    public Authentication(String id) {

    }

    String getId() {
      return id;
    }

  }
}


/*
삼각측량?  (17분쯤?)
같은 테스트를 또 넣는다.

assertExceptionThrown("noUserId", USER_PASSWORD, NonExistingUserException.class);
assertExceptionThrown("noUserId"+"2", USER_PASSWORD, NonExistingUserException.class);

뭔가? 특정한 상황에서 범용적인 상황으로 넘어가야 되는 경우를
삼각측량 테스트 방법. 여러가지 테스트를 이용해서 만들고
그거를 통과시키도록 노력합니다.



 */