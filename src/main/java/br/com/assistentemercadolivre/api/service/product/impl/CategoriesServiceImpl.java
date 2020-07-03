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
  private String urlSearchAll;
  private String urlSearchId;

  public CategoriesServiceImpl(RestTemplate restTemplate, RequestComponent requestComponent,
      @Value("${api.mercadolivre.categories}") String urlSearchAll,
      @Value("${api.mercadolivre.categories.id}") String urlSearchId) {
    this.restTemplate = restTemplate;
    this.requestComponent = requestComponent;
    this.urlSearchAll = urlSearchAll;
    this.urlSearchId = urlSearchId;
  }

  @Override
  public Object findAll() {
    return requestComponent.send(restTemplate, urlSearchAll, HttpMethod.GET);
  }

  @Override
  public Object findById(String categoryId) {
    String uri = new StringBuilder(urlSearchId).append(categoryId).toString();
    return requestComponent.send(restTemplate, uri, HttpMethod.GET);
  }

}
