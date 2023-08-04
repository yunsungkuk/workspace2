package edu.kh.operator.ex;

public class OperatorEx5 {
	
	public static void main(String[] args) {
		
		
		// AND 연산자 (&&)
		// - 둘 다 true이면 true, 나머진 false
		// - ~와, 그리고(이고), 이면서(면서), 부터, 까지, 사이
		
		// 104는 100 이상이면서 짝수인가?
		boolean result1 = (104 >= 100)  &&   (104 % 2 == 0);
		System.out.println("104는 100 이상이면서 짝수인가?" + result1 ); //true
		
		int Num2 = 50;
		boolean result2 = (Num2 <= 50 ) && (Num2 % 3 == 0);
		System.out.println("Num2는 50 이하이고 3의 배수인가?" + result2 ); //false
		
		int Num3 = 67;
		
		//1 <= Num3 <= 100
		boolean result3 = (Num3 >= 1) && (Num3 <= 100);
		System.out.println("Num3는 1부터 100사이의 정수인가?" + result3 ); // true
		
		
		// --------------------------------------------------------------------
		
		
		
		// OR 연산자 (||) : 둘다 false이면 false, 아니면 true
		// - 또는, ~이거나(거나)
		
		int Num4 = 20;
		boolean result4 = (Num4 > 10) || (Num4 % 2 == 1);
		
		System.out.println("Num4는 10을 초과하거나 홀수인가" + result4 ); //true
		
		int Num5 = 51;
		boolean result5 = (Num5 >= 0 && Num5 <= 50) || (Num5 < 0) ;
		
		System.out.println("Num5는 0이상 50이하의 수 또는 음수인가?" + result5); //false
		
		
		// ----------------------------------------------------------------------------------
		
		
		//논리 부정(NOT) 연산자 (!)
		// - 논리 값을 반대로 바꾸는 연산자
		
		
		System.out.println(!true); //false
		System.out.println(!false); //true
		
		int Num6 = 11;
		boolean result6 = Num6 % 2 == 0 ; //짝수판별
		
		System.out.println("Num6는 짝수?" + result6);
		System.out.println("Num6는 홀수?" + !result6);
		
		int Num7 = 30;
		boolean result7 = (Num7 >= 1 && Num7 <= 50) && !(Num7 % 5 == 0) ;
		
		System.out.println("Num7는 1부터 50사이 정수이면서 5의 배수가 아닌 수?" + result7 );
		
		
		
		
	}

}
