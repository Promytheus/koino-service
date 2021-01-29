package org.promytheus.koino;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

@SpringBootApplication
@EnableMongoRepositories
@ComponentScan(basePackages = {"org.promytheus.koino"})
public class Application extends AbstractMongoClientConfiguration {
	
	public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
	
	@Bean
	public MongoClient mongoClient() {
		return MongoClients.create("mongodb://koino-mongodb");
	}
	
	@Override
	protected String getDatabaseName() {
		return "koino-service";
	}
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/api/v1/**")
					.allowedOrigins("*");
			}
		};
	}
}
