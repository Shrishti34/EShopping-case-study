package eshopping.productcatlogservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import eshopping.productcatlogservice.http.header.HeaderGenerator;
import eshopping.productcatlogservice.model.Product;
import eshopping.productcatlogservice.service.ProductService;

import java.util.List;


@RestController
public class ProductController {
	
	 @Autowired
	    private ProductService productService;
	    
	    @Autowired
	    private HeaderGenerator headerGenerator;
//to get all products
	    @GetMapping (value = "/products")
	    public ResponseEntity<List<Product>> getAllProducts(){
	        List<Product> products =  productService.getAllProduct();
	        if(!products.isEmpty()) {
	        	return new ResponseEntity<List<Product>>(
	        			products,
	        			headerGenerator.getHeadersForSuccessGetMethod(),
	        			HttpStatus.OK);
	        }
	        return new ResponseEntity<List<Product>>(
	        		headerGenerator.getHeadersForError(),
	        		HttpStatus.NOT_FOUND);       
	    }

	    @GetMapping(value = "/products", params = "category")
	    public ResponseEntity<List<Product>> getAllProductByCategory(@RequestParam ("category") String category){
	        List<Product> products = productService.getAllProductByCategory(category);
	        if(!products.isEmpty()) {
	        	return new ResponseEntity<List<Product>>(
	        			products,
	        			headerGenerator.getHeadersForSuccessGetMethod(),
	        			HttpStatus.OK);
	        }
	        return new ResponseEntity<List<Product>>(
	        		headerGenerator.getHeadersForError(),
	        		HttpStatus.NOT_FOUND);
	    }

	    @GetMapping (value = "/products/{id}")
	    public ResponseEntity<Product> getOneProductById(@PathVariable ("id") long id){
	        Product product =  productService.getProductById(id);
	        if(product != null) {
	        	return new ResponseEntity<Product>(
	        			product,
	        			headerGenerator.getHeadersForSuccessGetMethod(),
	        			HttpStatus.OK);
	        }
	        return new ResponseEntity<Product>(
	        		headerGenerator.getHeadersForError(),
	        		HttpStatus.NOT_FOUND);
	    }

	    @GetMapping (value = "/products", params = "name")
	    //@GetMapping (value = "/products/{name}")
	   public ResponseEntity<List<Product>> getAllProductsByName(@RequestParam ("name") String name){
	    //public ResponseEntity<List<Product>> getAllProductsByName(@PathVariable ("name") String name){
	        List<Product> products =  productService.getAllProductsByName(name);
	        if(!products.isEmpty()) {
	        	return new ResponseEntity<List<Product>>(
	        			products,
	        			headerGenerator.getHeadersForSuccessGetMethod(),
	        			HttpStatus.OK);
	        }
	        return new ResponseEntity<List<Product>>(
	        		headerGenerator.getHeadersForError(),
	        		HttpStatus.NOT_FOUND);
	    }
}