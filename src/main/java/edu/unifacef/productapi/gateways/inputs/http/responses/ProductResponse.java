package edu.unifacef.productapi.gateways.inputs.http.responses;

import static java.util.stream.Collectors.toList;
import static org.apache.commons.collections4.CollectionUtils.emptyIfNull;

import edu.unifacef.productapi.domains.Product;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;

@Data
public class ProductResponse implements Serializable {

  private static final long serialVersionUID = 9189520552888285200L;

  @ApiModelProperty(position = 0)
  private String code;

  @ApiModelProperty(position = 1)
  private String name;

  @ApiModelProperty(position = 2)
  private String description;

  @ApiModelProperty(position = 3)
  private String brand;

  @ApiModelProperty(position = 4)
  private List<String> images;

  @ApiModelProperty(position = 5)
  private List<AttributeResponse> attributes;

  @ApiModelProperty(position = 6)
  private LocalDateTime createdDate;

  @ApiModelProperty(position = 7)
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
