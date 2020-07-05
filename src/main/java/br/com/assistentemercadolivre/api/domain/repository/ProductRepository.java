package br.com.assistentemercadolivre.api.domain.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.assistentemercadolivre.api.domain.model.Product;

public interface ProductRepository extends JpaRepository<Product, UUID> {

}
