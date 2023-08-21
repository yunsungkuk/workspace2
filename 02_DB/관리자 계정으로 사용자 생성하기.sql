-- 한 줄 주석 ctrl + /
/*  범위 주석 ctrl + Shift + /   */

-- SQL 한 줄 실행 : ctrl + enter


-- 오라클 쌍따옴표(" ")의 의미 : 대문자/소문자를 구문하겠다.

-- 예전 버전(11g 이전 버전) 오라클 구문 사용하기
ALTER SESSION SET "_ORACLE_SCRIPT" = TRUE;

CREATE USER a230724_ysk IDENTIFIED BY "dbstjdrnr1!";

GRANT CONNECT, RESOURCE, CREATE VIEW TO a230724_ysk;

ALTER USER a230724_ysk DEFAULT TABLESPACE "A230724"
QUOTA 20M ON "A230724";