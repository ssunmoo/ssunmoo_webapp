drop database if exists board2;
create database board2;
use board2;

create table board(

	b_no int auto_increment primary key,		-- 게시판 번호
	b_title varchar(50),						-- 제목
    b_content varchar(300),						-- 내용
    b_name varchar(50),							-- 이름
    b_pw varchar(50),							-- 비밀번호
    b_date datetime default now(),				-- default : 레코드 추가시 기본으로 들어가는 값 설정, now() : 현재 시스템의 자동날짜 
    b_view int									-- 조회수
                
);
select * from board;		

insert into board( b_title, b_content, b_name, b_pw) values();