package me.jdragon.tdd.chapter07;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;
import static org.assertj.core.api.Assertions.assertThat;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author choijaeyong on 2020/03/07.
 * @project tdd
 * @description
 */
public class CardNumberValidatorTest {

  private WireMockServer wireMockServer;

  @BeforeEach
  public void setUp() {
    wireMockServer = new WireMockServer(options().port(8089));
    wireMockServer.start();
  }

  @AfterEach
  public void tearDown() {
    wireMockServer.stop();
  }

  @Test
  public void valid() {
    wireMockServer.stubFor(post(urlEqualTo("/card"))
        .withRequestBody(equalTo("1234567"))
        .willReturn(aResponse()
            .withHeader("ContentType", "text/plain")
            .withBody("ok"))
    );

    CardNumberValidator validator = new CardNumberValidator("http://localhost:8089");
    CardValidity validity = validator.validate("1234567");
    assertThat(validity).isEqualTo(CardValidity.VALID);
  }

  @Test
  public void timeout() {
    wireMockServer.stubFor(post(urlEqualTo("/card"))
        .willReturn(aResponse()
          .withFixedDelay(5000)));

    CardNumberValidator validator = new CardNumberValidator("http://localhost:8089");
    CardValidity validity = validator.validate("1234567");
    assertThat(validity).isEqualTo(CardValidity.TIMEOUT);
  }

}
