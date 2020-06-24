package me.jdragon.atddsubway.presentation;

import static org.junit.jupiter.api.Assertions.*;

import java.net.URI;
import me.jdragon.atddsubway.domain.CreateMemberResponseDTO;
import me.jdragon.atddsubway.domain.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.client.RestTemplate;

/**
 * @author choijaeyong on 2020/06/24.
 * @project atddsubway
 * @description
 */
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class MemberControllerTest {
//  @Autowired
//  private WebTestClient webTestClient;
//
//  @Test
//  public void test() {
//    webTestClient.get()
//        .uri("/members/test")
//        .accept(MediaType.APPLICATION_JSON)
//        .exchange()
//        .expectStatus().isOk()
//        .expectHeader().contentType(MediaType.APPLICATION_JSON);
//  }

//  @Autowired
//  private RestTemplate restTemplate;

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void test2() throws Exception {
    MvcResult mvcResult = mockMvc
        .perform(MockMvcRequestBuilders.get("/members/test").accept(MediaType.APPLICATION_JSON)
        ).andReturn();

    String contentAsString = mvcResult.getResponse().getContentAsString();
    System.out.println(contentAsString);
  }

}