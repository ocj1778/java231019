package xyz.itwill09.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;
import xyz.itwill09.dto.Payment;
import xyz.itwill09.service.PaymentService;

@Controller
@RequestMapping("/pay")
@RequiredArgsConstructor
public class PaymentController {
	private final PaymentService paymentService;
	
	@RequestMapping(value="/payment", method = RequestMethod.GET)
	public String pay() {
		return "pay";	
	}
	
	@RequestMapping(value="/payment", method = RequestMethod.POST)
	@ResponseBody
	public String pay(@RequestBody Payment payment, HttpSession session) {
		//결제 관련 OpenAPI를 이용하기 전에 결제 금액 검증을 위해 세션에 주문번호(이름)와 결제금액(값)을 저장
		session.setAttribute(payment.getMerchantUid(), payment.getAmount());
		return "ok";	
	}
	
	//결제 처리 후 결제 금액을 검증하여 응답하는 요청 처리 메소드
	@RequestMapping(value="/complate", method = RequestMethod.POST)
	@ResponseBody
	public String complate(@RequestBody Payment payment, HttpSession session) {
		//접근 토큰을 발급받아 저장
		String accessToken=paymentService.getAccessToken(payment);
		
		//토큰과 결제고유값을 전달하여 OpenAPI를 이용하여 결제정보를 반환받아 저장
		Payment returnPayment=paymentService.getPayment(accessToken, payment.getImpUid());
		
		//세션에 저장된 결제 금액을 반환받아 저장
		Long beforeAmount=(Long)session.getAttribute(payment.getMerchantUid());
		session.removeAttribute(payment.getMerchantUid());
		
		//결제된 결제금액을 반환받아 저장
		Long amount=returnPayment.getAmount();
		
		if(beforeAmount == amount) {//검증 성공
			paymentService.addPayment(returnPayment);//테이블에 결제정보 삽입 처리
			return "success";
		} else {//검증 실패(결제 금액 불일치) - 위변조된 결제
			paymentService.canclePayment(accessToken, returnPayment);
			return "forgery";
		}
	}
}
