package edu.kh.jdbc.run;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCExample3 {
	public static void main(String[] args) {
		
		// 입력 받은 최소급여 보다 많이 받고 (이상)
		// 입력 받은 최고급여 보단 많이 받는 (이하)
		// 사원의 사번, 이름, 급여를 급여 내림차순 조회
		
		// [실행화면]
		// 최소급여 : 1000000
		// 최대급여 : 3000000
		
		// (사번) / (이름) / (급여)
		// (사번) / (이름) / (급여)
		// (사번) / (이름) / (급여)
		
		// 1. JDBC 객체 참조 변수 선언
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			// 2-1) Oracle JDBC Driver 객체를 메모리에 로드(적재) 하기
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2-2) DB 연결 정보를 이용해서 Connection 객체 생성
			String type = "jdbc:oracle:thin:@"; 
			String host = "115.90.212.20"; 
			String port = ":10000"; 
			String dbName = ":ORCL"; 
			String userName = "a230724_ysk"; 
			String pw = "dbstjdrnr1!"; 

			conn = DriverManager.getConnection(type + host + port + dbName , userName , pw);
			
			// 3. SQL 작성
			// 단, 마지막 세미콜론(;)은 제외
			Scanner sc = new Scanner(System.in);
			
			System.err.print("최소급여 : ");
			int input1 = sc.nextInt();
			
			System.out.print("최대급여 : ");
			int input2 = sc.nextInt();
			
			String sql = "SELECT EMP_ID, EMP_NAME, SALARY\r\n"
					+ "FROM EMPLOYEE\r\n"
					+ "WHERE SALARY >= "+input1+"\r\n"
					+ "AND SALARY <= "+input2+"\r\n"
					+ "ORDER BY SALARY DESC";
			
			// 4. Statement 객체 생성
			stmt = conn.createStatement();
			
			// 5. Statement 객체를 이용해서 SQL 수행 후 결과 반환 받기
			// (SELECT 수행하면 ResultSet 반환...!)
			rs = stmt.executeQuery(sql);
			
			// 6. SQL(SELECT) 결과가 담겨있는 ResultSet(rs)를
			//	  한 행씩 반복 접근하며 각 행의 컬럼 값을 얻어와 출력
			while (rs.next()) {
				
				String empId = rs.getString("EMP_ID");
				String empName = rs.getString("EMP_NAME");
				int salary = rs.getInt("SALARY");
				
				System.out.printf("%s / %s / %d \n", empId, empName, salary);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			// 7. JDBC 객체 자원 반환 (역순)
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
