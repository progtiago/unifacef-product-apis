package edu.unifacef.productapi.gateways.outputs.mongodb.documents;

import static java.util.stream.Collectors.toList;
import static org.apache.commons.collections4.CollectionUtils.emptyIfNull;

import edu.unifacef.productapi.domains.Product;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Document("products")
public class ProductDocument {

  @Id
  private String id;
  private String name;
  private String description;
  private String brand;
  private List<String> images;
  private List<AttributeDocument> attributes;
  private LocalDateTime createdDate;
  @LastModifiedDate
  private LocalDateTime lastModifiedDate;

  public ProductDocument(final Product product) {
    this.id = product.getCode();
    this.name = product.getName();
    this.description = product.getDescription();
    this.brand = product.getBrand();
    this.images = product.getImages();
    this.attributes = emptyIfNull(product.getAttributes())
        .stream().map(AttributeDocument::new).collect(toList());
    this.createdDate = product.getCreatedDate();
    this.lastModifiedDate = product.getLastModifiedDate();
  }

  public Product toDomain() {
    return Product.builder()
        .code(this.id)
        .name(this.name)
        .description(this.description)
        .brand(this.brand)
        .images(this.images)
        .attributes(emptyIfNull(this.attributes)
            .stream().map(AttributeDocument::toDomain).collect(toList()))
        .createdDate(this.createdDate)
        .lastModifiedDate(this.lastModifiedDate)
        .build();
  }

}
