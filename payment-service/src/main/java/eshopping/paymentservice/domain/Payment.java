package eshopping.paymentservice.domain;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
	
	public static final String CLIENT_NULL_VALIDATION_MESSAGE = "Client must not be null";
	public static final String BUYER_NULL_VALIDATION_MESSAGE = "Buyer must not be null";
	public static final String AMOUNT_NULL_VALIDATION_MESSAGE = "Amount must not be null";

	@Id
	private ObjectId id;

	@NotNull(message = AMOUNT_NULL_VALIDATION_MESSAGE)
	private Double amount;

	private PaymentType type;

	@NotNull(message = CLIENT_NULL_VALIDATION_MESSAGE)
	@Valid
	private Client client;

	@NotNull(message = BUYER_NULL_VALIDATION_MESSAGE)
	@Valid
	private Buyer buyer;

	@Field(value = "credit_card")
	@Valid
	private CreditCard creditCard;
	
	private PaymentStatus status;
	
	private String barcode;

	public enum PaymentType {
		SLIP, CREDIT_CARD;
	}
	
	public enum PaymentStatus {
		APPROVED;
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Buyer getBuyer() {
		return buyer;
	}

	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}

	public CreditCard getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
	}

	public PaymentStatus getStatus() {
		return status;
	}

	public void setStatus(PaymentStatus status) {
		this.status = status;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public void setType(PaymentType type) {
		this.type = type;
	}

	public PaymentType getType() {
		if (creditCard != null) {
			return PaymentType.CREDIT_CARD;
		}
		return PaymentType.SLIP;
	}

}
