package edu.kh.test.run;

import edu.kh.test.view.TestView;

public class TestRun {
	public static void main(String[] args) {
		
		// 뷰 생성
		TestView view = new TestView();
		// 뷰 출력
//		view.selectMember();
		view.insertMember();
	}
}
