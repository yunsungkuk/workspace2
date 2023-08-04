package edu.kh.array.practice;

public class ArrayPractice {
	
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

}
