package edu.kh.jdbc.model;

import edu.kh.jdbc.model.dao.MemberDAO;
import edu.kh.jdbc.model.dto.Member;

public class MemberService {
	
	private MemberDAO dao = new MemberDAO();

	/** 회원 가입 서비스
	 * @param member
	 * @return
	 */
	public int insertMember(Member member) {
		// TODO Auto-generated method stub
		return 0;
	}

}
