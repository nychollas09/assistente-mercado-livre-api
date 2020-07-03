package br.com.assistentemercadolivre.api.service.product.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import br.com.assistentemercadolivre.api.service.product.CategoriesService;
import br.com.assistentemercadolivre.api.service.request.RequestComponent;

@Service
public class CategoriesServiceImpl implements CategoriesService {

  private RestTemplate restTemplate;
  private RequestComponent requestComponent;
  private String baseUrl;

  public CategoriesServiceImpl(RestTemplate restTemplate, RequestComponent requestComponent,
      @Value("${api.mercadolivre.categories}") String baseUrl) {
    this.restTemplate = restTemplate;
    this.requestComponent = requestComponent;
    this.baseUrl = baseUrl;
  }

  @Override
  public Object findAll() {
    return requestComponent.send(restTemplate, baseUrl, HttpMethod.GET);
  }

}
