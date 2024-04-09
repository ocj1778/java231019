package xyz.itwill09.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Service;

import xyz.itwill09.dto.Payment;

@Service
public class PaymentServiceimpl implements PaymentService {

	//OpneAPI를 사용하기 위해 필요한 토큰을 발급받아 반환하는 메소드
	@Override
	public String getAccessToken(Payment payment) {
		String accessToken="";
		//토큰 발급을 요청하기 위한 OpenAPI의 URL 주소 저장
		String apiURL="https://api.iamport.kr/users/getToken";
		
		//요청할 OpenAPI에게 전달될 값을 JSON 형식의 문자열로 표현하여 저장
		// => {"imp_key" : REST API Key, "imp_secret" : REST API Secret}
		String data="{\"imp_key\":\"4655165165165\",\"imp_secret\":\"213df1g231dfg321df3g1dfg13sef21wegfdx23sg12sd\"}";
		try {
			//URL 주소가 저장된 URL 객체 생성
			URL url=new URL(apiURL);
			//URL.openConnection() : URL 객체에 저장된 정보를 사용하여 서버에 접속해 접속정보를 반환하는 메소드 
			HttpURLConnection connection=(HttpURLConnection)url.openConnection();
			connection.setRequestMethod("post");//요청방식을 변경하기 위해 필드값 변경
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
				
				System.out.println("result(Token) = "+result);//JSON 형식의 문자열
				
				//JSON 형식의 문자열을 Java 객체로 변환하기 위한 기능을 제공하는 json-simple 
				//라이브러리를 프로젝트에 빌드 처리 - 메이븐 : pom.xml
				
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return null;
	}

	//하나의 결재정보를 제공하는 OpenAPI를 사용해 결재정보를 반환하는 메소드
	@Override
	public Payment getPayment(String accessToken, String impUid) {
		// TODO Auto-generated method stub
		return null;
	}

	//결재정보를 취소하는 OpenAPI를 사용해 취소결과를 반환하는 메소드
	@Override
	public String canclePayment(String accessToken, Payment payment) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
