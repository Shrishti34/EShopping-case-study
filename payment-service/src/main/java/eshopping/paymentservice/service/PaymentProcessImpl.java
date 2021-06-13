package eshopping.paymentservice.service;


import org.springframework.stereotype.Service;

import eshopping.paymentservice.domain.Payment;
import eshopping.paymentservice.domain.Payment.PaymentStatus;
import eshopping.paymentservice.domain.Payment.PaymentType;
import eshopping.paymentservice.repository.Payments;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PaymentProcessImpl implements PaymentProcess {
	
	private final Payments payments;

	public Payment process(Payment payment) {
	payment.setStatus(PaymentStatus.APPROVED);
	Payment paymentSaved = payments.save(payment);

	if (payment.getType().equals(PaymentType.SLIP)) {
		payment.setBarcode("1111111 1 2222222 2 333333 3 44444 4");
		return payment;
	} else {
		return paymentSaved;
	}
}

}