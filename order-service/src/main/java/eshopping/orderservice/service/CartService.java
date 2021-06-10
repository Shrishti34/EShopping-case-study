package eshopping.orderservice.service;

import java.util.List;

import eshopping.orderservice.domain.Item;

public interface CartService {

    public void addItemToCart(String cartId, Long id, Integer quantity);
    public List<Object> getCart(String cartId);
    public void changeItemQuantity(String cartId, Long id, Integer quantity);
    public void deleteItemFromCart(String cartId, Long id);
    public boolean checkIfItemIsExist(String cartId, Long id);
    public List<Item> getAllItemsFromCart(String cartId);
    public void deleteCart(String cartId);
}