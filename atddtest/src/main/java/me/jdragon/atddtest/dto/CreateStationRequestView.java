package me.jdragon.atddtest.dto;

import me.jdragon.atddtest.domain.Station;

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
