package org.promytheus.koino;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

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

        return MongoClients.create("mongodb://koino:password@koino-mongodb/?authSource=koino-service");
	}
	
	@Override
	protected String getDatabaseName() {
		return "koino-service";
    }
}
