package br.com.assistentemercadolivre.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.assistentemercadolivre.api.service.product.ProductService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/")
public class ProductController {

  @Autowired
  private ProductService service;

  @GetMapping("products")
  public ResponseEntity<Object> find() {
    return ResponseEntity.ok(service.find());
  }
}
