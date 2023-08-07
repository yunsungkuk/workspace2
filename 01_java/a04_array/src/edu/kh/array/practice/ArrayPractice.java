package edu.kh.array.practice;

import java.util.Scanner;

public class ArrayPractice {
	
	// 실습 문제 1
//	길이가 9인 배열을 선언 및 할당하고, 1부터 9까지의 값을 반복문을 이용하여
//	순서대로 배열의 각 인덱스 요소에 대입하고 출력한 후
//	짝수 번째 인덱스 값의 합을 출력하세요. (0 번째 인덱스는 짝수로 취급)
	public void practice1() {
		
		int sum = 0;
		
		int[] arr = new int[9];
		
		for (int row = 1 ; row <= arr.length ; row++ ) {
			System.out.println(row);
		}
		for (int col = 0 ; col < arr.length ; col+=2) {
			sum += col;
		}
		System.out.println("합계 : " + sum);
		}

		
	
	// 실습 문제 2
//	길이가 9인 배열을 선언 및 할당하고, 9부터 1까지의 값을 반복문을 이용하여
//	순서대로 배열의 각 인덱스 요소에 대입하고 출력한 후
//	홀수 번째 인덱스 값의 합을 출력하세요. (0 번째 인덱스는 짝수로 취급)
	
	public void practice2 () {
		
		int sum = 0;
		
		int[] arr = new int[9];
		
		for (int row = arr.length ; row > 0  ; row--) {
			System.out.println(row);
		}
		for (int col = 1 ; col <= arr.length ; col+=2) {
			sum += col;
		}
		System.out.println("합계 : " + sum);
		
	}
	
	
	// 실습 문제 3
//	사용자에게 입력 받은 양의 정수만큼 배열 크기를 할당하고
//	1부터 입력 받은 값까지 배열에 초기화한 후 출력하세요.
	
	public void practice3() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("정수를 입력하세요");
		int ex1 = sc.nextInt();
		
		int arr[] = new int[ex1];
		
		for (int row = 1 ; row <= arr.length ; row++) {
			System.out.println(row);
		}
	}
	
	// 실습 문제 4
//	정수 5개를 입력 받아 배열을 초기화 하고
//	검색할 정수를 하나 입력 받아 배열에서 같은 수가 있는 인덱스를 찾아 출력.
//	배열에 같은 수가 없을 경우 “일치하는 값이 존재하지 않습니다“ 출력
	
	public void practice4() {
		
		Scanner sc = new Scanner(System.in); 
		
		int[] arr = new int[5];

			
		for (int row = 0 ; row < arr.length ; row++) {
		System.out.println("입력" + (row));
		arr[row] = sc.nextInt();
		}
		while(true) {
			System.out.println("검색할 값");
			int input = sc.nextInt();
		
		if (input < 0 || input >= arr.length) {
			System.out.println("일치하는 값이 존재하지 않습니다");
			continue;
		}
			System.out.printf("입력 %d" + input);
		}
		
	}
	
	
	// 실습 문제 6
//	사용자가 배열의 길이를 직접 입력하여 그 값만큼 정수형 배열을 선언 및 할당하고
//	배열의 크기만큼 사용자가 직접 값을 입력하여 각각의 인덱스에 값을 초기화 하세요.
//	그리고 배열 전체 값을 나열하고 각 인덱스에 저장된 값들의 합을 출력하세요.
	
	public void practice6() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("정수 : ");
		int num = sc.nextInt();
		
		int[] arr = new int[num];
		
		for (int row = 0 ; row <= arr.length ; row++ ) {
			System.out.println("배열 %d번째 인덱스에 넣을 값 : ");
			arr[row] = sc.nextInt();
		}
	}
	

}
