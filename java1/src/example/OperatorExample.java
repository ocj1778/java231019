package example;

public class OperatorExample {
	public static void main(String[] args) {
		//245678초를 일시분초 형식으로 변환하여 출력하세요.
		int cho=245678;
		System.out.print(cho+"초 = ");
		
		int day=cho/(24*60*60);//24*60*60 = 86400
		cho%=86400;//변수에 저장된 초단위 시간에서 몫(일)을 제외한 나머지 값을 계산하여 변수에 재저장
		int hour=cho/(60*60);//60*60 = 3600
		cho%=3600;//변수에 저장된 초단위 시간에서 몫(시)을 제외한 나머지 값을 계산하여 변수에 재저장
		int min=cho/60;
		int sec=cho%60;
		
		System.out.println(day+"일 "+hour+"시 "+min+"분 "+sec+"초");
		System.out.println("==============================================================");
		//한대의 가격이 1억 5천원만인 비행기를 20대 구매할 경우 지불해야될 금액을 계산하여 출력하세요. 
		//단, 15대 이상 구매할 경우 1대당 25%의 할인율을 적용하여 계산하세요.
		int plane=150_000_000, count=20;
		long money=(long)(count>=15?plane*0.75:plane)*count;
		System.out.println("지불 금액 = "+money);
		System.out.println("==============================================================");
	}
}