package edu.kh.oop복습.pack1;

public class Person {
	
	//필드 (캡슐화 원칙) (기본 정보 private로 만들기)
	private String name;
	private int age;
	private char gender;
	private String job;
	
	// 기본 생성자 << (), {}가 빈것을 뜻함 (해당 패키지 이름을 넣음)
	public Person() {}
	
	// 매개변수 생성자 ()안에 필드에 만든 기본정보 넣고
	// {}안에 this.기본정보 = 기본정보; 입력 this는 함수 실행 시 
	// 해당 객체의 주소를 자동으로 전달하기 위해 쓰임
	public Person(String name, int age, char gender, String job) {
		
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.job = job;
	}
	
	// 메서드 (method) : 객체의 기능
	
	// [작성법]
	// [접근제한자][예약어]반환형 메서드형 ( [매개변수] {}
	
	// name 필드에 전달 받은 값을 세팅하는 메서드
	// void : 메서드 수행 후 돌려 보내주는 결과가 없음
	
	// 필드 캡슐화, 기본 생성자, 매개변수 생성자 완료 후
	// 각 필드(기본정보)를 settor,gettor 작성하기
	
	// settor 문장 작성시 set(기본정보) 앞에 대문자로 영어 쓰기
	// ()안에 기본정보 작성 후 주소 자동전달을 위해 쓰인 this가져오기
	// this는 {}안에 넣기 이후 return까지 완료하기
	// void인 메서드는 return을 작성하지 않아도 컴파일러가 자동으로 추가함
	
	// name settor,gettor 작성
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
	
	// age settor, gettor 작성
	public void setAge(int age) {
		this.age = age;
	}
	public int getAge() {
		return this.age;
	}
	
	// gander settor,gettor 작성
	public void setGender(char gender) {
		this.gender = gender;
	}
	public char getGender() {
		return this.gender;
	}
	
	// job settor, gettor 작성
	public void setJob(String job) {
		this.job = job;
	}
	public String getJob() {
		return this.job;
	}
	
	
	
	
	
	
	
}
