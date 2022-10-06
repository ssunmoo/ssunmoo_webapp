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


