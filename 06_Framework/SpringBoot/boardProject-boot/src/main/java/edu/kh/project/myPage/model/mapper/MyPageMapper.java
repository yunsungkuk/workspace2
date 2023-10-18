package edu.kh.project.myPage.model.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import edu.kh.project.member.model.dto.Member;

@Mapper
public interface MyPageMapper {

	int info(Member updateMember);

	/** 회원 비밀번호(암호화) 조회
	 * @param memberNo
	 * @return
	 */
	String selectChangePw(int memberNo);

	/** 비밀번호 변경
	 * @param map
	 * @return
	 */
	int changePw(Map<String, Object> map);

	/** 회원 탈퇴
	 * @param memberNo
	 * @return
	 */
	int secession(int memberNo);


	
	

}
