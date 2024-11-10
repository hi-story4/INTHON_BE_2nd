package com.ai.be.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.core.mapping.event.ValidatingMongoEventListener;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
@EnableMongoRepositories(basePackages = "com.ai.be.domains")
@EnableMongoAuditing //BaseDocument
public class MongoConfig {

  @Bean
  public ValidatingMongoEventListener validatingMongoEventListener(
    final LocalValidatorFactoryBean factory
  ) {
    return new ValidatingMongoEventListener(factory);
  }
  //validation 활성화

}
