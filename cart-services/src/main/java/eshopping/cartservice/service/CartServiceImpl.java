package eshopping.cartservice.service;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import eshopping.cartservice.domain.Item;
import eshopping.cartservice.domain.Product;
import eshopping.cartservice.feignclient.ProductClient;
import eshopping.cartservice.redis.CartRedisRepository;
import eshopping.cartservice.utilities.CartUtilities;


import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private ProductClient productClient;

    @Autowired
    private CartRedisRepository cartRedisRepository;

    @Override
    public void addItemToCart(String cartId, Long id, Integer quantity) {
        Product product = productClient.getProductById(id);
        Item item = new Item(quantity,product, CartUtilities.getSubTotalForItem(product,quantity));
        cartRedisRepository.addItemToCart(cartId, item);
    }

    @Override
    public List<Object> getCart(String cartId) {
        return (List<Object>)cartRedisRepository.getCart(cartId, Item.class);
    }

    @Override
    public void changeItemQuantity(String cartId, Long id, Integer quantity) {
        List<Item> cart = (List)cartRedisRepository.getCart(cartId, Item.class);
        for(Item item : cart){
            if((item.getProduct().getId()).equals(id)){
                cartRedisRepository.deleteItemFromCart(cartId, item);
                item.setQuantity(quantity);
                item.setSubTotal(CartUtilities.getSubTotalForItem(item.getProduct(),quantity));
                cartRedisRepository.addItemToCart(cartId, item);
            }
        }
    }

    @Override
    public void deleteItemFromCart(String cartId, Long id) {
        List<Item> cart = (List) cartRedisRepository.getCart(cartId, Item.class);
        for(Item item : cart){
            if((item.getProduct().getId()).equals(id)){
                cartRedisRepository.deleteItemFromCart(cartId, item);
            }
        }
    }

    @Override
    public boolean checkIfItemIsExist(String cartId, Long id) {
        List<Item> cart = (List) cartRedisRepository.getCart(cartId, Item.class);
        for(Item item : cart){
            if((item.getProduct().getId()).equals(id)){
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Item> getAllItemsFromCart(String cartId) {
        List<Item> items = (List)cartRedisRepository.getCart(cartId, Item.class);
        return items;
    }

    @Override
    public void deleteCart(String cartId) {
        cartRedisRepository.deleteCart(cartId);
    }
}
