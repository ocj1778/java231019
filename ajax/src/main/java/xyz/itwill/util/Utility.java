package xyz.itwill.util;

public class Utility {
	//문자열을 전달받아 태그 관련 문자를 회피문자로 변환하여 반환하는 메소드
	public static String escapeTag(String source) {
		return source.replace("<", "&lt;").replace(">", "&gt;");
	}
	
	//JSON 형식의 데이타에서 문자값으로 표현 불가능한 문자를 회피문자를 변환하여 반환하는 메소드
	public static String toJSON(String source) {
		return source.replace("\\", "\\\\").replace("\"", "\\\"")
				.replace("\n", "\\n").replace("\r\n", "\\n");
	}
}


