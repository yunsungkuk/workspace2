package edu.kh.test.model.service;

import static edu.kh.test.common.JDBCTemplate.*;

import java.sql.Connection;

import edu.kh.test.model.dao.ShopDAO;
import edu.kh.test.model.dto.ShopMember;

public class ShopService {

	private ShopDAO dao = new ShopDAO();

	public int insertMember(ShopMember sm) {
		
		Connection conn = getConnection();
		
		int result = dao.insertMember(conn, sm);
		
		if(result > 0) commit(conn);
		else 		rollback(conn);
		
		close(conn);
		
		return result;
	}
	
	
	
}
