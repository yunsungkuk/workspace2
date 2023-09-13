package edu.kh.test.view;

import java.util.Scanner;

import edu.kh.test.model.dto.ShopMember;
import edu.kh.test.model.service.ShopService;

public class TestView {
	
	private Scanner sc = new Scanner(System.in);
	private ShopService service = new ShopService();
	
	
	public void selectMember() {
		System.out.print("ID 입력 : ");
		String memberId = sc.next();
		
		// 서비스 호출 후 결과 반환
		ShopMember shopMember = service.selectMember(memberId);
		System.out.println(shopMember);
		if (shopMember == null) {
			System.out.println("조회되지 않는 아이디입니다.");
		} else {
			System.out.println("해당 회원정보가 조회되었습니다");
		}	
	}
	
	public void insertMember() {
		System.out.println("\n***** 회원 가입 *****\n");
		
		// 정보 입력
		System.out.print("아이디 입력 : ");
		String id = sc.next();
		System.out.print("비밀번호 입력 : ");
		String pw = sc.next();
		System.out.print("휴대폰 번호 입력 : ");
		String ph = sc.next();
		System.out.print("성별 M/F : ");
		String mf = sc.next();
		sc.nextLine();
		
		// 입력한 정보 모아두는 객체 생성
		ShopMember shopmember = new ShopMember(id, pw, ph, mf);
		
		// 서비스로 member 전달 후 수행결과 반납받기
		int result = service.insertMember(shopmember);
		
		// 가입 성공 실패 if문
		if(result > 0) {
			System.out.println("회원 가입 성공!!");
		} else {
			System.out.println("회원 가입 실패...");
		}
			
		
		
		
	}

}