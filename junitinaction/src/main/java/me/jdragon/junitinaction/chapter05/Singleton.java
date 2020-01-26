package me.jdragon.junitinaction.chapter05;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Single;

/**
 * @author choijaeyong on 2020/01/26.
 * @project junitinaction
 * @description
 */
public class Singleton {
//  private Singleton() {}
//  public static final Singleton INSTANCE = new Singleton();

  private static Singleton INSTANCE;
  private Singleton() {}
  public static Singleton getInstance() {
    if(INSTANCE == null) {
      INSTANCE = new Singleton();
    }
    return INSTANCE;
  }
}
