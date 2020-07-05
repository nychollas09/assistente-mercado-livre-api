package br.com.assistentemercadolivre.api.domain.model;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import com.fasterxml.jackson.databind.JsonNode;
import com.vladmihalcea.hibernate.type.json.JsonNodeBinaryType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "products")
@TypeDef(name = "jsonb", typeClass = JsonNodeBinaryType.class)
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;

  @Type(type = "jsonb")
  @Column(columnDefinition = "json")
  private JsonNode products;

  @SuppressWarnings("unused")
  private Product() {}

  public Product(JsonNode products) {
    this.products = products;
  }
}
