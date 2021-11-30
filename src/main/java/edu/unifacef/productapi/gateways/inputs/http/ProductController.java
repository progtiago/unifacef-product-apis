package edu.unifacef.productapi.gateways.inputs.http;

import edu.unifacef.productapi.domains.Product;
import edu.unifacef.productapi.gateways.inputs.http.requests.CreateProductRequest;
import edu.unifacef.productapi.gateways.inputs.http.requests.UpdateProductRequest;
import edu.unifacef.productapi.gateways.inputs.http.responses.ListResponse;
import edu.unifacef.productapi.gateways.inputs.http.responses.ProductResponse;
import edu.unifacef.productapi.usecases.CreateProduct;
import edu.unifacef.productapi.usecases.FindByProductCode;
import edu.unifacef.productapi.usecases.FindProducts;
import edu.unifacef.productapi.usecases.UpdateProduct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/products")
public class ProductController {

  private final CreateProduct createProduct;
  private final UpdateProduct updateProduct;
  private final FindByProductCode findByProductCode;
  private final FindProducts findProducts;

  @PostMapping
  public ProductResponse create(@RequestBody @Validated final CreateProductRequest request) {
    Product product = createProduct.execute(request.toDomain());
    return new ProductResponse(product);
  }

  @PutMapping(path = "/{code}")
  public ProductResponse update(@PathVariable final String code,
                                @RequestBody @Validated final UpdateProductRequest request) {
    Product product = updateProduct.execute(request.toDomain(code));
    return new ProductResponse(product);
  }

  @GetMapping(path = "/{code}")
  public ProductResponse find(@PathVariable final String code) {
    Product product = findByProductCode.execute(code);
    return new ProductResponse(product);
  }

  @GetMapping
  public ListResponse<ProductResponse> findByPage(@RequestParam(defaultValue = "0") final Integer page,
                                                  @RequestParam(defaultValue = "20") final Integer size) {
    Page<ProductResponse> productPage =
        findProducts.execute(PageRequest.of(page, size)).map(ProductResponse::new);
    return new ListResponse<>(productPage);
  }
}
