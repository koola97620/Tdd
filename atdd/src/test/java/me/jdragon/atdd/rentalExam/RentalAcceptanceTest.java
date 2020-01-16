package me.jdragon.atdd.rentalExam;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
public class RentalAcceptanceTest {
    public static final String LOCATION = "Location";

    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void createRental() {
        String inputJson = "{\"dateTime\":\"" + "2019120112" + "\", " +
                "\"itemId\":\"" + "110920" + "\", " +
                "\"itemType\":\"" + "14" + "\"}";

        this.webTestClient.post().uri("/rentals")
                .contentType(MediaType.APPLICATION_JSON) // 요청으로 보내는 데이터 유형 명시
                .accept(MediaType.APPLICATION_JSON) // 응답으로 받고 싶은 데이터 유형 명시
                .body(Mono.just(inputJson), String.class)
                .exchange()
                .expectStatus().isCreated()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectHeader().valueMatches(LOCATION, "\\/rentals\\/\\d")
                .expectBody()
                .jsonPath("$").isNotEmpty()
                .jsonPath("$.id").isNotEmpty()
                .jsonPath("$.status").isEqualTo("READY");
    }
}