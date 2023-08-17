package tset;

import java.util.Scanner;

public class tset {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("2 ~ 9 사이 정수 입력 : ");
			int input = sc.nextInt();
			
			if(input <= 9 && input > 1) {
				for(int num = 1 ; num <= 9 ; num++) {
					int ex1 = input * num;
					System.out.printf("%d * %d = %d \n", input, num, ex1);
				}
			} else {
				System.out.println("2이상 9이하의 정수만 입력해주세요.");
			}
				
		}
	}

}
