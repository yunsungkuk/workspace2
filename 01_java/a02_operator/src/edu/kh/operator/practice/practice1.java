package edu.kh.operator.practice;
import java.util.Scanner;
/*
 * 모든 사람이 사탕을 골고루 나눠가지려고 한다. 인원 수와 사탕 개수를 키보드로 입력 받고
1인당 동일하게 나눠가진 사탕 개수와 나눠주고 남은 사탕의 개수를 출력하세요.

[실행화면]
인원 수 : 29
사탕 개수 : 100
1인당 사탕 개수 : 3
남는 사탕 개수 : 13
 */


public class practice1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("[실행화면]");
		
		System.out.print("모든 사람이 사탕을 골고루 나눠가지려고 한다. 인원 수와 사탕 개수를 키보드로 입력 받고"
				+ "1인당 동일하게 나눠가진 사탕 개수와 나눠주고 남은 사탕의 개수를 출력하세요.");
		
		System.out.println();
		
		System.out.println("인원 수 : ");
		int input1 = sc.nextInt();
		
		System.out.println("사탕 개수 : ");
		int input2 = sc.nextInt();
		
		int result1 = (input2 / input1) ;
		System.out.println("1인당 사탕 개수 : " + result1 );
		
		int result2 = (input2 % input1 );
		System.out.println("남은 사탕 개수 : " + result2);
		
		System.out.printf("1인당 사탕 개수 : %d \n", input2 / input1);
		System.out.printf("남는 사탕 개수 : %d \n", input2 % input1);
		
		
		
		
		
		
		
		
		
	}

}
