package me.jdragon.atddtest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author choijaeyong on 2020/02/12.
 * @project atddtest
 * @description
 */
@RestController
public class DefaultController {

  @GetMapping("/")
  public String defaultHandler() {
    return "Hello world";
  }

}
