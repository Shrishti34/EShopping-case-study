package eshopping.paymentservice.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.client.MongoClient;


@Configuration
@EnableAutoConfiguration
@EnableMongoRepositories(basePackages = "eshopping.paymentservice.repository")
public class MongoConfig {

	@Bean
	public MongoClient mongo() {
		return new MongoClient("localhost:27017");
	}

}