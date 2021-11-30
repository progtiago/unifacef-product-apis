package edu.unifacef.productapi.domains;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Product {

  private String code;
  private String name;
  private String description;
  private String brand;
  private List<String> images;
  private List<Attribute> attributes;
  private LocalDateTime createdDate;
  private LocalDateTime lastModifiedDate;

}
