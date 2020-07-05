package br.com.assistentemercadolivre.api.service.user.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import br.com.assistentemercadolivre.api.service.request.RequestComponent;
import br.com.assistentemercadolivre.api.service.user.UserService;

@Service
public class UserServiceImpl implements UserService {

  private static final String ADDRESS_URL = "/addresses?access_token=";
  private static final String ME_URL = "me?access_token=";

  private RestTemplate restTemplate;
  private RequestComponent requestComponent;
  private String baseUrl;

  public UserServiceImpl(RestTemplate restTemplate, RequestComponent requestComponent,
      @Value("${api.mercadolivre.users}") String baseUrl) {
    this.restTemplate = restTemplate;
    this.requestComponent = requestComponent;
    this.baseUrl = baseUrl;
  }

  @Override
  public Object find(String clientId, String accessToken) {
    String uri = new StringBuilder(baseUrl).append(clientId).append(ADDRESS_URL).append(accessToken)
        .toString();
    return requestComponent.send(restTemplate, uri, HttpMethod.GET);
  }

  @Override
  public Object me(String accessToken) {
    String uri = new StringBuilder(baseUrl).append(ME_URL).append(accessToken).toString();
    return requestComponent.send(restTemplate, uri, HttpMethod.GET);
  }

}
