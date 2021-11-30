package edu.unifacef.productapi.gateways.inputs.http.requests;

import edu.unifacef.productapi.domains.Attribute;
import java.io.Serializable;
import lombok.Data;

@Data
public class AttributeRequest implements Serializable {

  private static final long serialVersionUID = -6834094997433764356L;

  private String key;
  private String value;

  public Attribute toDomain() {
    return Attribute.builder()
        .key(this.key)
        .value(this.value)
        .build();
  }
}
