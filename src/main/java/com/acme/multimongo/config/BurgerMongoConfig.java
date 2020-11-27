package com.acme.multimongo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

/**
 * @author Visweshwar Ganesh
 * @Created 11/22/2020 - 3:01 PM
 */
@Configuration
@EnableReactiveMongoRepositories(basePackages = "com.acme.multimongo.repository.burger",
reactiveMongoTemplateRef = "mongoTemplateBurger")
public class BurgerMongoConfig {
}
