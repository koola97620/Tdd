package me.jdragon.atddtest.chapter01;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import me.jdragon.atddtest.controller.StationController;
import me.jdragon.atddtest.dao.StationRepository;
import me.jdragon.atddtest.domain.Station;
import me.jdragon.atddtest.service.StationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
public class StationAcceptanceTest {
  @Autowired
  private WebTestClient webTestClient;

  @Autowired
  private ObjectMapper objectMapper;

  @DisplayName("지하철역 등록")
  @Test
  public void createStation() {
    String stationName = "강남역";
    String inputJson = "{\"name\":\""+ stationName + "\"}";

    webTestClient.post().uri("/create-station")
        .contentType(MediaType.APPLICATION_JSON)
        .body(Mono.just(inputJson), String.class)
        .exchange()
        .expectStatus().isCreated()
        .expectHeader().contentType(MediaType.APPLICATION_JSON)
        .expectHeader().exists("Location")
        .expectBody().jsonPath("$.name").isEqualTo(stationName);

//    webTestClient.get().uri("/")
//        .exchange()
//        .expectStatus().isOk()
//        .expectBody(String.class).isEqualTo("Hello world");
  }

  @DisplayName("지하철역 목록 조회")
  @Test
  public void getStations() throws Exception {
    List<Station> stations = Arrays.asList(new Station("강남역"), new Station("역삼역"));
    String s = objectMapper.writeValueAsString(stations);

    //when(stationService.getStations()).thenReturn(stations);

    webTestClient.get().uri("/stations")
        .accept(MediaType.APPLICATION_JSON)
        .exchange()
        .expectStatus().isOk()
        .expectHeader().contentType(MediaType.APPLICATION_JSON)
        //.expectBodyList(Station.class).isEqualTo(stations);
        .expectBody().json(s);


  }

  @DisplayName("지하철역 정보 조회")
  @Test
  public void getStation() {

  }

  @DisplayName("지하철역 삭제")
  @Test
  public void deleteStation() {

  }

}
