-- 시퀀스 생성
CREATE SEQUENCE SEQ_MEMBER_NO NOCACHE; -- 회원번호
CREATE SEQUENCE SEQ_BOARD_NO NOCACHE; -- 게시글번호
CREATE SEQUENCE SEQ_COMMENT_NO NOCACHE; -- 댓글번호

-- MEMBER 테이블에 INSERT하기
INSERT INTO MEMBER
VALUES(SEQ_MEMBER_NO.NEXTVAL, 
	  'dbs1128218@naver.com', 
	  '123123', 
	  'dbs6312', 
	  '01056764826', 
	  '서울시', 
	  DEFAULT, DEFAULT)
;

COMMIT;

-- 이메일, 비밀번호가 일치하는 회원의
-- 닉네임, 전화번호, 주소 수정
UPDATE MEMBER
SET MEMBER_NICKNAME = '변경된 닉네임',
	MEMBER_TEL = '00002222113',
	MEMBER_ADDRESS = '부산'
WHERE MEMBER_EMAIL = 'dbs1128218@naver.com'
AND MEMBER_PW = '123123'
;

ROLLBACK;

-- 		이메일, 비밀번호가 일치하는 회원 탈퇴(DELETE)
--		이메일, 비밀번호 일치 -> 탈퇴 성공
--		불일치 -> 이메일 또는 비밀번호 불일치

DELETE FROM MEMBER
WHERE MEMBER_EMAIL = 'test'
AND MEMBER_PW = '123'
;

ROLLBACK;

SELECT *
FROM MEMBER;
