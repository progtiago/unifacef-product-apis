package edu.unifacef.productapi.domains;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Attribute {

  private String key;
  private String value;

}
