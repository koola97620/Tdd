package me.jdragon.atddsubway.presentation;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Objects;
import javax.print.attribute.standard.Media;
import me.jdragon.atddsubway.domain.CreateMemberRequestDTO;
import me.jdragon.atddsubway.domain.CreateMemberResponseDTO;
import me.jdragon.atddsubway.domain.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.web.reactive.server.EntityExchangeResult;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

/**
 * @author choijaeyong on 2020/02/17.
 * @project atddsubway
 * @description
 */

@DisplayName("회원 정보 관리")
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
public class MemberAcceptanceTest {

  @Autowired
  private WebTestClient webTestClient;

  @DisplayName("회원 가입")
  @Test
  public void register_member() {
    Member member = new Member("email1@gmail.com","name1","pw1");
    CreateMemberRequestDTO createMemberRequestDTO = new CreateMemberRequestDTO("email1@gmail.com","name1", "pw1");

    EntityExchangeResult<CreateMemberResponseDTO> requestResult = webTestClient
        .post().uri("/members")
        .contentType(MediaType.APPLICATION_JSON)
        .body(Mono.just(createMemberRequestDTO), CreateMemberRequestDTO.class)
        .exchange()
        .expectStatus().isCreated()
        .expectHeader().contentType(MediaType.APPLICATION_JSON)
        .expectBody(CreateMemberResponseDTO.class)
        .returnResult();

    Long id = Objects.requireNonNull(requestResult.getResponseBody()).getId();

    EntityExchangeResult<CreateMemberResponseDTO> responseResult = webTestClient.get()
        .uri("/members/" + id)
        .accept(MediaType.APPLICATION_JSON)
        .exchange()
        .expectStatus().isOk()
        .expectHeader().contentType(MediaType.APPLICATION_JSON)
        .expectBody(CreateMemberResponseDTO.class).returnResult();

    assertThat(responseResult.getResponseBody().getId()).isEqualTo(requestResult.getResponseBody().getId());
    assertThat(responseResult.getResponseBody().getEmail()).isEqualTo(requestResult.getResponseBody().getEmail());
    assertThat(responseResult.getResponseBody().getName()).isEqualTo(requestResult.getResponseBody().getName());
  }

  @DisplayName("회원 탈퇴")
  @Test
  public void drop_member() {

  }

}
