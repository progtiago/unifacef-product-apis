package edu.unifacef.productapi.gateways.outputs.mongodb;

import edu.unifacef.productapi.domains.Product;
import edu.unifacef.productapi.gateways.outputs.ProductDataGateway;
import edu.unifacef.productapi.gateways.outputs.mongodb.documents.ProductDocument;
import edu.unifacef.productapi.gateways.outputs.mongodb.repositories.ProductRepository;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductDataGatewayMongoImpl implements ProductDataGateway {

  private final ProductRepository productRepository;

  @Override
  public Product save(final Product product) {
    if(Objects.isNull(product.getCreatedDate())) {
      product.setCreatedDate(LocalDateTime.now());
    }
    return productRepository.save(new ProductDocument(product)).toDomain();
  }

  @Override
  public Optional<Product> findByCode(final String code) {
    return productRepository.findById(code).map(ProductDocument::toDomain);
  }

  @Override
  public Page<Product> findByPage(final Pageable pageable) {
    return productRepository.findAll(pageable).map(ProductDocument::toDomain);
  }
}
