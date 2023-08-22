package edu.kh.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class test {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		List<String> nameList = new ArrayList<String> ();
		
		while(true) {
			System.out.print("추가할 이름을 입력하세요 : ");
			String name = sc.next();
			
			if(name.equals("clear")) {
				System.out.println("이름 목록을 초기화 합니다.");
				nameList.clear();
				continue;
			}
			
			if(name.equals("exit")) {
				System.out.println("<<입력 종료>>");
				break;
			}
			
			if(nameList.contains(name)) {
				System.out.println("<이미 존재하는 이름입니다>");
			} else {
				
				System.out.println(name + "추가 완료.");
			}
		}
		for(String name : nameList) {
			nameList.add(name);
			System.out.println(name);
		}
	}

}
