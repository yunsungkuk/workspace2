package edu.kh.oop복습.pack1;

public class PersonServiceRun {
	public static void main(String[] args) {
		
		PersonService service = new PersonService(); // 기본 생성자
		
		// PersonService 객체에 생성자로 초기화된 title을 얻어와 출력
		String title = service.getTitle();
		System.out.println(title);
		
		// PersonService의 ceratrePerson을 이용해서
		// Person 객체를 생성하여 반환 받기
		Person p1 = service.createPerson();
		            // 생성된 person 객체의 주소를 반환 받음
		
		
	}

}
