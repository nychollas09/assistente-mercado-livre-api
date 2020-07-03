package br.com.assistentemercadolivre.api.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import br.com.assistentemercadolivre.api.service.AddressService;
import br.com.assistentemercadolivre.api.service.request.RequestComponent;

@Service
public class AddressSerrviceImpl implements AddressService {

  private static final String COMPLEMENT_URL = "/addresses?access_token=";

  private RestTemplate restTemplate;
  private RequestComponent requestComponent;
  private String baseUrl;

  public AddressSerrviceImpl(RestTemplate restTemplate, RequestComponent requestComponent,
      @Value("${api.mercadolivre.users}") String baseUrl) {
    this.restTemplate = restTemplate;
    this.requestComponent = requestComponent;
    this.baseUrl = baseUrl;
  }

  @Override
  public Object find(String clientId, String accessToken) {
    String uri = new StringBuilder(baseUrl).append(clientId).append(COMPLEMENT_URL)
        .append(accessToken).toString();
    return requestComponent.send(restTemplate, uri, HttpMethod.GET);
  }
}
