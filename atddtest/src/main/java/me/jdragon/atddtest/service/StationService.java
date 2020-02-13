package me.jdragon.atddtest.service;

import java.util.List;
import me.jdragon.atddtest.dao.StationRepository;
import me.jdragon.atddtest.domain.Station;
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
