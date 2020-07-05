package br.com.assistentemercadolivre.api.service.product.impl;

import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import br.com.assistentemercadolivre.api.domain.model.Product;
import br.com.assistentemercadolivre.api.domain.repository.ProductRepository;
import br.com.assistentemercadolivre.api.service.product.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

  private ProductRepository repository;
  private static ObjectMapper objectMapper = new ObjectMapper();

  public ProductServiceImpl(ProductRepository repository) {
    this.repository = repository;
  }

  @Override
  public Object find() {
    Product jsonProduct = repository.findAll().get(0);
    return jsonProduct.getProducts();
  }

  @Override
  public Object create(Object product) {
    JsonNode products = objectMapper.convertValue(product, JsonNode.class);
    return repository.save(new Product(products));
  }

}
