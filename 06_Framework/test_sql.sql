CREATE TABLE MEMBERTEST(
	"MEMBER_NO_TEST" NUMBER CONSTRAINT MEMBER_PKTEST PRIMARY KEY,
	"MEMBER_EMAIL_TEST" VARCHAR2(50) NOT NULL,
	"MEMBER_PW_TEST" VARCHAR2(100) NOT NULL,
	"MEMBER_NICKNAME_TEST" VARCHAR2(50) NOT NULL,
	"MEMBER_TEL_TEST" CHAR(11) NOT NULL,
	"MEMBER_DEL_FL_TEST" CHAR(1) DEFAULT 'N'
		CHECK ("MEMBER_DEL_FL_TEST" IN ('Y', 'N')),
	"AUTHORITY_TEST" NUMBER DEFAULT 1 CHECK ("AUTHORITY_TEST" IN (1,2)));


COMMENT ON COLUMN "MEMBERTEST"."MEMBER_NO_TEST" 		IS '회원 번호(SEQ_MEMBER_NO_TEST)';
COMMENT ON COLUMN "MEMBERTEST"."MEMBER_EMAIL_TEST" 		IS '회원 이메일(ID 역할)';
COMMENT ON COLUMN "MEMBERTEST"."MEMBER_PW_TEST" 		IS '회원 비밀번호';
COMMENT ON COLUMN "MEMBERTEST"."MEMBER_NICKNAME_TEST" 	IS '회원 닉네임';
COMMENT ON COLUMN "MEMBERTEST"."MEMBER_TEL_TEST" 		IS '회원 전화번호';
COMMENT ON COLUMN "MEMBERTEST"."MEMBER_DEL_FL_TEST" 	IS '탈퇴 여부(Y:탈퇴, N:정상)';
COMMENT ON COLUMN "MEMBERTEST"."AUTHORITY_TEST" 		IS '권한(1:일반, 2:관리자)';


-- 시퀀스 생성(일련번호 만들기)
CREATE SEQUENCE SEQ_MEMBER_NO_TEST NOCACHE;

-- 샘플 계정 추가
INSERT INTO "MEMBERTEST"
VALUES (SEQ_MEMBER_NO_TEST.NEXTVAL , 'membertest01@naver.com' , 'pass01' , '회원1',
		'01011112222' , DEFAULT , DEFAULT);

COMMIT;

SELECT * FROM MEMBERTEST;
	