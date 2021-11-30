package edu.unifacef.productapi.gateways.outputs.http.resources;

import edu.unifacef.productapi.domains.Attribute;
import lombok.Data;

@Data
public class AttributeResource {

  private String key;
  private String value;

  public AttributeResource(final Attribute attribute) {
    this.key = attribute.getKey();
    this.value = attribute.getValue();
  }

}
