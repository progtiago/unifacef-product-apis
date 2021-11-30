package edu.unifacef.productapi.gateways.inputs.http.requests;

import static java.util.stream.Collectors.toList;
import static org.apache.commons.collections4.CollectionUtils.emptyIfNull;

import edu.unifacef.productapi.domains.Product;

public class UpdateProductRequest extends ProductRequest {

  private static final long serialVersionUID = 8743997776881612716L;

  public Product toDomain(final String code) {
    return Product.builder()
        .code(code)
        .name(super.getName())
        .description(super.getDescription())
        .brand(super.getBrand())
        .images(super.getImages())
        .attributes(emptyIfNull(super.getAttributes())
            .stream().map(AttributeRequest::toDomain).collect(toList()))
        .build();
  }

}
