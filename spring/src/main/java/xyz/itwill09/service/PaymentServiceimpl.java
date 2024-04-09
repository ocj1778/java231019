package xyz.itwill09.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Service;

import xyz.itwill09.dto.Payment;

@Service
public class PaymentServiceimpl implements PaymentService {
	@Override
	public void addPayment(Payment payment) {
		System.out.println("결재정보를 테이블의 행으로 삽입하는 명령 실행 - DAO 클래스의 메소드 호출");
	}
	
	//OpneAPI를 사용하기 위해 필요한 토큰을 발급받아 반환하는 메소드
	@Override
	public String getAccessToken(Payment payment) {
		String accessToken="";
		//토큰 발급을 요청하기 위한 OpenAPI의 URL 주소 저장
		String apiURL="https://api.iamport.kr/users/getToken";
		
		//요청할 OpenAPI에게 전달될 값을 JSON 형식의 문자열로 표현하여 저장
		// => {"imp_key" : REST API Key, "imp_secret" : REST API Secret}
		String data="{\"imp_key\":\"7145387726131117\",\"imp_secret\":\"p6hCDrAyOWsAd4wn5e6kN6L2Si3yT1wI8cUivJDq0YasIVqxucrW9BWy4DTE9Yng8iEkrFMnDohOTEe3\"}";
		try {
			//URL 주소가 저장된 URL 객체 생성
			URL url=new URL(apiURL);
			//URL.openConnection() : URL 객체에 저장된 정보를 사용하여 서버에 접속해 접속정보를 반환하는 메소드 
			HttpURLConnection connection=(HttpURLConnection)url.openConnection();
			connection.setRequestMethod("POST");//요청방식을 변경하기 위해 필드값 변경
			connection.setRequestProperty("Content-Type", "application/json");//전달값의 형식을 변경하기 위해 필드값 변경
			connection.setDoOutput(true);//응답결과를 반환받기 위해 필드값 변경
			
			//OpenAPI 요청에 필요한 값을 전달하기 위한 출력스트림을 반환받아 저장
			try(OutputStream out=connection.getOutputStream()) {
				byte[] requestData=data.getBytes("utf-8");
				out.write(requestData);//출력스트림을 사용하여 OpenAPI에게 값 전달
				out.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		
			//응답코드를 반환받아 저장
			int responseCode=connection.getResponseCode();
			
			if(responseCode == 200) {
				//응답결과를 제공받기 위한 입력스트림을 반환받아 저장 - 확장
				BufferedReader br=new BufferedReader(new InputStreamReader(connection.getInputStream()));
				
				//입력스트림을 사용하여 응답결과를 제공받아 저장
				String input="";
				String result="";
				while((input = br.readLine()) != null) {
					result+=input;
				}
				br.close();
				
				//System.out.println("result(Token) = "+result);//JSON 형식의 문자열
				/*
				{
					"code": 0,
					"message": null,
					"response": {
						"access_token": "a2e771c3432a0b2c7816d78732715e83d512d31c",
					    "now": 1712634724,
					    "expired_at": 1712636524
				  	}
				}
				*/	
				
				//JSON 형식의 문자열을 Java 객체로 변환하기 위한 기능을 제공하는 json-simple 
				//라이브러리를 프로젝트에 빌드 처리 - 메이븐 : pom.xml
				//JSONParser 객체 : JSON 형식의 문자열을 Java 객체로 변환하기 위한 기능을 제공하는 객체
				JSONParser jsonParser=new JSONParser();
				//JSONParser.parse(String json) : 매개변수로 JSON 형식의 문자열을 전달받아
				//Java 객체(Object 객체)로 반환하는 메소드
				// => JSONObject 객체(Javascript의 Object 객체와 유사)로 형변환하여 저장
				JSONObject jsonObject=(JSONObject)jsonParser.parse(result);
				//JSONObject.get(String name) : JSONObject 객체에서 매개변수로 전달받은 속성명의
				//속성값(Object 객체)을 반환하는 메소드
				JSONObject responseObject=(JSONObject)jsonObject.get("response");
				accessToken=(String)responseObject.get("access_token");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return accessToken;
	}

	//하나의 결재정보를 제공하는 OpenAPI를 사용해 결재정보를 반환하는 메소드
	@Override
	public Payment getPayment(String accessToken, String impUid) {
		Payment payment=new Payment();//응답결과를 저장하기 위해 Payment 객체 생성
		//결재번호를 전달받아 결재정보를 제공받기 위한 OpenAPI의 URL 주소 저장
		String apiURL="https://api.iamport.kr/payments/"+impUid;
		try {
			URL url=new URL(apiURL);
			HttpURLConnection connection=(HttpURLConnection)url.openConnection();
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Authorization", accessToken);
			int responseCode=connection.getResponseCode();
			if(responseCode == 200) {
				BufferedReader br=new BufferedReader(new InputStreamReader(connection.getInputStream()));
				String input="";
				String result="";
				while((input = br.readLine()) != null) {
					result+=input;
				}
				br.close();
				
				//System.out.println("result(payment) = "+result);
				/*
				{
					  "code": 0,
					  "message": null,
					  "response": {
					    "amount": 10,
					    "apply_num": "",
					    "bank_code": null,
					    "bank_name": null,
					    "buyer_addr": "서울시 강남구 역삼동 내빌딩 5층 501호",
					    "buyer_email": "ocj1778@hanmail.net",
					    "buyer_name": "홍길동",
					    "buyer_postcode": "123-456",
					    "buyer_tel": "010-1234-5678",
					    "cancel_amount": 10,
					    "cancel_history": [
					      {
					        "pg_tid": "T507bb7d3aef3ee760ed",
					        "amount": 10,
					        "cancelled_at": 1695005582,
					        "reason": "취소요청api",
					        "receipt_url": "https://mockup-pg-web.kakao.com/v1/confirmation/p/T507bb7d3aef3ee760ed/b4b64a1eac2708bb6863f863bf4650967394f3d49647aa52f3ff03a4ce2c0a81",
					        "cancellation_id": "06JC8FVHJTW2WY16FEY0"
					      }
					    ],
					    "cancel_reason": "취소요청api",
					    "cancel_receipt_urls": [
					      "https://mockup-pg-web.kakao.com/v1/confirmation/p/T507bb7d3aef3ee760ed/b4b64a1eac2708bb6863f863bf4650967394f3d49647aa52f3ff03a4ce2c0a81"
					    ],
					    "cancelled_at": 1695005582,
					    "card_code": null,
					    "card_name": null,
					    "card_number": null,
					    "card_quota": 0,
					    "card_type": null,
					    "cash_receipt_issued": false,
					    "channel": "pc",
					    "currency": "KRW",
					    "custom_data": null,
					    "customer_uid": null,
					    "customer_uid_usage": null,
					    "emb_pg_provider": null,
					    "escrow": false,
					    "fail_reason": null,
					    "failed_at": 0,
					    "imp_uid": "imp_146565009559",
					    "merchant_uid": "merchant_1695005564459",
					    "name": "컴퓨터",
					    "paid_at": 1695005582,
					    "pay_method": "point",
					    "pg_id": "TC0ONETIME",
					    "pg_provider": "kakaopay",
					    "pg_tid": "T507bb7d3aef3ee760ed",
					    "receipt_url": "https://mockup-pg-web.kakao.com/v1/confirmation/p/T507bb7d3aef3ee760ed/b4b64a1eac2708bb6863f863bf4650967394f3d49647aa52f3ff03a4ce2c0a81",
					    "started_at": 1695005565,
					    "status": "cancelled",
					    "user_agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/116.0.0.0 Safari/537.36",
					    "vbank_code": null,
					    "vbank_date": 0,
					    "vbank_holder": null,
					    "vbank_issued_at": 0,
					    "vbank_name": null,
					    "vbank_num": null
					  }
				}
				*/
				JSONParser jsonParser=new JSONParser();
				JSONObject jsonObject=(JSONObject)jsonParser.parse(result);
				JSONObject responseObject=(JSONObject)jsonObject.get("response");
				
				payment.setImpUid((String)responseObject.get("imp_uid"));
				payment.setMerchantUid((String)responseObject.get("merchant_uid"));
				payment.setAmount((Long)responseObject.get("amount"));
				payment.setStatus((String)responseObject.get("status"));
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return payment;
	}

	//결재정보를 취소하는 OpenAPI를 사용해 취소결과를 반환하는 메소드
	@Override
	public String canclePayment(String accessToken, Payment payment) {
		//결재 취소를 요청하기 위한 OpenAPI의 URL 주소 저장
		String apiUrl="https://api.iamport.kr/payments/cancel";
		//요청 API에게 전달될 값을 JSON 형식의 문자열로 표현하여 저장
		// => {"imp_uid" : 결재고유값, "checksum" : 취소금액} 
		String data="{\"imp_uid\":\""+payment.getImpUid()+"\", \"checksum\":\""+payment.getAmount()+"\"}";
		
		String returnValue="";
		try {
			URL url = new URL(apiUrl);
			HttpURLConnection connection=(HttpURLConnection)url.openConnection();
			connection.setDoOutput(true);
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Content-Type", "application/json");
			connection.setRequestProperty("Authorization", accessToken);
			
			//OpenAPI 요청에 필요한 값을 출력스트림을 제공받아 전달
			try(OutputStream out=connection.getOutputStream()) {
				byte[] requestDate=data.getBytes("utf-8");
				out.write(requestDate);
				out.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

			//응답코드를 반환받아 저장
			int responseCode=connection.getResponseCode();

			if(responseCode == 200) {
				returnValue="success";	
			} else {
				returnValue="fail";	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return returnValue;

	}
	
}
