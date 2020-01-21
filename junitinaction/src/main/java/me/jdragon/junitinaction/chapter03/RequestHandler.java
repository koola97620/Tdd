package me.jdragon.junitinaction.chapter03;

/**
 * @author choijaeyong on 2020/01/21.
 * @project junitinaction
 * @description
 */
public interface RequestHandler {
  Response process(Request reuqest) throws Exception;
}
