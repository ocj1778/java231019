package xyz.itwill.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

//웹프로그램 작성에 필요한 기능을 제공하기 위한 클래스
public class Utility {
	//문자열(비밀번호)을 전달받아 암호화 처리하여 반환하는 정적 메소드
	public static String encrypt(String passwd) {
		String encryptPasswd="";//암호화 처리된 문자열을 저장하기 위한 변수
		try {
			//MessageDigest 객체를 반환받아 저장
			//MessageDigest.getInstance(String algorithm) : 매개변수로 전달받은 암호화 알고리즘이
			//저장된 MessageDigest 객체를 반환하는 정적메소드
			// => MessageDigest 객체 : 암호화 처리 기능을 제공하기 위한 객체
			// => 매개변수에 잘못된 암호화 알고리즘이 전달된 경우 NoSuchAlgorithmException 발생
			//단방향 암호화 알고리즘(복호화 처리 불가능) : MD5, SHA-1, SHA-256, SHA-512 등 
			//양방향 암호화 알고리즘(복호화 처리 가능) : AES-123, RSA 등 
			MessageDigest messageDigest=MessageDigest.getInstance("SHA-256");
			
			//MessageDigest.update(byte[] input) : MessageDigest 객체에 암호화 처리하기 위한 
			//문자열을 byte 배열로 전달받아 저장하기 위한 메소드
			//String.getBytes() : String 객체에 저장된 문자열을 byte 배열로 반환하는 메소드
			messageDigest.update(passwd.getBytes());
			
			//MessageDigest.digest() : MessageDigest 객체에 저장된 암호화 알고리즘을 사용하여
			//byte 배열의 요소값을 암호화 처리하여 byte 배열로 반환하는 메소드
			byte[] digest=messageDigest.digest();
			
			//암호화 처리된 원시데이타가 저장된 byte 배열을 String 객체(문자열)로 변환하여 저장
			for(int i=0;i<digest.length;i++) {
				//Integer.toHexString(int i) : 매개변수로 전달받은 정수값을 16진수의 문자열로 변환하여 반환하는 메소드
				encryptPasswd+=Integer.toHexString(digest[i] & 0xff);
			}
		} catch (NoSuchAlgorithmException e) {
			System.out.println("[에러]잘못된 암호화 알고리즘을 사용 하였습니다.");
		} 
		return encryptPasswd;
	}
}
