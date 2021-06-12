package eshopping.apigateway;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
@CrossOrigin
public class FallbackController {
	
	@RequestMapping("/userFallBack")
	public Mono<String> userServiceFallBack(){
		return Mono.just("User service is not working");
	}
	
	@RequestMapping("/product-catlogFallBack")
	public Mono<String> productcatlogServiceFallBack(){
		return Mono.just("User service is not working");
	}
	@RequestMapping("/oderFallBack")
	public Mono<String> orderServiceFallBack(){
		return Mono.just("User service is not working");
	}
	

}
