package edu.unifacef.productapi.gateways.outputs.mongodb.repositories;

import edu.unifacef.productapi.gateways.outputs.mongodb.documents.ProductDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<ProductDocument, String> {
}
