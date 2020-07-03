package br.com.assistentemercadolivre.api.service.request;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RequestComponent {

  public Object send(RestTemplate restTemplate, String uri, HttpEntity<Object> entity) {
    return restTemplate.exchange(uri, HttpMethod.POST, entity, Object.class).getBody();
  }

}
