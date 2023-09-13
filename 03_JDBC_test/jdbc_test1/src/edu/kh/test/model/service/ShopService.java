package edu.kh.test.model.service;

import static edu.kh.test.common.JDBCTemplate.*;

import java.sql.Connection;

import edu.kh.test.model.dao.ShopDAO;
import edu.kh.test.model.dto.ShopMember;

public class ShopService {
	private ShopDAO dao = new ShopDAO();

	
	public ShopMember selectMember(String memberId) {
		// 커넥션 생성
		Connection conn = getConnection();
		
		//  DAO로 호출 후 결과 반환
		ShopMember shopMember = dao.selectMember(conn, memberId);
		
		// DML(INSERT UPDATE DELETE)인 경우 트랜잭션 처리
		// -> SELECT은 안해도 된다 (PASS)
		
		// 커넥션 반환
		close(conn);
		
		// 결과 반환
		return shopMember;
	}




	public int insertMember(ShopMember shopmember) {
		// 커넥션 생성
		Connection conn = getConnection();
		// dao 파일 전달 후 반환된 값 받기
		int result = dao.insertMember(conn, shopmember);
		
		if (result > 0) commit(conn);
		else 			rollback(conn);
		
		close(conn);
		
		return result;
	}










	
	
	
}
