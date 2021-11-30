package edu.unifacef.productapi.gateways.outputs.http;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import edu.unifacef.productapi.gateways.outputs.http.resources.ProductResource;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "store", url = "${integration.store.url}")
public interface StoreFeignIntegration {

  @PostMapping(path = "/api/v1/products/{code}", consumes = APPLICATION_JSON_VALUE)
  void send(@PathVariable("code") final String code,
            final ProductResource productResource);
}
