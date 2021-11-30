package edu.unifacef.productapi.configurations.feign;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

import feign.Request;
import feign.Retryer;
import feign.Retryer.Default;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = {"edu.unifacef.productapi.gateways.outputs.http"})
public class FeignConfiguration {

  @Value("${feign.connectionTimeout:60000}")
  private int feignConnectionTimeout;

  @Value("${feign.readTimeout:60000}")
  private int feignReadTimeout;

  @Bean
  public Retryer retry() {
    return new Default();
  }

  @Bean
  public Request.Options requestOptions() {
    return new Request.Options(
        feignConnectionTimeout, MILLISECONDS, feignReadTimeout, MILLISECONDS, true);
  }

}
