package xyz.itwill.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

//1~45 범위의 정수 난수값을 6개 제공받아 출력하는 프로그램 작성
// => 6개의 난수값은 서로 중복되지 않도록 처리하고 오름차순 정렬하여 출력
public class LottoSetApp {
	public static void main(String[] args) {
		Random random=new Random();
		
		//Integer 객체만 요소값으로 저장 가능한 Set 객체(HashSet 객체) 생성
		Set<Integer> lottoSet=new HashSet<Integer>();
		
		while(true) {
			//Set 객체에 요소값으로 1~45 범위의 정수값이 저장된 Integer 객체 저장
			// => Set 객체에는 동일한 값이 저장된 Integer 객체를 요소값으로 저장 미허용
			lottoSet.add(random.nextInt(45)+1);
			
			//Set 객체에 저장된 요소값(Integer 객체)가 6개인 경우 반복문 종료
			if(lottoSet.size() == 6) break;
		}
		
		//Set.toArray(E[] a) : Set 객체에 저장된 모든 요소값(Integer 객체)을 매개변수로 전달받은
		//배열 요소에 저장하여 반환하는 메소드 - Set 객체를 배열로 변환하여 반환
		Integer[] lotto=lottoSet.toArray(new Integer[0]);
		
		//Arrays.sort(Object[] a) : 매개변수로 전달받은 배열의 요소값을 오름차순 정렬하는 정적메소드
		Arrays.sort(lotto);
		
		//Arrays.toString(Object[] a) : 매개변수로 전달받은 배열의 모든 요소값을 문자열로
		//변환하여 반환하는 정적메소드
		System.out.println("행운의 숫자 = "+Arrays.toString(lotto));
	}
}
