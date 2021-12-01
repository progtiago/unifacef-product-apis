package edu.unifacef.productapi.gateways.outputs.http.resources;

import static java.util.stream.Collectors.toList;
import static org.apache.commons.collections4.CollectionUtils.emptyIfNull;

import edu.unifacef.productapi.domains.Product;
import java.util.List;
import lombok.Data;

@Data
public class ProductResource {

  private String name;
  private String description;
  private String brand;
  private List<String> images;
  private List<AttributeResource> attributes;

  public ProductResource(final Product product) {
    this.name = product.getName();
    this.description = product.getDescription();
    this.brand = product.getBrand();
    this.images = product.getImages();
    this.attributes = emptyIfNull(product.getAttributes())
        .stream().map(AttributeResource::new).collect(toList());
  }

}
