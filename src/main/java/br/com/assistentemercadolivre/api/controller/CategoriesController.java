package br.com.assistentemercadolivre.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.assistentemercadolivre.api.service.product.CategoriesService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/")
public class CategoriesController {

  @Autowired
  private CategoriesService service;

  @GetMapping("find")
  public ResponseEntity<Object> findAll() {
    return ResponseEntity.ok(service.findAll());
  }

  @GetMapping("find/{id}")
  public ResponseEntity<Object> findById(@PathVariable(name = "id") String id) {
    return ResponseEntity.ok(service.findById(id));
  }

}
