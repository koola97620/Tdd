package me.jdragon.junitinaction.chapter03;

/**
 * @author choijaeyong on 2020/01/21.
 * @project junitinaction
 * @description
 */
public interface Controller {
  Response processRequest(Request request);
  void addHandler(Request request, RequestHandler requestHandler);
}
