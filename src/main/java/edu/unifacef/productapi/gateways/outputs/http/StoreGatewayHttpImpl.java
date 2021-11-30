package edu.unifacef.productapi.gateways.outputs.http;

import edu.unifacef.productapi.domains.Product;
import edu.unifacef.productapi.gateways.outputs.StoreGateway;
import edu.unifacef.productapi.gateways.outputs.http.resources.ProductResource;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class StoreGatewayHttpImpl implements StoreGateway {

  private final StoreFeignIntegration storeFeignIntegration;

  @Override
  public void send(final Product product) {
    log.info("Sending product to Store. Product code: {}", product.getCode());
    ProductResource productResource = new ProductResource(product);
    storeFeignIntegration.send(product.getCode(), productResource);
  }
}
