테이블 생성 명령어
CREATE TABLE EMPLOYEE2 AS SELECT * FROM EMPLOYEE;
EMPLOYEE랑 똑같이 생긴 EMPLOYEE2라는 테이블을 만들겠다.

-- DML

1. INSERT -- 테이블에 새로운 행을 추가하는 구문

-- [작성법]
1) INSERT INTO 테이블명 VALUES(데이터, 데이터, ....) --> 모든 컬럼일때
INSERT하고자 하는 컬럼이 모든 컬럼인 경우 컬럼명 생략 가능
단, 컬럼의 순서를 지켜서 VALUES에 값을 기입해야함


2)  INSERT INTO 테이블명(컬럼명, 컬럼명, 컬럼명,...)
VALUES (데이터1, 데이터2, 데이터3, ...);
-- 테이블에 내가 선택한 컬럼에 대한 값만 INSERT할 때 사용
-- 선택안된 컬럼은 값이 NULL이 들어감


-- 모든 컬럼에 값을 부여
INSERT INTO EMPLOYEE2
-- VALUES (테이블 컬럼 순서대로 값을 작성)
VALUES (900, '장채현', '901123-2345678', 'jang_ch@kh.or.kr', '01012341234',
	'D1', 'J7', 'S3', 4300000, 0.2, 200, SYSDATE, NULL, 'N');

-- 처음 3가지 컬럼에 값을 부여
INSERT INTO DEPARTMENT2
VALUES ('D0', '개발부', 'L1');


-- 2)  INSERT INTO 테이블명(컬럼명, 컬럼명, 컬럼명,...)
-- VALUES (데이터1, 데이터2, 데이터3, ...);
-- 테이블에 내가 선택한 컬럼에 대한 값만 INSERT할 때 사용
-- 선택안된 컬럼은 값이 NULL이 들어감

INSERT INTO EMPLOYEE2 (EMP_NAME, EMP_ID, EMP_NO, EMAIL, PHONE, DEPT_CODE, JOB_CODE, SAL_LEVEL, SALARY)
VALUES ('장채현', 900, '901123-2345678', 'jang_ch@kh.or.kr', '01012341234', 'D1', 'J7', 'S3', 4300000);


INSERT INTO EMP_01
-- VALUES -- 서브쿼리로 INSERT 시 VALUES 생략
(SELECT EMP_ID, EMP_NAME, DEPT_TITLE
 FROM EMPLOYEE
 LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID));




2. UPDATE

-- [작성법]
-- UPDATE 테이블명 SET 컬럼명 = 바꿀값 [WHERE 컬럼명 비교연산자 비교값];


-- DEPARTMENT2 테이블에서 DEPT_ID가 'D9'인 행의 DEPT_TITLE을 '전략기획팀' 으로 수정
UPDATE DEPARTMENT2 
SET DEPT_TITLE = '전략기획팀';
WHERE DEPT_CODE = 'D9'

-- EMPLOYEE2 테이블에서 BONUS를 받지 않는 사원의 
-- BONUS를 0.1로 변경
UPDATE EMPLOYEE2
SET BONUS = 0.1
WHERE BONUS IS NULL;

-- * 조건절을 설정하지 않고 UPDATE 구문 실행 시 모든 행의 컬럼 값 변경.
UPDATE DEPARTMENT2 
SET DEPT_TITLE = '인사팀'; -- 모든 행 수정

-- * 여러 컬럼을 한번에 수정할 시 콤마(,)로 컬럼을 구분하면됨.
-- D9 / 총무부  -> D0 / 전략기획2팀으로 수정
UPDATE DEPARTMENT2
SET DEPT_ID = 'D0', DEPT_TITLE = '전략기획2팀'
WHERE DEPT_ID = 'D9';

DELETE -- 테이블의 행을 삭제하는 구문

-- EMPLOYEE2 테이블에서 이름이 '장채현'인 사원 정보 삭제
DELETE FROM EMPLOYEE2
WHERE EMP_NAME = '장채현';




TCL

1) COMMIT : 메모리 버퍼(트랜잭션)에 임시 저장된 데이터 변경 사항을 DB에 반영

-- DEPT_ID가 'D9'인 부서의 이름과 지역코드를
-- '전략기획팀', 'L3' 로 수정.
UPDATE DEPARTMENT3 -- 해당 테이블을 수정할것이다.
SET DEPT_TITLE = '전략기획팀', LOCATION_ID = 'L3' -- 어떤걸 수정할것이냐
WHERE DEPT_ID = 'D9'; -- 어디에 있는 것을 수정할것이냐?

COMMIT; -- 현재 트랜잭션에 저장된 DML(INSERT, UPDATE)를
		-- 실제 DB에 반영

ROLLBACK; -- 한번 COMMIT된 내용은 ROLLBACK으로는 취소 불가


2) ROLLBACK : 메모리 버퍼(트랜잭션)에 임시 저장된 데이터 변경 사항을 삭제하고
                   마지막 COMMIT 상태로 돌아감.


3) SAVEPOINT : 메모리 버퍼(트랜잭션)에 저장 지점을 정의하여
                   ROLLBACK 수행 시 전체 작업을 삭제하는 것이 아닌
                   저장 지점까지만 일부 ROLLBACK 


-- DEPT_ID가 'D0'인 행을 삭제
DELETE FROM DEPARTMENT3 WHERE DEPT_ID = 'D0';
SAVEPOINT SP1;

-- DEPT_ID가 'D9'인 행을 삭제
DELETE FROM DEPARTMENT3 WHERE DEPT_ID = 'D9';
SAVEPOINT SP2;

-- DEPT_ID가 'D8'인 행을 삭제
DELETE FROM DEPARTMENT3 WHERE DEPT_ID = 'D8';
SAVEPOINT SP3;

SELECT * FROM DEPARTMENT3;

--SP3 까지만 롤백
ROLLBACK TO SP3;
SELECT * FROM DEPARTMENT3;

--SP2 까지만 롤백
ROLLBACK TO SP2;
SELECT * FROM DEPARTMENT3;

--SP1 까지만 롤백
ROLLBACK TO SP1;
SELECT * FROM DEPARTMENT3;

-- 'D0' 삭제 구문도 취소 -> 그냥 ROLLBACK
ROLLBACK;

DDL

1) CREATE (생성, 창조)
-- 테이블이나 인덱스, 뷰 등 다양한 데이터베이스 객체를 생성하는 구문
-- 테이블로 생성된 객체는 DROP 구문을 통해 제거 할 수 있음 

-- [표현식] 
/*
    CREATE TABLE 테이블명 (
        컬럼명 자료형(크기), 
        컬럼명 자료형(크기),
        ...);
*/

/* 자료형
    NUMBER : 숫자형(정수, 실수)
    CHAR(크기) : 고정길이 문자형 (2000BYTE) 
        -> ex) CHAR(10) 컬럼에 'ABC' 3BYTE 문자열만 저장해도 10BYTE 저장공간을 모두 사용. 
        
    VARCHAR2(크기) : 가변길이 문자형 (4000 BYTE)
        -> ex) VARCHAR2(10) 컬럼에 'ABC' 3BYTE 문자열만 저장하면 나머지 7BYTE를 반환함.
        
    DATE : 날짜 타입
    BLOB : 대용량 이진 데이터 (4GB) (Byte Long Of Byte)
    CLOB : 대용량 문자 데이터 (4GB) (Charater Long Of Byte)

-- MEMBER 테이블 생성
-- 1) 필요한 컬럼 : 아이디,		비밀번호,		 이름, 		  주민번호, 	  가입일
-- 2) 컬럼명 지정 : MEMBER_ID, MEMBER_PWD, MEMBER_NAME, MEMBER_SSN, ENROLL_DATE


-- 3) 테이블 생성하기
-- UTF-8 환경에서 한글은 3BYTE
-- DEFAULT : 기본값
CREATE TABLE MEMBER (
	-- 컬럼명 자료형
	MEMBER_ID VARCHAR2(20),
	MEMBER_PWD VARCHAR2(20),
	MEMBER_NAME VARCHAR2(60),
	MEMBER_SSN CHAR(14), -- 주민번호는 항상 14글자
	ENROLL_DATE DATE DEFAULT SYSDATE -- 기본값을 현재 시간으로 지정
);


-- 2. 컬럼에 주석 달기
-- [표현식]
-- COMMENT ON COLUMN 테이블명.컬럼명 IS '주석내용';
COMMENT ON COLUMN MEMBER.MEMBER_ID 		IS '회원 아이디';
COMMENT ON COLUMN MEMBER.MEMBER_PWD		IS '회원 비밀번호';
COMMENT ON COLUMN MEMBER.MEMBER_NAME 	IS '회원 이름';
COMMENT ON COLUMN MEMBER.MEMBER_SSN 	IS '주민등록번호';
COMMENT ON COLUMN MEMBER.ENROLL_DATE 	IS '회원 가입일';



-- 제약 조건(CONSTRAINTS)
/*
    사용자가 원하는 조건의 데이터만 유지하기 위해서 특정 컬럼에 설정하는 제약.
    데이터 무결성 보장을 목적으로 함.

    + 입력 데이터에 문제가 없는지 자동으로 검사하는 목적
    + 데이터의 수정/삭제 가능여부 검사 등을 목적으로 함 
        --> 제약조건을 위배하는 DML 구문은 수행할 수 없음!
    
    제약조건 종류 ** 필수 암기해야함
    PRIMARY KEY(기본키, 행을 구분하는 값(사번, 학번)),
    NOT NULL(컬럼에 NULL 안됨), 
    UNIQUE(중복 안됨), 
    CHECK(지정된 값만 삽입, 수정 가능), 
    FOREIGN KEY(다른 테이블의 기본키 또는 UNIQUE가 설정된 컬럼을 참조).
    	-> 다른 테이블의 값을 가져다 씀
    	-> 두 테이블이 같은 값을 가지는 컬럼이 생기게 됨
    	-> JOIN 가능 ======== 관계 형성


-- 1. NOT NULL 
-- 해당 컬럼에 반드시 값이 기록되어야 하는 경우 사용
-- 삽입/수정시 NULL값을 허용하지 않도록 컬럼레벨에서 제한

-- 컬럼 레벨 제약 조건 설정
--> 테이블 생성 시 컬럼을 지정하는 부분에 
-- 이어서 제약 조건을 작성하는 경우

CREATE TABLE USER_USED_NN(
    USER_NO NUMBER NOT NULL, -- 컬럼 레벨 제약 조건 설정
    						-- (NOT NULL은 컬럼 레벨만 지정 가능!!)
    USER_ID VARCHAR2(20) ,
    USER_PWD VARCHAR2(30) ,
    USER_NAME VARCHAR2(30) ,
    GENDER VARCHAR2(10),
    PHONE VARCHAR2(30),
    EMAIL VARCHAR2(50)
);



-- 2. UNIQUE 제약조건 
-- 컬럼에 입력 값에 대해서 중복을 제한하는 제약조건
-- 컬럼레벨에서 설정 가능, 테이블 레벨에서 설정 가능
-- 단, UNIQUE 제약 조건이 설정된 컬럼에 NULL 값은 중복 삽입 가능.

DROP TABLE USER_USED_UK; -- USER_USED_UK 삭제;

-- UNIQUE 제약 조건 테이블 생성
CREATE TABLE USER_USED_UK(
    USER_NO NUMBER,
    --USER_ID VARCHAR2(20) UNIQUE, -- 컬럼 레벨 제약 조건 
    --USER_ID VARCHAR2(20) CONSTRAINT USER_ID_U  UNIQUE,
    			  	  -- CONSTRAINT 제약조건명  제약조건종류
    				  -- 컬럼 레벨 제약 조건(제약 조건 이름 지정 O)
    USER_ID VARCHAR2(20), -- 컬럼 레벨 제약 조건 X
    USER_PWD VARCHAR2(30) ,
    USER_NAME VARCHAR2(30),
    GENDER VARCHAR2(10),
    PHONE VARCHAR2(30),
    EMAIL VARCHAR2(50) ,
    
    -- 테이블 레벨 제약 조건(테이블 기본 구조 완성 후 제약조건 추가)
    -- UNIQUE(USER_ID) -- 제약조건(컬럼명) -> 제약조건명 미지정
    CONSTRAINT USER_ID_U UNIQUE(USER_ID) --> 제약조건명 지정



-- UNIQUE 복합키
-- 두 개 이상의 컬럼을 묶어서 하나의 UNIQUE 제약조건을 설정함
--> 지정된 모든 컬럼의 값이 일치해야 중복으로 판단!
--> 복합키는 테이블 레벨로만 설정 가능
CREATE TABLE USER_USED_UK2(
    USER_NO NUMBER,
    USER_ID VARCHAR2(20),
    USER_PWD VARCHAR2(30) NOT NULL,
    USER_NAME VARCHAR2(30),
    GENDER VARCHAR2(10),
    PHONE VARCHAR2(30),
    EMAIL VARCHAR2(50)
    
    -- 테이블 레벨 복합키 지정
    , CONSTRAINT USER_ID_NAME_U UNIQUE (USER_ID, USER_NAME)
  
);



-- 3. PRIMARY KEY(기본키) 제약조건 

-- 테이블에서 한 행의 정보를 찾기위해 사용할 컬럼을 의미함

-- 테이블에 대한 식별자(IDENTIFIER) 역할을 함 ** 외울거면 아래 제약조건의 의미까지 2줄 외우기
	--> 학번, 사번, 주민등록번호, 시리얼넘버, 번호표, 게시글 번호...

-- NOT NULL + UNIQUE 제약조건의 의미

-- 한 테이블당 한 개만 설정할 수 있음

-- 컬럼레벨, 테이블레벨 둘다 설정 가능함

-- 한 개 컬럼에 설정할 수도 있고, 여러개의 컬럼을 묶어서 설정할 수 있음


CREATE TABLE USER_USED_PK(
	-- 컬럼 레벨로 PK 지정
	-- USER_NO NUMBER PRIMARY KEY, -- 컬럼 레벨, 이름 지정 X
    -- USER_NO NUMBER CONSTRAINT USER_NO_PK PRIMARY KEY, -- 컬럼 레벨, 이름 지정  0
    
	USER_NO NUMBER, -- 테이블 레벨 지정용 컬럼(테이블 마지막 줄에 작성)

    USER_ID VARCHAR2(20) UNIQUE,
    USER_PWD VARCHAR2(30) NOT NULL,
    USER_NAME VARCHAR2(30),
    GENDER VARCHAR2(10),
    PHONE VARCHAR2(30),
    EMAIL VARCHAR2(50)

    -- 테이블 레벨
    --, PRIMARY KEY(USER_NO) -- 테이블 레벨, 이름 지정 X
    , CONSTRAINT USER_NO_PK PRIMARY KEY(USER_NO) -- 테이블 레벨, 이름 지정 O
);


-- PRIMARY KEY 복합키 (테이블 레벨만 가능)
CREATE TABLE USER_USED_PK2(
    USER_NO NUMBER,
    USER_ID VARCHAR2(20),
    USER_PWD VARCHAR2(30) NOT NULL,
    USER_NAME VARCHAR2(30),
    GENDER VARCHAR2(10),
    PHONE VARCHAR2(30),
    EMAIL VARCHAR2(50),
    CONSTRAINT PK_USERNO_USERID PRIMARY KEY(USER_NO, USER_ID) -- 복합키
);



-- DDL(Data Definition Language) : 데이터 정의 언어로
-- 객체를 만들고(CREATE), 수정하고(ALTER), 삭제하는(DROP) 구문

-- ALTER(바꾸다, 변조하다)
-- 수정 가능한 것 : 컬럼(추가/수정/삭제), 제약조건(추가/삭제)
--                  이름변경(테이블, 컬럼, 제약조건)

-- [작성법]
-- 테이블을 수정하는 경우
-- ALTER TABLE 테이블명 ADD|MODIFY|DROP 수정할 내용;


-- 1. 제약조건 추가 / 삭제

-- * 작성법 중 [] 대괄호 : 생략 가능(선택)

-- 제약조건 추가 : ALTER TABLE 테이블명 
--                 ADD [CONSTRAINT 제약조건명] 제약조건(컬럼명) [REFERENCES 테이블명[(컬럼명)]];

-- 제약조건 삭제 : ALTER TABLE 테이블명
--                 DROP CONSTRAINT 제약조건명;


-- DEPT_COPY 테이블의 DEPT_TITLE 컬럼에 UNIQUE 제약조건 추가
-- 제약조건명 : DEPT_COPY_TITLE_U
ALTER TABLE DEPT_COPY 
	ADD CONSTRAINT DEPT_COPY_TITLE_U UNIQUE (DEPT_TITLE);

-- DEPT_COPY 테이블의 LOCATION_ID 컬럼에 CHECK 제약조건 추가
-- 컬럼에 작성할 수 있는 값은 L1, L2, L3, L4, L5 
-- 제약조건명 : LOCATION_ID_CHK
ALTER TABLE DEPT_COPY
	ADD CONSTRAINT LOCATION_ID_CHK CHECK (LOCATION_ID IN('L1','L2','L3','L4','L5'));

-- DEPT_COPY 테이블의 DEPT_TITLE 컬럼에 NOT NULL 제약조건 추가
-- * NOT NULL 제약조건은 다루는 방법이 다름
-->  NOT NULL을 제외한 제약 조건은 추가적인 조건으로 인식됨.(ADD/DROP)
-->  NOT NULL은 기존 컬럼의 성질을 변경하는 것으로 인식됨.(MODIFY)
ALTER TABLE DEPT_COPY MODIFY DEPT_TITLE NOT NULL; -- (NULL 허용 X)
		  	                   -- NULL (NULL 허용)


-- DEPT_COPY에 추가한 제약조건 중 PK 빼고 모두 삭제
ALTER TABLE DEPT_COPY DROP
CONSTRAINT DEPT_COPY_TITLE_U;

ALTER TABLE DEPT_COPY DROP
CONSTRAINT LOCATION_ID_CHK;

-- NOT NULL 제거 시 MODIFY 사용
ALTER TABLE DEPT_COPY MODIFY DEPT_ID
CONSTRAINT SYS_C0014966 NULL;

ALTER TABLE DEPT_COPY MODIFY DEPT_TITLE
CONSTRAINT SYS_C0014972 NULL;

ALTER TABLE DEPT_COPY MODIFY LOCATION_ID
CONSTRAINT SYS_C0014967 NULL;



-- 2. 컬럼 추가/수정/삭제

-- 컬럼 추가 : ALTER TABLE 테이블명 ADD(컬럼명 데이터타입 [DEFAULT '값']);


-- 컬럼 수정 : ALTER TABLE 테이블명 MOIDFY 컬럼명 데이터타입;   (데이터 타입 변경)
--             ALTER TABLE 테이블명 MOIDFY 컬럼명 DEFAULT '값'; (기본값 변경)

--> ** 데이터 타입 수정 시 컬럼에 저장된 데이터 크기 미만으로 변경할 수 없다.


-- 컬럼 삭제 : ALTER TABLE 테이블명 DROP (삭제할컬럼명);
--             ALTER TABLE 테이블명 DROP COLUMN 삭제할컬럼명;

--> ** 테이블에는 최소 1개 이상의 컬럼이 존재해야 되기 때문에 모든 컬럼 삭제 X

-- 테이블이란? 행과 열로 이루어진 데이터베이스의 가장 기본적인 객체


-- (추가)
-- DEPT_COPY 컬럼에 CNAME VARCHAR2(20) 컬럼 추가
-- ALTER TABLE 테이블명 ADD(컬럼명 데이터타입 [DEFAULT '값']);
ALTER TABLE DEPT_COPY ADD(CNAME VARCHAR2(20));
SELECT * FROM DEPT_COPY;

-- (수정)
-- DEPT_COPY 테이블의 DEPT_ID 컬럼의 데이터 타입을 CHAR(2) -> VARCHAR2(3)으로 변경
-- ALTER TABLE 테이블명 MODIFY 컬럼명 데이터타입;
ALTER TABLE DEPT_COPY MODIFY DEPT_ID VARCHAR2(3);
--> 이미 저장된 컬럼 값의 크기보다 작게 변경 불가

-- (기본값 수정)
-- LNAME 기본값을 '한국' -> '대한민국' 으로 변경
-- ALTER TABLE 테이블명 MODIFY 컬럼명 DEFAULT '값'; 
ALTER TABLE DEPT_COPY MODIFY LNAME DEFAULT '대한민국';

-- LNAME 컬럼 값을 모두 '대한민국' 변경 (DEFAULT 사용)
UPDATE DEPT_COPY
SET LNAME = DEFAULT;
-- 조건 미작성 시 모든 행에 적용

-- (삭제)
-- DEPT_COPY에 추가한 컬럼(CNAME, LNAME) 삭제
-->  ALTER TABLE 테이블명 DROP(삭제할컬럼명);
ALTER TABLE DEPT_COPY DROP (CNAME);

-- ORA-12983: 테이블에 모든 열들을 삭제할 수 없습니다 
모든 열 삭제는 불가


-- 3. 테이블 삭제

-- [작성법]
-- DROP TABLE 테이블명 [CASCADE CONSTRAINTS];

-- ** 관계가 형성된 테이블 중 부모테이블(TB1) 삭제 **
DROP TABLE TB1;
-- ORA-02449: 외래 키에 의해 참조되는 고유/기본 키가 테이블에 있습니다 
--> 다른 테이블이 TB1 테이블을 참조하고 있어서 삭제 불가능.

-- 해결 방법 1 : 자식 -> 부모 테이블 순서로 삭제하기
-- (참조하는 테이블이 없으면 삭제 가능)
DROP TABLE TB2;
DROP TABLE TB1; -- 삭제 성공

-- 해결 방법 2 : CASCADE CONSTRAINTS 옵션 사용
--> 제약조건까지 모두 삭제 
-- == FK 제약조건으로 인해 삭제가 원래는 불가능 하지만, 제약조건을 없애버려서 FK 관계를 해제
DROP TABLE TB1 CASCADE CONSTRAINTS; -- 삭제 성공
DROP TABLE TB2;  


-- 4. 컬럼, 제약조건, 테이블 이름 변경(RENAME)

-- 테이블 복사
CREATE TABLE DEPT_COPY AS SELECT * FROM DEPARTMENT; 
SELECT * FROM DEPT_COPY;

-- 복사한 테이블에 PK 추가
ALTER TABLE DEPT_COPY ADD CONSTRAINT PK_DCOPY PRIMARY KEY(DEPT_ID);

-- 1) 컬럼명 변경 : ALTER TABLE 테이블명 RENAME COLUMN 컬럼명 TO 변경명;
ALTER TABLE DEPT_COPY RENAME COLUMN DEPT_TITLE TO DEPT_NAME;
SELECT * FROM DEPT_COPY;

-- 2) 제약조건명 변경 : ALTER TABLE 테이블명 RENAME CONSTRAINT 제약조건명 TO 변경명;
ALTER TABLE DEPT_COPY RENAME CONSTRAINT PK_DCOPY TO DEPT_COPY_PK;

-- 3) 테이블명 변경 : ALTER TABLE 테이블명 RENAME TO 변경명;
ALTER TABLE DEPT_COPY RENAME TO DCOPY;
SELECT * FROM DCOPY;
SELECT * FROM DEPT_COPY; -- 이름이 변경되어 DEPT_COPY 테이블명으로 조회 불가

