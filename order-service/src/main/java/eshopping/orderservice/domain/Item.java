package eshopping.orderservice.domain;


import javax.validation.constraints.NotNull;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.List;

@EntityScan
@Document(collection = "cart")
public class Item {

	 @Id
	 private Long id;
	 private int quantity;
	 private BigDecimal subTotal;
	 private Product product;
	 private List<Order> orders;
	 
	 public Item() {
	    	
	    }
	 
	 public Item(@NotNull int quantity, Product product, BigDecimal subTotal) {
	        this.quantity = quantity;
	        this.product = product;
	        this.subTotal = subTotal;
	    }
	 
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public int getQuantity() {
			return quantity;
		}

		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}

		public BigDecimal getSubTotal() {
			return subTotal;
		}

		public void setSubTotal(BigDecimal subTotal) {
			this.subTotal = subTotal;
		}

		public Product getProduct() {
			return product;
		}

		public void setProduct(Product product) {
			this.product = product;
		}

		public List<Order> getOrders() {
			return orders;
		}

		public void setOrders(List<Order> orders) {
			this.orders = orders;
		}
	}
