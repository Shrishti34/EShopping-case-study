package eshopping.productcatlogservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableEurekaClient
public class ProductCatlogServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductCatlogServiceApplication.class, args);
	}

}
