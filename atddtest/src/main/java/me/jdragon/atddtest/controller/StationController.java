package me.jdragon.atddtest.controller;

import com.sun.tools.internal.ws.wsdl.framework.NoSuchEntityException;
import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityNotFoundException;
import me.jdragon.atddtest.dao.StationRepository;
import me.jdragon.atddtest.domain.Station;
import me.jdragon.atddtest.dto.ApiResponseMessage;
import me.jdragon.atddtest.dto.CreateStationRequestView;
import me.jdragon.atddtest.service.StationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author choijaeyong on 2020/02/13.
 * @project atddtest
 * @description
 */
@RestController
public class StationController {
  private final StationRepository stationRepository;
  private StationService stationService;

  public StationController(StationRepository stationRepository, StationService stationService) {
    this.stationRepository = stationRepository;
    this.stationService = stationService;
  }

  @PostMapping("/stations")
  public ResponseEntity<Station> createStation(@RequestBody CreateStationRequestView view) {
    Station station = view.toStation();
    Station persistStation = stationRepository.save(station);

    return ResponseEntity
        .created(URI.create("/stations/" + persistStation.getId()))
        .body(persistStation);
  }

  @GetMapping("/stations")
  public ResponseEntity<List<Station>> getStations() {
    //List<Station> stations = stationService.getStations();
    List<Station> stations = Arrays.asList(new Station("강남역"), new Station("역삼역"));
    return new ResponseEntity<>(stations, HttpStatus.OK);
  }

  @GetMapping("/station")
  public ResponseEntity<Station> getStation(@RequestParam("name") String name) {
    return ResponseEntity.ok(stationRepository.findByName(name).orElseThrow( () -> new IllegalArgumentException("no subway")));
  }

  @DeleteMapping("/station")
  public ResponseEntity<Station> deleteByName(@RequestParam("name") String name) {
    Station station = stationRepository.findByName(name).orElseThrow( () -> new EntityNotFoundException());
    stationRepository.deleteByName(station.getName());

    return ResponseEntity.ok()
        .contentType(MediaType.APPLICATION_JSON)
        .body(station);
  }

}
