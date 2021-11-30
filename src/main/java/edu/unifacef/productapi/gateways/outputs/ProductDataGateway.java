package edu.unifacef.productapi.gateways.outputs;

import edu.unifacef.productapi.domains.Product;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductDataGateway {

  Product save(Product product);

  Optional<Product> findByCode(String code);

  Page<Product> findByPage(Pageable pageable);
}
