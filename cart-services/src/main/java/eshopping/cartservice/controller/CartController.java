package eshopping.cartservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import eshopping.cartservice.http.header.HeaderGenerator;
import eshopping.cartservice.service.CartService;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

@RestController
public class CartController {

    @Autowired
    CartService cartService;
    
    @Autowired
    private HeaderGenerator headerGenerator;

    @GetMapping (value = "/cart")
    public ResponseEntity<List<Object>> getCart(@RequestHeader(value = "Cookie") String cartId){
        List<Object> cart = cartService.getCart(cartId);
        if(!cart.isEmpty()) {
        	return new ResponseEntity<List<Object>>(
        			cart,
        			headerGenerator.getHeadersForSuccessGetMethod(),
        			HttpStatus.OK);
        }
    	return new ResponseEntity<List<Object>>(
    			headerGenerator.getHeadersForError(),
    			HttpStatus.NOT_FOUND);  
    }

    @PostMapping(value = "/cart", params = {"id", "quantity"})
    public ResponseEntity<List<Object>> addItemToCart(
            @RequestParam("id") Long id,
            @RequestParam("quantity") Integer quantity,
            @RequestHeader(value = "Cookie") String cartId,
            HttpServletRequest request) {
        List<Object> cart = cartService.getCart(cartId);
        if(cart != null) {
        	if(cart.isEmpty()){
        		cartService.addItemToCart(cartId, id, quantity);
        	}else{
        		if(cartService.checkIfItemIsExist(cartId, id)){
        			cartService.changeItemQuantity(cartId, id, quantity);
        		}else {
        			cartService.addItemToCart(cartId, id, quantity);
        		}
        	}
        	return new ResponseEntity<List<Object>>(
        			cart,
        			headerGenerator.getHeadersForSuccessPostMethod(request, Long.parseLong(cartId)),
        			HttpStatus.CREATED);
        }
        return new ResponseEntity<List<Object>>(
        		headerGenerator.getHeadersForError(),
        		HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping(value = "/cart", params = "id")
    public ResponseEntity<Void> removeItemFromCart(
            @RequestParam("id") Long id,
            @RequestHeader(value = "Cookie") String cartId){
    	List<Object> cart = cartService.getCart(cartId);
    	if(cart != null) {
    		cartService.deleteItemFromCart(cartId, id);
            return new ResponseEntity<Void>(
            		headerGenerator.getHeadersForSuccessGetMethod(),
            		HttpStatus.OK);
    	}
        return new ResponseEntity<Void>(
        		headerGenerator.getHeadersForError(),
        		HttpStatus.NOT_FOUND);
    }
}
