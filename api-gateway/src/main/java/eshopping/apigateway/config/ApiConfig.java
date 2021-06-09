package eshopping.apigateway.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import eshopping.apigateway.filter.SessionFilter;

@Configuration
public class ApiConfig {

    @Bean
    public SessionFilter sessionFilter(){
        return new SessionFilter();
    }
}