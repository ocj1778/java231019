package xyz.itwill09.service;

import xyz.itwill09.dto.Payment;

public interface PaymentService {
	void addPayment(Payment payment);	
	String getAccessToken(Payment payment);
	Payment getPayment(String accessToken, String impUid);
	String canclePayment(String accessToken, Payment payment);
}
