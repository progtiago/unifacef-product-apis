package edu.unifacef.productapi.configurations.ff4j;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Features {

  SEND_TO_STORE(
      "send-to-store",
      "features",
      "Envia o produto cadastrado para a Store",
      true);

  private final String key;
  private final String groupName;
  private final String description;
  private final boolean defaultValue;

}
