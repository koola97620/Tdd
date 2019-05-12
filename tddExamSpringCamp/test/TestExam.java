//import static java.util.Objects.requireNonNull;
//import static org.hamcrest.core.IsInstanceOf.instanceOf;
//import static org.junit.Assert.assertThat;
//
//import java.util.ArrayList;
//import java.util.List;
//import org.junit.Before;
//import org.junit.Test;
//
///**
// * @author choijaeyong on 07/05/2019.
// * @project tddExamSpringCamp
// * @description
// */
//public class TestExam {
//
//
//  private AuthService authService;
//
//  private class AuthService {
//
//    public void authenticate(String id, String password) {
//      if(id==null || id.isEmpty()) throw new IllegalArgumentException();
//    }
//  }
//
//  @Before
//  public void setup() {
//    authService = new AuthService();
//  }
//
//  @Test
//  public void givenInvalidId_throwIllegalArgEX() {
//    Exception thrownEx = null;
//
//    try {
//      authService.authenticate(null, "userPassword");
//    } catch (Exception e) {
//      thrownEx =e;
//    }
//    assertThat(thrownEx, instanceOf(IllegalArgumentException.class));
//
//
//    Exception thrownEx2 = null;
//
//    try {
//      authService.authenticate("", "userPassword");
//    } catch (Exception e) {
//      thrownEx2 =e;
//    }
//    assertThat(thrownEx2, instanceOf(IllegalArgumentException.class));
//
//  }
//
//
//
//}