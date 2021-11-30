package edu.unifacef.productapi.usecases;

import edu.unifacef.productapi.domains.Product;
import edu.unifacef.productapi.gateways.outputs.ProductDataGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class FindProducts {

  private final ProductDataGateway productDataGateway;

  public Page<Product> execute(final Pageable pageable) {
    log.info("Find products. Page: {}, Size: {}", pageable.getPageNumber(), pageable.getPageSize());
    return productDataGateway.findByPage(pageable);
  }
}
