package eshopping.cartservice.feignclient;

import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import eshopping.cartservice.domain.Product;


@FeignClient(name = "order-service", url = "http://localhost:8813/")
public interface OrderClient {

    @GetMapping(value = "/order/{id}")
    public Product getProductById(@PathVariable(value = "id") Long id);

}