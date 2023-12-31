package edu.kh.jdbc.model.service;

//    static 필드/메서드 호출 시 클래스명(JDBCTemplate) 생략
import static edu.kh.jdbc.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import edu.kh.jdbc.model.dao.ProjectDAO;
import edu.kh.jdbc.model.dto.Board;
import edu.kh.jdbc.model.dto.Member;

public class ProjectService {
	
	private ProjectDAO dao = new ProjectDAO();
	
	

	/** 회원 가입
	 * @param member
	 * @return
	 */
	public int insertMember(Member member) {
		
		// 1. 커넥션 생성
		Connection conn = getConnection();
		
		// 2. DAO 메서드 호출(Connection, 매개 변수 전달)
		int result = dao.insertMember(conn, member);
		
		// 3. 트랜잭션 제어
		if (result > 0) commit(conn);
		else			rollback(conn);
		
		// 4. 커넥션 반환
		close(conn);
		
		// 5. 결과를 view로 반환
		return result;
	}

	
	/**
	 * 로그인
	 */
	public Member login(String email, String pw) {
		// 1. 커넥션 생성
		Connection conn = getConnection();
		
		// 2. DAO 메서드 호출
//		Member member = dao.login(conn, email, pw); // PreparedStatement
		
		Member member = dao.login2(conn, email, pw); // Statement
		
		
		// SELECT는 트랜잭션 제어 처리가 필요 없음 -> 건너 뜀
		
		// 3. 커넥션 반환
		close(conn);
		
		// 4. view로 결과 반환
		return member;
	}
	
	
	
	/** 회원 전체 조회
	 * @param sort
	 * @return
	 */
	public List<Member> selectAllMember(int sort) {
		
		
		// 1. 커넥션 생성
		Connection conn = getConnection();
		
		// 2. DAO 메서드 호출
		List<Member> memberList = dao.selectAllMember(conn, sort);
		
		// 3. 커넥션 반환
		close(conn);
		
		// 4. view로 결과 반환
		return memberList;
	}


	/** 회원 정보 수정
	 * @param nick
	 * @param tel
	 * @param memberNo
	 * @return
	 */
	public int updateMember(String nick, String tel, int memberNo) {
		
		// 1. 커넥션 생성
		Connection conn = getConnection();
		
		// 2. DAO 메서드 호출
		int result = dao.updateMember(conn, nick, tel, memberNo);
		
		// 3. 트랜잭션 제어
		if(result > 0) commit(conn);
		else		   rollback(conn);
		
		// 4. 커넥션 반환
		close(conn);
		
		// 5. view로 결과 반환
		return result;
	}


	/** 회원 탈퇴
	 * @param memberNo
	 * @param pw
	 * @return
	 */
	public int updateDelFl(int memberNo, String pw) {
		
		// 1. 커넥션 생성
		Connection conn = getConnection();
		
		// 2. DAO 메서드 호출
		int result = dao.updateDelFl(conn, memberNo, pw);
		
		// 3. 트랜잭션 제어
		if(result > 0) commit(conn);
		else		   rollback(conn);
		
		// 4. 커넥션 반환
		close(conn);
		
		// 5. view로 결과 반환
		return result;
	}


	/** 게시글 작성
	 * @param title
	 * @param content
	 * @param memberNo
	 * @return
	 */
	public int insertBoard(String title, String content, int memberNo) {
		
		// 커넥션 생성
		Connection conn = getConnection();
		// DAO 메서드 호출
		int result = dao.insertBoard(conn, title, content, memberNo);
		// 트랜잭션 제어
		if (result < 0) commit(conn);
		else			rollback(conn);
		// 커넥션 반환
		close(conn);
		// view로 반환
		return result;
	}


	/** 게시글 목록 조회
	 * @param input
	 * @return
	 */
	public List<Board> selectBoardList(int input) {
		
		Connection conn = getConnection();
		
		List<Board> board = dao.selectBoardList(conn, input);
		
		close(conn);
		
		return board;
	}


	/** 게시글 상세 조회
	 * @param boardNo
	 * @return
	 */
	public Board selectBoard(int boardNo) {
		
		// Connection 생성
		Connection conn = getConnection();
		
		// 1) DAO - 게시글 상세 조회 메서드 호출
		Board board = dao.selectBoard(conn, boardNo);
		
		
		
		// 2) 게시글 상세 조회 결과가 있을 경우 
		// -> 조회수 증가(incrementReadCount(게시글 번호)) 수행
		if (board != null) {
			
			int result = dao.incrementReadCount(conn, boardNo);
			
			// 트랜잭션 처리
			if (result > 0) {
				commit(conn);
				// DB와 데이터 동기화
				// (DB에서만 조회수가 1 증가하기 때문에
				// 조회해둔 board에도 조회수 1을 증가시킨다.
				board.setReadCount(board.getReadCount() + 1);
			} else rollback(conn);
		}
		close(conn);
		
		return board;
	}


	/** 작성자 확인
	 * @param boardNo
	 * @param memberNo
	 * @return check
	 */
	public int writerCheck(int boardNo, int memberNo) {
		Connection conn = getConnection();
		int check = dao.writerCheck(conn, boardNo, memberNo);
		close(conn);
		return check;
	}



	/** 게시글 삭제
	 * @param boardNo
	 * @return result
	 */
	public int deleteBoard(int boardNo) {
		Connection conn = getConnection();
		int result = dao.deleteBoard(conn, boardNo);
		
		if(result > 0)	commit(conn);
		else 			rollback(conn);
		
		close(conn);
		return result;
	}



	/** 게시글 수정
	 * @param title
	 * @param content
	 * @param boardNo
	 * @return
	 */
	public int updateBoard(String title, String content, int boardNo) {
		Connection conn = getConnection();
		int result = dao.updateBoard(conn, title, content, boardNo);
		
		if(result > 0)	commit(conn);
		else 			rollback(conn);
		
		close(conn);
		return result;
	}
	
	
	
	
	
	
	
	
	
}
