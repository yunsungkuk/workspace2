package edu.kh.operator.practice;

import java.nio.file.spi.FileSystemProvider;
/* 키보드로 입력 받은정수가 양수이면 “양수“, 양수가 아니면 “양수 아님“를 출력하세요.

[실행화면]
정수 입력 : -9
양수 아님

 */
import java.util.Scanner;
public class practice2 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("[실행화면]");
		
		System.out.println("정수 입력 : ");
		int input1 = sc.nextInt();
		
		String result = input1 > 0 ? "양수" : "양수아님";
		System.out.println(result);
		
		
	}

}
