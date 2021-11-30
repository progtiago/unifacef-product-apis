package edu.unifacef.productapi.gateways.outputs.mongodb.documents;

import edu.unifacef.productapi.domains.Attribute;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AttributeDocument {

  private String key;
  private String value;

  public AttributeDocument(final Attribute attribute) {
    this.key = attribute.getKey();
    this.value = attribute.getValue();
  }

  public Attribute toDomain() {
    return Attribute.builder()
        .key(this.key)
        .value(this.value)
        .build();
  }

}
