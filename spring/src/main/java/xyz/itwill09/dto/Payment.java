package xyz.itwill09.dto;

import lombok.Data;

//create table payment(imp_uid vartchar2(100), mercharnt_uid varchar2(100),
//	, amount number, pay_date date, userid varchar2(50), status varchar2(20)); 

@Data
public class Payment {
	private String impUid;//포트원 거래고유번호
	private String merchantUid;//가맹점 주문번호
	private long amount;//결재금액
	private String payDate;//결제일
	private String userid;//결재 아이디
	private String status;//결재 상태
}
