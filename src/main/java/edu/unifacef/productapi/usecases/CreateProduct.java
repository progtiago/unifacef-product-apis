package edu.unifacef.productapi.usecases;

import static edu.unifacef.productapi.exceptions.MessageKey.PRODUCT_ALREADY_EXISTS;

import edu.unifacef.productapi.configurations.ff4j.Features;
import edu.unifacef.productapi.domains.Product;
import edu.unifacef.productapi.gateways.outputs.ProductDataGateway;
import edu.unifacef.productapi.gateways.outputs.StoreGateway;
import edu.unifacef.productapi.utils.MessageUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ff4j.FF4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class CreateProduct {

  private final ProductDataGateway productDataGateway;
  private final MessageUtils messageUtils;
  private final StoreGateway storeGateway;
  private final FF4j ff4j;

  public Product execute(final Product product) {
    log.info("Create product. Product code: {}", product.getCode());
    if(productDataGateway.findByCode(product.getCode()).isPresent()) {
      throw new IllegalArgumentException(messageUtils.getMessage(PRODUCT_ALREADY_EXISTS, product.getCode()));
    }

    Product saved = productDataGateway.save(product);
    if(ff4j.check(Features.SEND_TO_STORE.getKey())) {
      storeGateway.send(saved);
    }

    return saved;
  }
}
