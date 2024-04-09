<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SPRING</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
<script src="https://cdn.iamport.kr/v1/iamport.js"></script>
</head>
<body>
	<h1>결제페이지</h1>
	<hr>
	<h3>결제 관련 제품 정보 출력</h3>
	<hr>
	<button type="button" id="html5_inicis" class="pay">일반결재(KG이니시스)</button>
	<button type="button" id="kakaopay" class="pay">간편결재(카카오페이)</button>
	
	<script type="text/javascript">
	$(".pay").click(function() {
		var pg=$(this).attr("id");
		//alert(pg);
		
		var IMP=window.IMP;
		//IMP 객체 초기화 - 가맹점 식별코드
		IMP.init("imp37020058");
		
		//주문번호 - 주문테이블에서 제공된 값 사용
		var merchantUid="merchant_"+new Date().getTime();
		//결제금액 - 주문테이블에서 제공된 값 사용
		var amount=10;
		
		//결제 전 주문번호와 결제금액을 세션에 저장하기 위한 페이지 요청
		// => 결제 후 결제정보와 비교하여 검증하기 위해 세션에 저장 
		$.ajax({
			type: "post",
			url: "<c:url value="/pay/payment"/>",
			contentType: "application/json",
			data: JSON.stringify({"merchantUid":merchantUid, "amount":amount}),
			dataType: "text",
			success: function(result) {
				if(result=="ok") {
					//결제를 요청하는 메소드 호출
					IMP.request_pay({
						// 결제 대행사 : kakaopay, html5_inicis, nice, jtnet, uplus, danal, payco 등
						pg : pg,
						// 결제 방식 : card(카드), samsung(삼성페이), trans(실시간계좌이체), vbank(가상계좌), phone(휴대폰소액결제)
						pay_method : "card",
						//주문번호
						merchant_uid : merchantUid,
						//결제금액
						amount : amount,
						//결제창에 보여질 제품명
						name: "컴퓨터",
						//결제 사용자의 이메일 주소 
			            buyer_email: "ocj1778@hanmail.net",
			            buyer_name: "홍길동",//결제 사용자 이름
			            buyer_tel: "010-1234-5678",//결제 사용자 전화번호
			            buyer_postcode: "123-456",//결제 사용자 우편번호
			            buyer_addr: "서울시 강남구 역삼동 내빌딩 4층 3강의실",//결제 사용자 주소
						//m_redirect_url: "http://localhost:8000:auth/payment/pay",//모바일의 리다이렉트 URL 주소
					}, function(response) {//결제 관련 응답 결과를 제공받아 처리하는 함수
						//response : 응답결과를 저장한 Object 객체
						if (response.success) {//결제한 경우
							//결제금액을 검증하기 위한 페이지를 요청
							$.ajax({
								type: "post",
								url: "<c:url value="/pay/complate"/>",
								contentType: "application/json",
								data: JSON.stringify({"impUid": response.imp_uid, "merchantUid": response.merchant_uid}),
								dataType: "text",
								success: function(result) {
									if(result == "success") {
										//결제 성공 페이지로 이동
										alert("결제 성공");
									} else {
										//결제 실패 페이지로 이동
										alert("결제 취소");
									}
								}, 
								error: function(xhr) {
									alert("에러 = "+xhr.status);
								}
							});
						}
					});
				}
			}, 
			error: function(xhr) {
				alert("에러 = "+xhr.status);
			}
		});
		
	});
	</script>
</body>
</html>