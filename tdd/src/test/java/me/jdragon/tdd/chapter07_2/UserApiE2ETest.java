package me.jdragon.tdd.chapter07_2;

import static org.assertj.core.api.Assertions.assertThat;

import java.net.URI;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;

/**
 * @author choijaeyong on 2020/03/07.
 * @project tdd
 * @description
 */
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class UserApiE2ETest {
  @Autowired
  private TestRestTemplate restTemplate;

  @Test
  public void weakPasswrodResponse() {
    String reqBody = "{\"id\": \"id\", \"pw\": \"123\", \"email\": \"a@a.com\" }";
    RequestEntity<String> request = RequestEntity.post(URI.create("/users"))
        .contentType(MediaType.APPLICATION_JSON)
        .body(reqBody);

    ResponseEntity<String> response = restTemplate.exchange(request, String.class);

    //assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    //assertThat(response.getBody().contains("WeakPasswordException")).isTrue();
    assertThat(response.getBody().contains("WeakPasswordException")).isFalse();
  }

}
