package example;

public class ArrayExample {
	public static void main(String[] args) {
		//사람들의 나이를 저장한 배열 생성하여 참조변수에 저장		
		int[] age={27,16,22,36,57,60,43,23,14,29,44,52,59,51,39,33,11};
		
		//배열에 저장된 모든 사람들의 나이 평균을 계산하여 출력하세요.
		int total=0;
		for(int nai : age) {
			total+=nai;
		}
		
		System.out.println("모든 사람들의 평균 나이 = "+(total/age.length)+"살");
		System.out.println("===============================================================");
		//배열에 저장된 사람들의 나이를 연령별로 구분하여 인원수를 계산하여 출력하세요.
		//ex) 10대 = 3명
		//    20대 = 4명
		//    ...
		//    60대 = 1명
		
		/*
		int count10=0, count20=0, count30=0, count40=0, count50=0, count60=0;
		
		for(int nai : age) {
			if(nai >= 10 && nai < 20) count10++;
			else if(nai >= 20 && nai < 30) count20++;
			else if(nai >= 30 && nai < 40) count30++;
			else if(nai >= 40 && nai < 50) count40++;
			else if(nai >= 50 && nai < 60) count50++;
			else if(nai >= 60 && nai < 70) count60++;
		}
		
		System.out.println("10 대 = "+count10+"명");
		System.out.println("20 대 = "+count20+"명");
		System.out.println("30 대 = "+count30+"명");
		System.out.println("40 대 = "+count40+"명");
		System.out.println("50 대 = "+count50+"명");
		System.out.println("60 대 = "+count60+"명");
		*/
		
		int[] count=new int[6];
		
		for(int nai : age) {
			/*
			switch(nai / 10) {
			case 1: count[0]++; break;
			case 2: count[1]++; break;
			case 3: count[2]++; break;
			case 4: count[3]++; break;
			case 5: count[4]++; break;
			case 6: count[5]++; break;
			}
			*/
			
			count[nai/10-1]++;
		}	
		
		for(int i=0;i<count.length;i++) {
			System.out.println((i+1)*10+"대 인원수 = "+count[i]);	
		}
		System.out.println("===============================================================");
	}
}