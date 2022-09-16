-- p. 71 ~

-- 1. 데이터베이스 생성
CREATE DATABASE shop_db3;

-- 2. 테이블 생성
USE shop_db3;	-- DB 선택
CREATE TABLE MEMBER(
	-- 필드명 데이터타입 속성
    MEMBER_ID CHAR(8) PRIMARY KEY NOT NULL,
    MEMBER_NAME CHAR(5) NOT NULL,
    MEMBER_ADDR CHAR(20)

);
-- 3. 테이블 확인
SELECT * FROM MEMBER;

-- 4. 테이블에 데이터 추가
INSERT INTO MEMBER VALUES('hero', '임영웅', '서울 은평구 중산동');

-- 주소 잘못써서 수정
UPDATE shop_db3.MEMBER SET MEMBER_ADDR = '서울 은평구 중산동' WHERE MEMBER_ID = 'hero';

-- 5. 제품 테이블 생성
CREATE TABLE PRODUCT(

	PRODUCH_NAME CHAR(4) PRIMARY KEY NOT NULL,
    -- 필드명 CHAR : 문자(4글자) Pk : 기본키(식별키) NOT NULL : 공백 불가
	
	COST INT NOT NULL,
    MAKE_DATE DATE,
    COMPANY CHAR(5),
    AMOUNT INT NOT NULL
    
);

SELECT * FROM PRODUCT;


-- SELECT
SELECT * FROM MEMBER; -- MEMBER 테이블의 모든 필드 검색
SELECT MEMBER_ID FROM MEMBER; -- MEMBER 테이블의 ID 필드만 검색
SELECT MEMBER_ID, MEMBER_NAME FROM MEMBER;
SELECT MEMBER_ID, MEMBER_NAME, MEMBER_ADDR FROM MEMBER;
SELECT MEMBER_ID AS 아이디 FROM MEMBER; -- AS : 별칭 [ 원본수정 X, 결과에 표시할 필드명 ]
SELECT MEMBER_ID AS 아이디, MEMBER_NAMA AS 이름, MEMBER_ADDR AS 주소 FROM MEMBER;
SELECT * FROM MEMBER WHERE MEMBER_ID = 'jyp';

















