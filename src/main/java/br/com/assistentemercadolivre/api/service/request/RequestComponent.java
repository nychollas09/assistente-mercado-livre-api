package br.com.assistentemercadolivre.api.service.request;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RequestComponent {

  public Object send(RestTemplate restTemplate, String uri, HttpMethod httpMethod) {
    HttpEntity<Object> entity = new HttpEntity<>(createHttpHeaders());
    return restTemplate.exchange(uri, httpMethod, entity, Object.class).getBody();
  }

  private HttpHeaders createHttpHeaders() {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    return headers;
  }

}
