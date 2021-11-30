package edu.unifacef.productapi.gateways.inputs.http.responses;

import edu.unifacef.productapi.domains.Attribute;
import java.io.Serializable;
import lombok.Data;

@Data
public class AttributeResponse implements Serializable {

  private static final long serialVersionUID = 7808546186559340341L;

  private String key;
  private String value;

  public AttributeResponse(final Attribute attribute) {
    this.key = attribute.getKey();
    this.value = attribute.getValue();
  }

}
