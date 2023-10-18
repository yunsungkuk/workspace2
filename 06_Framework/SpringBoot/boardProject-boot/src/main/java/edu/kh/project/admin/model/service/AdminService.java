package edu.kh.project.admin.model.service;

import edu.kh.project.member.model.dto.Member;

public interface AdminService {

	/** 회원 정보 조회
	 * @param inputEmail
	 * @return searchMember
	 */
	Member selectMember(String inputEmail);

}
