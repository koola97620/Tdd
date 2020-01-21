package me.jdragon.junitinaction.chapter03;

/**
 * @author choijaeyong on 2020/01/21.
 * @project junitinaction
 * @description
 */
public class ErrorResponse implements Response {

  private Request originalRequest;
  private Exception originalException;

  public ErrorResponse(Request request, Exception e) {
    this.originalRequest = request;
    this.originalException = e;
  }

  public Request getOriginalRequest() {
    return this.originalRequest;
  }

  public Exception getOriginalException() {
    return this.originalException;
  }
}
