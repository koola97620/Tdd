package me.jdragon.atddtest.chapter01.service;

import java.util.List;
import me.jdragon.atddtest.chapter01.dao.StationRepository;
import me.jdragon.atddtest.chapter01.domain.Station;
import org.springframework.stereotype.Service;

/**
 * @author choijaeyong on 2020/02/14.
 * @project atddtest
 * @description
 */
@Service
public class StationService {

  private StationRepository stationRepository;

  public StationService(StationRepository stationRepository) {
    this.stationRepository = stationRepository;
  }

  public List<Station> getStations() {
    return stationRepository.findAll();
  }
}
