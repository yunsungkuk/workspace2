package edu.kh.operator.practice;
import java.util.Scanner;
/*
 * 나이를 키보드로 입력 받아 어린이(13세 이하)인지, 청소년(13세 초과 ~ 19세 이하)인지,
성인(19세 초과)인지 출력하세요.

ex.
나이 : 19
청소년
 */

public class practice4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("나이 : ");
		int input1 = sc.nextInt();
		
		
		String sesult1 = input1 <= 13  ? "어린이" : ( input1 > 19 ? "성인" : "청소년");
		System.out.println(input1);
		
		// input1이 15인 경우
		// 어린이를 찾는 조건 (input1 <= 13)을 만족하지 못하므로
		// 이후에는 input1가 13이하인 경우를 범위에서 제외하면 된다.
		
		//->청소년을 찾는 조건을 input1 <= 19 라고만 작성해도
		// 13이하를 제외하기 때문에
		// input1 > 13 && input1 <= 19 조건과 동일 조건이 성립한다.
		
	}

}
