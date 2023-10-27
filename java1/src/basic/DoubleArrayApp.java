package basic;

//2차원 배열 : 1차원 배열의 모임
public class DoubleArrayApp {
	public static void main(String[] args) {
		//형식)자료형[][] 참조변수=new 자료형[행갯수][열갯수];
		// => 행갯수 : 2차원 배열에 존재하는 1차원 배열의 갯수
		// => 열갯수 : 1차원 배열에 존재하는 요소의 갯수
		int[][] numArray=new int[2][3];
		
		System.out.println("numArray = "+numArray);
		System.out.println("numArray[0] = "+numArray[0]);
		System.out.println("numArray[1] = "+numArray[1]);
		System.out.println("==============================================================");
		//2차원 배열의 요소를 사용하기 위해서는 첨자를 2개 사용
		System.out.println("numArray[0][0] = "+numArray[0][0]);
		System.out.println("numArray[0][1] = "+numArray[0][1]);
		System.out.println("numArray[0][2] = "+numArray[0][2]);

		System.out.println("numArray[1][0] = "+numArray[1][0]);
		System.out.println("numArray[1][1] = "+numArray[1][1]);
		System.out.println("numArray[1][2] = "+numArray[1][2]);
		System.out.println("==============================================================");
		System.out.println("numArray.length = "+numArray.length);
		System.out.println("numArray[0].length = "+numArray[0].length);
		System.out.println("numArray[1].length = "+numArray[1].length);
		System.out.println("==============================================================");
		//2차원 배열에 존재하는 1차원 배열(행)을 일괄처리하기 위한 반복문
		for(int i=0;i<numArray.length;i++) {
			//1차원 배열에 존재하는 요소(열)을 일괄처리하기 위한 반복문
			for(int j=0;j<numArray[i].length;j++) {
				System.out.print(numArray[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println("==============================================================");
		//int[][] suArray=new int[][] {{10,20,30},{40,50,60},{70,80,90}};
		int[][] suArray={{10,20,30},{40,50,60},{70,80,90}};
		
		//2차원 배열에 존재하는 1차원 배열을 하나씩 제공받아 참조변수에 저장
		for(int[] array : suArray) {
			//1차원 배열에 존재하는 요소값을 하나씩 제공받아 정수형 변수에 저장
			for(int number : array) {
				System.out.print(number+"\t");
			}
			System.out.println();
		}
		System.out.println("==============================================================");
		//1차원 배열의 요소의 갯수가 선언되지 않은 2차원 배열 생성 - 1차원 배열 미생성
		// => 2차원 배열에 1차원 배열의 메모리 주소를 저장할 수 있는 요소만 생성되며 null 저장
		int[][] valueArray=new int[3][];
		
		System.out.println("valueArray = "+valueArray);
		System.out.println("valueArray[0] = "+valueArray[0]);
		System.out.println("valueArray[1] = "+valueArray[1]);
		System.out.println("valueArray[2] = "+valueArray[2]);
		System.out.println("==============================================================");
		//1차원 배열을 생성하여 2차원 배열의 요소에 저장
		// => 1차원 배열의 요소의 갯수가 다른 2차원 배열 - 가변 배열
		valueArray[0]=new int[3];
		valueArray[1]=new int[2];
		valueArray[2]=new int[4];

		System.out.println("valueArray[0] = "+valueArray[0]);
		System.out.println("valueArray[1] = "+valueArray[1]);
		System.out.println("valueArray[2] = "+valueArray[2]);
		System.out.println("==============================================================");
		int[][] doubleArray={{10,20,30},{40,50},{60,70,80,90}};//가변배열
		
		for(int[] array : doubleArray) {
			//1차원 배열에 존재하는 요소값을 하나씩 제공받아 정수형 변수에 저장
			for(int number : array) {
				System.out.print(number+"\t");
			}
			System.out.println();
		}
		System.out.println("==============================================================");
	}
}