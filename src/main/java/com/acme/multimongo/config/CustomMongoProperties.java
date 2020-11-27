package com.acme.multimongo.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author Visweshwar Ganesh
 * @Created 11/22/2020 - 10:00 AM
 */
@Configuration
@ConfigurationProperties(prefix = "spring.data.mongodb")
@Getter
@Setter
public class CustomMongoProperties {
	private MongoProperties coffee;
	private MongoProperties burger;

}
