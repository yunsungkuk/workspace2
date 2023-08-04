package edu.kh.operator.practice;
/*
 * 국어, 영어, 수학에 대한 점수를 키보드를 이용해 정수로 입력 받고,
세 과목에 대한 합계(국어+영어+수학)와 평균(합계/3.0)을 구하세요.
세 과목의 점수와 평균을 가지고 합격 여부를 처리하는데
세 과목 점수가 각각 40점 이상이면서 평균이 60점 이상일 때 합격, 아니라면 불합격을 출력하세요.

ex.
국어 : 60
영어 : 80
수학 : 40
합계 : 180
평균 : 60.0
합격
 */

import java.util.Scanner;

public class practice5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("국어 : ");
		int input1 = sc.nextInt();
		
		System.out.println("영어 : ");
		int input2 = sc.nextInt();
		
		System.out.println("수학 : ");
		int input3 = sc.nextInt();
		
		
		int result1 = input1 + input2 + input3 ;
		System.out.println("합계 : " + result1);
		
		int result2 = result1 / 3;
		System.out.println("평균 : " + (double)result2);
		
		
		String result3 = (input1 >= 40) && (input2 >= 40) && (input3 >= 40) && (result2 >= 60) ? "합격" : "불합격";
		System.out.println(result3);
		
		
		
		
		
	}

}
