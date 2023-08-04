package edu.kh.array.practice;

public class ArrayPractice {
	// 실습문제 1
//	길이가 9인 배열을 선언 및 할당하고, 1부터 9까지의 값을 반복문을 이용하여
//	순서대로 배열의 각 인덱스 요소에 대입하고 출력한 후
//	짝수 번째 인덱스 값의 합을 출력하세요. (0 번째 인덱스는 짝수로 취급)
	public void practice1() {
		
		int sum = 0;
		
		int[] arr = new int[10];
		
		for (int row = 1 ; row < arr.length ; row++) {
			System.out.println(row + " ");
		}
		for (int col = 0 ; col < arr.length ; col += 2 ) {
			sum += col;
		}
		System.out.println("합계 : " + sum);
		
	}
	
	//실습 문제 2
//	길이가 9인 배열을 선언 및 할당하고, 9부터 1까지의 값을 반복문을 이용하여
//	순서대로 배열의 각 인덱스 요소에 대입하고 출력한 후
//	홀수 번째 인덱스 값의 합을 출력하세요. (0 번째 인덱스는 짝수로 취급)

	public void practice2() {
		
		int sum = 0;
		
		int[] arr = new int[10];
		
		for (int row = 1 ; row < arr.length ; row++) {
			System.out.println(row + " ");
		}
		for (int col = 1 ; col < arr.length ; col += 2 ) {
			sum += col;
		}
		System.out.println("합계 : " + sum);
	}
	
	
	
	
	
	
	
	
	
	
}