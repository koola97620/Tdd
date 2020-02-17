package me.jdragon.atddtest.chapter01.dto;

import me.jdragon.atddtest.chapter01.domain.Station;

/**
 * @author choijaeyong on 2020/02/13.
 * @project atddtest
 * @description
 */
public class CreateStationRequestView {

  public Station toStation() {
    return new Station("강남역");
  }
}
