package br.com.assistentemercadolivre.api.service.product;

public interface CategoriesService {
  Object findAll();

  Object findById(String categoryId);
}
