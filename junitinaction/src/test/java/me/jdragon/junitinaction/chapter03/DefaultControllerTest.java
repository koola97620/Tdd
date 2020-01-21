package me.jdragon.junitinaction.chapter03;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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


  private static class SampleRequest implements Request {
    public String getName() {
      return "Test";
    }
  }

  private static class SampleHandler implements RequestHandler {

    @Override
    public Response process(Request reuqest) throws Exception {
      return new SampleResponse();
    }
  }

  private static class SampleResponse implements Response {

  }
}