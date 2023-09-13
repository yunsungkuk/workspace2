package edu.kh.test.model.dao;

import static edu.kh.test.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.kh.test.model.dto.ShopMember;

public class ShopDAO {

	private PreparedStatement pstmt = null;

	public int insertMember(Connection conn, ShopMember sm) {
		
		int result = 0;
		
		try {
			
			String sql = "INSERT INTO SHOP_MEMBER\r\n"
					+ "VALUES ( ?, ?, ?, ? )";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, sm.getMemberId());
			pstmt.setString(2, sm.getMemberPw());
			pstmt.setString(3, sm.getPhone());
			pstmt.setString(4, sm.getGender());
			
			result = pstmt.executeUpdate();
			
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}


	
	

}



