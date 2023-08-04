package edu.kh.oop복습.pack1;

import java.util.Scanner;

// 프로그램 동작 기능 제공 클래스
// 여기서 Person에 입력되어있는 기본정보 들을 가지고 와서 출력하는 창임
public class PersonService {
	// 스캐너 작성 할때 private 추가로 넣고 작성하기
	private Scanner sc = new Scanner(System.in);
	
	// String 정보를 넣기위한 공간 작성
	// private 추가로 입력하기
	private String title;
	
	// 해당 패키지에 제목 입력하기
	// title에 "===== Person을 이용한 프로그램 (복습) ====="을 입력함
	public PersonService () {
		 title = "===== Person을 이용한 프로그램 (복습) =====";
	}
	
	// title에 프로그램 이름 작성 후 출력하고 다시 title안에 있는 내용 반환
	public String getTitle () { // 프로그램 이름 반환
		return title;
	}
	
	// 사람 객체를 생성해서 반환하는 메서드 작성
	// public (person창에 있는 내용을 가져옴)
	public Person createPerson() {
		System.out.println("=== Person 객체 생성하기 ===");
		
		System.out.print("이름 : ");
		String name = sc.next();
		
		System.out.println("나이 : ");
		int age = sc.nextInt();
		
		System.out.println("성별(남/여) : ");
		char gender = sc.next().charAt(0);
		// 입력된 문자열에서 0번 문자만 반환됨
		
		System.out.println("직업 : ");
		String job = sc.next();
		
		// Person 객체 생성 + 입력 받은 값으로 필드 초기화
		
		// 매개변수 생성자
		Person p = new Person(name, age, gender, job);
		
		// 끝나고 리턴까지 넣기
		return p;
		
		
	}
	
	// 매개변수로 전달 받은 Penson을 이용해서
	// 필드에 작성된 값을 하나의 문자열로 만들어서 반환
	public String personFeils(Person p) {
	
	// 홍길동 / 25세 / 남 / 군인
	
		String str = p.getName() + " / " + p.getAge() + " / " + p.getGender() + " / " + p.getJob();
	
		return str;
	}
	
}
