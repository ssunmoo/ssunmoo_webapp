drop database if exists jspweb;
create database jspweb;
use jspweb;

create table member(

	mno int auto_increment primary key,			-- 회원번호
	mid varchar(50),							-- 아이디
    mpw varchar(50),							-- 비밀번호
	mname varchar(50),							-- 이름
	mphone varchar(15),							-- 번호
    memail varchar(100),						-- 이메일
	maddress varchar(100),						-- 주소
    mdate datetime default now(),				-- default : 레코드 추가시 기본으로 들어가는 값 설정, now() : 현재 시스템의 자동날짜 
    mpoint int default 0                        	-- 포인트              
);
select * from member;						


-- 로그인 쿼리
select * from member where mid = "aaa" and mpw = "aaa"; 
-- 존재하면 레코드 1개 검색, 존재하지 않으면 레코드 검색 x

select * from member where mname = "aaa" and memail = "aaa";

-- 회원정보 호출
select * from member where mid = 'aaa';

-- 회원 삭제
delete from member where mid = '11' and mpw = '11';

drop table if exists category;
create table category(
	
    cno int auto_increment primary key ,										-- 카테고리 번호
	cname varchar(100)
);
select * from category;

drop table if exists board;
-- 게시판 테이블 생성
create table board(

	bno			int primary key auto_increment,		-- 게시글 번호
	btitle 		varchar(1000) ,						-- 제목
    bcontent 	longtext,							-- 내용
    bfile		longtext,							-- 파일첨부 [ 게시물 1개당 첨부파일 1개 ]
    bdate		datetime default now(),				-- 작성일 : 기본 값 현재 시스템 날짜
    bview		int default 0,						-- 조회수 : 기본 값 0
    cno			int,								-- 카테고리 번호 fk
    mno 		int,								-- 작성자
    constraint bcno_fk foreign key ( cno ) references category ( cno ),
    constraint bmno_fk foreign key ( mno ) references member ( mno )
);


select * from board;

insert into board(btitle, bcontent) value( "aa", "aa");
select * from member where mid = "ㅇㅇㅇ";


-- 두개 테이블 검색 [ 1번 테이블 레코드 수 x 2번 테이블 레코드 수 ]
select * from member, board;	

-- 조건 [ pk - fk 일치한 경우만 표시 ]
select b.bno, b.btitle, b.bcontent, b.bfile, b.bdate, b.bview, b.cno, b.mno, m.mid  from member as m, board as b where m.mno = b.mno;

select b.*, m.mid  from member as m, board as b where m.mno = b.mno;







