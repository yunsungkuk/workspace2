package edu.kh.project.myPage.model.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.kh.project.member.model.dto.Member;
import edu.kh.project.myPage.model.mapper.MyPageMapper;

@Transactional
@Service
public class MyPageServiceImpl implements MyPageService {

	@Autowired
	private MyPageMapper mapper;
	
	@Autowired
	private BCryptPasswordEncoder bcrypt;
	
	@Override
	public int info(Member updateMember, String[] memberAddress) {
		
		// 주소 가공
		// 주소가 입력되지 않은 경우
		if(updateMember.getMemberAddress().equals(",,")) {
			updateMember.setMemberAddress(null); // null로 변환
		} else { // 주소를 입력한 경우
			// 배열 -> 문자열로 합쳐서 inputMember에 추가
			String address = String.join("^^^", memberAddress);
			updateMember.setMemberAddress(address);
		}
		
		// mapper 호출 후 결과 반환
		return mapper.info(updateMember);
	}
	
	// 
	@Transactional(rollbackFor = Exception.class)
	@Override
	public int changePw(int memberNo, String currentPw, String newPw) {
		
		// 1. 로그인한 회원의 비밀번호(암호화) 조회
		// DB에 있는 비밀번호 조회
		String encPw = mapper.selectChangePw(memberNo);
		
		// 2. 현재 비밀번호와 DB에 있는 비밀번호가 일치하는지 확인
		// bcrypt.matches(평문, 암호문) 사용
		if(!bcrypt.matches(currentPw, encPw)) {
			// 현재 비밀번호와 DB에 있는 비밀번호가 일치하지 않다면
			return 0;
		}
		
		// 3. 일치 한다면 새 비밀번호 암호화 후 새 비밀번호 수정값 리턴
		// (주의사항) 마이바티스 코드의 파라미터는 1개만 가능!
		// -> 지금 newPw, memberNo 두개가 필요
		// --> 하나로 묶어서 해결! (Map, DTO)
		Map<String, Object> map = new HashMap<>();
		map.put("newPw", bcrypt.encode(newPw));
		map.put("memberNo", memberNo);
		
		
		return mapper.changePw(map);
	}
	
	@Override
	public int secession(String memberPw, int memberNo) {
		
		// 로그인한 회원의 암호화된 비밀번호 조회
		String encPw = mapper.selectChangePw(memberNo);
		
		if(!bcrypt.matches(memberPw, encPw)) {
			// 현재 비밀번호와 DB에 있는 비밀번호가 일치하지 않다면
			return 0;
		}
		
		// 탈퇴 처리 SQL 수행
		return mapper.secession(memberNo);
	}
	
}
