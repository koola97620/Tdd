package me.jdragon.tdd.chapter07;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

/**
 * @author choijaeyong on 2020/03/07.
 * @project tdd
 * @description
 */
public class CardNumberValidator {

  public CardValidity validate(String cardNumber) {
    HttpClient httpClient = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(""))
        .header("Content-Type", "text/plain")
        .POST(BodyPublishers.ofString(cardNumber)).build();
    try {
      HttpResponse<String> response = httpClient.send(request, BodyHandlers.ofString());
      switch (response.body()) {
        case "ok": return CardValidity.VALID;
        case "bad": return CardValidity.INVALID;
        case "expired": return CardValidity.EXPIRED;
        case "theft": return CardValidity.THEFT;
        default: return CardValidity.UNKNOWN;
      }
    } catch(IOException | InterruptedException e) {
      return CardValidity.ERROR;
    }

  }
}
