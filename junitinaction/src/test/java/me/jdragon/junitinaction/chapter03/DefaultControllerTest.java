package me.jdragon.junitinaction.chapter03;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

/**
 * @author choijaeyong on 2020/01/21.
 * @project junitinaction
 * @description
 */
class DefaultControllerTest {
  private DefaultController controller;
  private Request request;
  private RequestHandler handler;

  @BeforeEach
  public void instantiate() throws Exception {
    controller = new DefaultController();
    request = new SampleRequest();
    handler = new SampleHandler();
    controller.addHandler(request, handler);
  }

  @Test
  public void testMethod() {
    throw new RuntimeException("implement me");
  }

  @Test
  public void testAddHandler() {
    RequestHandler handler2 = controller.getHandler(request);
    assertThat(handler2).isEqualTo(handler);
  }

  @Test
  public void testProcessRequest() {
    Response response = controller.processRequest(request);
    assertThat(response).isNotNull();
    assertThat(response).isExactlyInstanceOf(SampleResponse.class);
  }

  @Test
  public void testProcessRequestAnswersErrorResponse() {
    SampleRequest request = new SampleRequest("testError");
    SampleExceptionHandler handler = new SampleExceptionHandler();
    controller.addHandler(request,handler);
    Response response = controller.processRequest(request);
    assertThat(response).isExactlyInstanceOf(ErrorResponse.class);
  }

  @Test
  public void testGetHandlerNotDefined() {
    SampleRequest request = new SampleRequest("testNotDefined");
    assertThatExceptionOfType(RuntimeException.class).isThrownBy( () -> controller.getHandler(request));
  }

  @Test
  public void testAddRequestDuplicateName() {
    SampleRequest request = new SampleRequest();
    SampleHandler handler = new SampleHandler();
    assertThatExceptionOfType(RuntimeException.class).isThrownBy( () -> controller.addHandler(request,handler));
  }

  @Test
  @Disabled(value = "Disable for now until we decide a decent time-limit")
  //@Timeout(value = 130, unit = TimeUnit.MILLISECONDS)
  public void testProcessMultipleRequestsTimeout() {
    Request request;
    Response response;
    SampleHandler handler = new SampleHandler();
    for(int i=0; i < 99999 ; i++) {
      request = new SampleRequest(String.valueOf(i));
      controller.addHandler(request,handler);
      response = controller.processRequest(request);
      assertThat(response).isNotNull();
      assertThat(response).isNotInstanceOf(ErrorResponse.class);
    }
  }

  private static class SampleRequest implements Request {
    private static final String DEFAULT_NAME = "Test";
    private String name;

    public SampleRequest(String name) {
      this.name = name;
    }

    public SampleRequest() {
      this(DEFAULT_NAME);
    }

    public String getName() {
      return this.name;
    }
  }

  private static class SampleHandler implements RequestHandler {

    @Override
    public Response process(Request reuqest) throws Exception {
      return new SampleResponse();
    }
  }

  private static class SampleResponse implements Response {
    private static final String NAME = "Test";
    public String getName() {
      return NAME;
    }
    public boolean equals(Object object) {
      boolean result = false;
      if (object instanceof SampleResponse) {
        result = ((SampleResponse)object).getName().equals(getName());
      }
      return result;
    }
    public int hashCode() {
      return NAME.hashCode();
    }
  }

  private static class SampleExceptionHandler implements RequestHandler {
    public Response process(Request request) throws Exception {
      throw new Exception("error processing request");
    }
  }

}