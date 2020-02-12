package me.jdragon.atddtest.chapter01;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.reactive.server.WebTestClient;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
public class StationAcceptanceTest {
  @Autowired
  private WebTestClient webTestClient;

  @Test
  public void createStation() {
    webTestClient.get().uri("/")
        .exchange()
        .expectStatus().isOk()
        .expectBody(String.class).isEqualTo("Hello world");


  }


}
