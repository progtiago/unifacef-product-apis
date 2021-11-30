package edu.unifacef.productapi.gateways.inputs.http.requests;

import static java.util.stream.Collectors.toList;
import static org.apache.commons.collections4.CollectionUtils.emptyIfNull;

import edu.unifacef.productapi.domains.Product;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CreateProductRequest extends ProductRequest {

  private static final long serialVersionUID = 8743997776881612716L;

  @NotNull(message = "{required.field}")
  private String code;

  public Product toDomain() {
    return Product.builder()
        .code(this.code)
        .name(super.getName())
        .description(super.getDescription())
        .brand(super.getBrand())
        .images(super.getImages())
        .attributes(emptyIfNull(super.getAttributes())
            .stream().map(AttributeRequest::toDomain).collect(toList()))
        .build();
  }
}
