package edu.unifacef.productapi.usecases;

import static edu.unifacef.productapi.exceptions.MessageKey.PRODUCT_NOT_FOUND;

import edu.unifacef.productapi.domains.Product;
import edu.unifacef.productapi.exceptions.NotFoundException;
import edu.unifacef.productapi.gateways.outputs.ProductDataGateway;
import edu.unifacef.productapi.utils.MessageUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class FindByProductCode {

  private final ProductDataGateway productDataGateway;
  private final MessageUtils messageUtils;

  public Product execute(final String code) {
    log.info("Find product. Product code: {}", code);
    return productDataGateway.findByCode(code).orElseThrow(
        () -> new NotFoundException(messageUtils.getMessage(PRODUCT_NOT_FOUND, code)));
  }
}
