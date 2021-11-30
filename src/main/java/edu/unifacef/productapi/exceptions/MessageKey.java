package edu.unifacef.productapi.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MessageKey {

  PRODUCT_NOT_FOUND("product.not.found"),
  PRODUCT_ALREADY_EXISTS("product.already.exists");

  private String key;

}
