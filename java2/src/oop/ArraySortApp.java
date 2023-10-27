package oop;

import java.util.Arrays;

//OOP(Object Oriented Programming) : 객체 지향 프로그래밍
// => 객체를 사용하여 프로그램을 개발하는 방법
// => 현실에 존재하는 대상을 모델링하여 클래스로 선언하고 클래스로 객체를 생성하여 객체 요소로 프로그램 작성
// => 추상화, 캡슐화, 다형성, 상속성

//객체 모델링(Object Modeling) : 현실에 존재하는 대상을 속성(값)과 행위(기능)로 구분하여 설계
// => 모델링된 대상을 클래스(속성 : 필드, 행위 : 메소드)로 선언 - 추상화(Abstraction)
// => 클래스는 배포 가능 : 프로그램의 생산성 증가 및 유지보수의 효율성 증가

//배열에 저장된 요소값을 오름차순 정렬하여 출력하는 프로그램 작성
public class ArraySortApp {
	public static void main(String[] args) {
		/*
		int[] array={30,50,10,20,40};
		
		System.out.print("정렬 전 >> ");
		for(int number : array) {
			System.out.print(number+" ");
		}
		System.out.println();
		
		for(int i=0;i<array.length-1;i++) {
			for(int j=i+1;j<array.length;j++) {
				if(array[i] > array[j]) {
					int temp=array[i];
					array[i]=array[j];
					array[j]=temp;
				}
			}
		}
		
		System.out.print("정렬 후 >> ");
		for(int number : array) {
			System.out.print(number+" ");
		}
		System.out.println();
		*/
		
		int[] array={30,50,10,20,40};
		
		//Arrays 클래스 : 배열 요소값을 제어하는 기능의 메소드를 제공하는 클래스
		//Arrays.toString(Object[] array) : 메소드의 매개변수로 배열을 전달받아 배열의 모든
		//요소값들을 문자열로 변환하여 반환하는 메소드
		System.out.println("정렬 전 >> "+Arrays.toString(array));
		
		//Arrays.sort(Object[] array) : 메소드의 매개변수로 배열을 전달받아 배열의 모든 
		//요소값들을 오름차순 정렬하는 기능을 제공하는 메소드
		Arrays.sort(array);

		System.out.println("정렬 후 >> "+Arrays.toString(array));
	}
}
