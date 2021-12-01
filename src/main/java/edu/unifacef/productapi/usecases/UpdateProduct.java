package edu.unifacef.productapi.usecases;

import static edu.unifacef.productapi.exceptions.MessageKey.PRODUCT_NOT_FOUND;

import edu.unifacef.productapi.configurations.ff4j.Features;
import edu.unifacef.productapi.domains.Product;
import edu.unifacef.productapi.exceptions.NotFoundException;
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
public class UpdateProduct {

  private final ProductDataGateway productDataGateway;
  private final StoreGateway storeGateway;
  private final MessageUtils messageUtils;
  private final FF4j ff4j;

  public Product execute(final Product product) {
    log.info("Update product. Product code: {}", product.getCode());
    Product oldProduct = productDataGateway.findByCode(product.getCode()).orElseThrow(() ->
        new NotFoundException(messageUtils.getMessage(PRODUCT_NOT_FOUND, product.getCode())));
    product.setCreatedDate(oldProduct.getCreatedDate());

    Product saved = productDataGateway.save(product);
    if(ff4j.check(Features.SEND_TO_STORE.getKey())) {
      storeGateway.send(saved);
    }
    return saved;
  }
}
