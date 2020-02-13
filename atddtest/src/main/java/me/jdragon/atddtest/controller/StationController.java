package me.jdragon.atddtest.controller;

import java.net.URI;
import me.jdragon.atddtest.dao.StationRepository;
import me.jdragon.atddtest.domain.Station;
import me.jdragon.atddtest.dto.CreateStationRequestView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author choijaeyong on 2020/02/13.
 * @project atddtest
 * @description
 */
@RestController
public class StationController {
  private final StationRepository stationRepository;

  public StationController(StationRepository stationRepository) {
    this.stationRepository = stationRepository;
  }

  @PostMapping("/stations")
  public ResponseEntity<Station> createStation(@RequestBody CreateStationRequestView view) {
    Station station = view.toStation();
    Station persistStation = stationRepository.save(station);

    return ResponseEntity
        .created(URI.create("/stations/" + persistStation.getId()))
        .body(persistStation);

  }
}
