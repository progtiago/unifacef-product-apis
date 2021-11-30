package edu.unifacef.productapi.gateways.inputs.http.responses;

import static java.util.stream.Collectors.toList;
import static org.apache.commons.collections4.CollectionUtils.emptyIfNull;

import edu.unifacef.productapi.domains.Product;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;

@Data
public class ProductResponse implements Serializable {

  private static final long serialVersionUID = 9189520552888285200L;

  private String code;
  private String name;
  private String description;
  private String brand;
  private List<String> images;
  private List<AttributeResponse> attributes;
  private LocalDateTime createdDate;
  private LocalDateTime lastModifiedDate;

  public ProductResponse(final Product product) {
    this.code = product.getCode();
    this.name = product.getName();
    this.description = product.getDescription();
    this.brand = product.getBrand();
    this.images = product.getImages();
    this.attributes = emptyIfNull(product.getAttributes())
        .stream().map(AttributeResponse::new).collect(toList());
    this.createdDate = product.getCreatedDate();
    this.lastModifiedDate = product.getLastModifiedDate();
  }

}
