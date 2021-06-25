package eshopping.paymentservice.service;

import eshopping.paymentservice.domain.Payment;

public interface PaymentProcess {

	Payment process(Payment payment);

}
