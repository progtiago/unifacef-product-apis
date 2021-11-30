package edu.unifacef.productapi.configurations.ff4j;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import java.util.Arrays;
import org.ff4j.FF4j;
import org.ff4j.core.FeatureStore;
import org.ff4j.mongo.store.FeatureStoreMongo;
import org.ff4j.web.ApiConfig;
import org.ff4j.web.FF4jDispatcherServlet;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
@ComponentScan(basePackages = "org.ff4j.aop")
public class FF4JConfiguration extends SpringBootServletInitializer {

  public static final String DEFAULT_CONSOLE = "/ff4j-console/*";
  public static final String FEATURES_COLLECTION = "ff4j-features";

  @Bean
  public FF4j getFF4j(final FeatureStore featureStore) {
    final FF4j ff4j = new FF4j();
    ff4j.setFeatureStore(featureStore);
    ff4j.disableAlterBeanThrowInvocationTargetException();

    Arrays.stream(Features.values())
        .filter(feature -> !ff4j.getFeatureStore().exist(feature.getKey()))
        .forEach(
            feature ->
                ff4j.createFeature(
                    feature.getKey(), feature.isDefaultValue(), feature.getDescription()));

    return ff4j;
  }

  @Bean
  public ApiConfig getApiConfig(final FF4j ff4j) {
    final ApiConfig apiConfig = new ApiConfig();
    apiConfig.setAuthenticate(false);
    apiConfig.setAutorize(false);
    apiConfig.setFF4j(ff4j);
    return apiConfig;
  }

  @Bean
  public FeatureStore featureStore(
      final MongoClient mongoClient, final MongoTemplate mongoTemplate) {
    final MongoDatabase mongoDatabase = mongoClient.getDatabase(mongoTemplate.getDb().getName());
    return new FeatureStoreMongo(mongoDatabase, FEATURES_COLLECTION);
  }

  @Bean
  @SuppressWarnings("unchecked")
  public ServletRegistrationBean ff4jDispatcherServletRegistrationBean(
      final FF4jDispatcherServlet ff4jDispatcherServlet) {
    return new ServletRegistrationBean(ff4jDispatcherServlet, DEFAULT_CONSOLE);
  }

  @Bean
  @ConditionalOnMissingBean
  public FF4jDispatcherServlet getFF4jDispatcherServlet(final FF4j ff4j) {
    final FF4jDispatcherServlet ff4jConsoleServlet = new FF4jDispatcherServlet();
    ff4jConsoleServlet.setFf4j(ff4j);
    return ff4jConsoleServlet;
  }
}
