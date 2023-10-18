package edu.kh.project.myPage.model.service;

import edu.kh.project.member.model.dto.Member;

public interface MyPageService {

	/** 회원 정보 수정
	 * @param updateMember
	 * @param memberAddress
	 * @return result
	 */
	int info(Member updateMember, String[] memberAddress);

	/** 회원 비밀번호 수정
	 * @param memberNo
	 * @param currentPw
	 * @param newPw
	 * @return
	 */
	int changePw(int memberNo, String currentPw, String newPw);

	/** 회원 탈퇴 서비스
	 * @param currentPw
	 * @param memberNo
	 * @return
	 */
	int secession(String memberPw, int memberNo);

}
