SHOW databases;

-- : 한줄 주석처리
#  : 한줄 주석처리
/* 여러줄 주석처리 */  

-- 화면 확대/축소 : ctrl + 마우스 휠, ctrl + (+, -)
-- SQL 한줄 실행 : 해당 SQL 코드에서 ctrl + enter


CREATE DATABASE shop_db2;	-- 데이터 베이스 생성

CREATE TABLE shop_db2.member(		-- 테이블 생성
	member_id char(8) primary key not null,
    member_name char(5) not null,
    member_addr char(20)
);


SELECT * FROM shop_db2.member;	-- 테이블 확인[검색]

-- 테이블에 값 저장
INSERT INTO shop_db2.member VALUES( 'tess', '나훈아', '경기 부천시 중동');
INSERT INTO shop_db2.member VALUES( 'hero', '임영웅', '서울 은평구 중산동');
INSERT INTO shop_db2.member VALUES( 'iyou', '아이유', '인천 남구 주안동');
INSERT INTO shop_db2.member VALUES( 'jyp', '박진영', '경기 고양시 장항동');

-- 데이터 수정
UPDATE shop_db2.member SET member_addr = '경기 안산시 상록구 이동' WHERE member_id = 'tess';

-- 데이터 값 삭제
DELETE FROM shop_db2.member WHERE member_id = 'iyou';






