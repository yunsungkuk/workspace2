package edu.kh.inheritance.model.dto;
      // 상속 불가			// 
public /*final*/ class Parent extends Object {
						// 미작성 시 컴파일러가 추가
	private int money = 100_000_000; // 1억
	private String lastName = "홍";
	
	// 생성자
	public Parent() {
		System.out.println("parent() 기본 생성자로 부모 객체 생성");
	}
	
	public Parent(int monet, String lastName) {
		System.out.println("Parent(int, String) 매개변수 생성자로 부모 객체 생성");
		
		this.money = money;
		this.lastName = lastName;
	}
		
		// gettor , settor
		     //오버라이딩 불가
		public /* final */ int getMoney () {
			return money;
		}
		public void setMoney(int money) {
			this.money = money;
		}
		public String getLastName () {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		// toString() : 객체의 필드를 하나의 문자열로 반환
		@Override // Object의 toString() 오버라이딩
		public String toString() {
		//   상속받은 Parent의 메서드를 자식이 자신의 것 처럼 사용 가능
//				getMoney();
//				getLastName();
				
				return money + "/" + lastName;
		}
		
	
}

// final 자료형 변수명; -> 상수
// public final class 클래스명 -> 상속 불가
// public final void 메서드명() -> 오버라이딩 불가


