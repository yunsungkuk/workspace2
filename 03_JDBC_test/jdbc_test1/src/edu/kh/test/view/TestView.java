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
		
		ShopMember shopMember = service.selectMember(memberId);
		
		if (shopMember == null) {
			System.out.println("조회되지 않는 아이디입니다.");
		} else {
			System.out.println("해당 회원정보가 조회되었습니다");
		}
		
	}
	
	
}


