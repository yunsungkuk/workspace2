package edu.kh.oop.field.pack2;

public class StudentRun {
	public static void main(String[] args) {
		
		// Student 객체 생성
		student s1 = new student();
		
		
		s1.grade = 3;
		s1.ban = 5;
		s1.number = 12;
		s1.name = "김길동";
		
		student s2 = new student();
		s2.grade = 1;
		s2.ban = 4;
		s2.number = 16;
		s2.name = "이길동";
		
		student s3 = new student();
		s3.grade = 6;
		s3.ban = 4;
		s3.number = 14;
		s3.name = "윤길동";
		
		// 프로그램 실행 중 학교명 변경 기능 추가
		
		System.out.println("------변경 전 학교명------");
		System.out.println(s1.schoolName);
		System.out.println(s2.schoolName);
		System.out.println(s3.schoolName);
		
		// 학교명 변경
//		s1.schoolName = "중구 국제 중학교";
//		s2.schoolName = "중구 국제 중학교";
//		s3.schoolName = "중구 국제 중학교";
		//학생이 천명이면 변경 코드를 천번 작성해야됨...
		
		// * schoolName 필드를 static으로 변경하면
		// 한 학생의 학교명만 변경해도 모두 바뀜
//		s1.schoolName = "중구 과학 중학교";
		
		// * static 붙은 필드를 다룰때는 클래스명.필드명 으로 작성을 권장!! *
		student.schoolName = "중구 외국어 중학교";
		
		System.out.println("------변경 후 학교명------");
		System.out.println(s1.schoolName);
		System.out.println(s2.schoolName);
		System.out.println(s3.schoolName);
		
	}

}
