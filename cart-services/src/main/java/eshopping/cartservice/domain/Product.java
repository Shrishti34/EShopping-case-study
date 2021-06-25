package eshopping.cartservice.domain;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.List;

@EntityScan
@Document(collection = "product")
public class Product {

	@Id
	private Long id;
	private String name;
	private BigDecimal price;
	
	
	private List<Item> items;

	public Product() {
		
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
}
