package edu.unifacef.productapi.gateways.outputs;

import edu.unifacef.productapi.domains.Product;

public interface StoreGateway {

  void send(Product product);

}
