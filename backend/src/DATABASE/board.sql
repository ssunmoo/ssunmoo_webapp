
-- 1. DB 생성
create database boardtest;

-- 2. DB 사용 [ 선택 ] 
use boardtest;

-- 3. 테이블 생성 

create table board(
	-- 테이블명약자_필드명
    b_no int primary key auto_increment , 
		-- primary key  : 기본키 [ 식별자 : 주민등록번호, 사번 , 학번 등 ] : 중복없다.
        -- auto_increment : 자동번호 부여 [ db에서 레코드 생성시 자동으로 번호가 순서대로 생성( 1~ ) ]
	b_title varchar(100)  ,		-- 해당 필드에 최대 100글자 저장 가능 
    b_content varchar(500 ) ,	-- 해당 필드에 쵀대 500글자 저장 가능 
    b_writer varchar(10) , 		-- 해당 필드에 최대 10글자 저장 가능 
    b_password varchar(4) , 	-- 해당 필드에 최대 4글자 저장 가능 
    b_view int 					-- 해당 필드에 int형[ +-20억정도 ]
		-- int 		: 4바이트 정수 +-20억
        -- varchar 	: 문자열 저장가는 가변형 길이 varchar( 문자길이 )  
);

-- 4. 테이블 확인 
select * from board;

-- 5. 테이블에 레코드 추가
	-- 1. 모든 필드를 추가할 경우 [ 필드명 생략 가능 ]
	-- insert into 테이블명 values( 값1, 값2, 값3 );
        
    -- 2. 특정 필드를 추가할 경우 [ 필드명 생략 불가능 ] 
	-- insert into 테이블명 ( 필드명1, 필드명2 ) values ( 값1, 값2 )


insert into board ( b_title, b_content , b_writer , b_password , b_view )
	values( '제목데이터' , '내용데이터' , '유재석' , '1234', 0);















