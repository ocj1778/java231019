package basic;

//1~45 범위의 정수 난수값을 6개 제공받아 출력하는 프로그램 작성
// => 6개의 난수값은 서로 중복되지 않도록 처리하고 오름차순 정렬하여 출력
//정렬(Sort) : 값을 비교하여 순서대로 나열하는 기능 - 오름차순 정렬(Ascending Sort), 내림차순 정렬(Descending Sort)
public class LottoApp {
	public static void main(String[] args) {
		//6개의 정수 난수값을 저장하기 위한 배열을 생성하여 참조변수에 저장
		int[] lotto=new int[6];
		
		//1~45 범위의 정수 난수값을 6개 제공받아 배열 요소에 차례대로 저장
		//새로운 난수값을 제공받아 저장하기 위한 배열 요소의 첨자를 표현하기 위한 반복문
		for(int i=0;i<lotto.length;i++) {
			//난수값을 제공받아 요소에 저장하고 기존 요소의 난수값과 비교하여 같은 난수값이 
			//기존 요소에 저장되어 있는 경우 새로운 난수값을 제공받아 요소에 저장하기 위한 반복문
			// => 제공받은 난수값이 기존 요소에 저장된 모든 난수값과 다른 경우 반복문 종료 
			while(true) {
				//1~45 범위의 정수 난수값을 제공받아 배열 요소에 저장
				lotto[i]=(int)(Math.random()*45)+1;
				
				//중복 상태를 저장하기 위한 변수
				// => false : 미중복, true : 중복
				boolean result=false;
				
				//기존 난수값이 저장된 배열 요소의 첨자를 표현하기 위한 반복문
				for(int j=0;j<i;j++) {
					//lotto[i] : 새로운 난수값이 저장된 배열 요소
					//lotto[j] : 기존 난수값이 저장된 배열 요소
					if(lotto[i]==lotto[j]) {//새로운 난수값과 기존 난수값이 중복된 경우
						result=true;
						break;//새로운 난수값과 기존 난수값을 비교하는 반복문 종료
					}
				}
				
				//새로운 난수값이 기존 난수값과 중복되지 않을 경우 반복문(while) 종료
				if(!result) break;
			}
		}
		
		//배열의 모든 요소값을 비교하여 오름차순 정렬되도록 배열의 요소값을 바꾸어 저장
		// => 선택 정렬 알고리즘(Selection Sort Algorithm)를 사용하여 오름차순 정렬되도록 처리
		for(int i=0;i<lotto.length-1;i++) {//비교 요소의 첨자를 표현하기 위한 반복문 : 처음 ~ 끝-1
			for(int j=i+1;j<lotto.length;j++) {//피비교 요소의 첨자를 표현하기 위한 반복문 : 비교+1 ~ 끝
				//lotto[i] : 비교하는 요소, lotto[j] : 피비교 요소 
				if(lotto[i] > lotto[j]) {//오름차순 정렬
					//요소에 저장된 값을 바꾸어 저장 - Swap Algorithm
					int temp=lotto[i];
					lotto[i]=lotto[j];
					lotto[j]=temp;
				}
			}
		}
		
		//배열의 모든 요소값 출력
		System.out.print("행운의 숫자 >> ");
		for(int number : lotto) {
			System.out.print(number+" ");
		}
		System.out.println();
	}
}






