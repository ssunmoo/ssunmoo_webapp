drop database if exists jspweb;
create database jspweb;
use jspweb;

create table member(

	mno int auto_increment primary key,				-- 회원번호
	mid varchar(50) not null unique,				-- 아이디
    mpw varchar(50) not null,						-- 비밀번호
	mname varchar(50) not null,						-- 이름
	mphone varchar(15) not null,					-- 번호
    memail varchar(100) not null unique,			-- 이메일
	maddress varchar(100) null,						-- 주소
    mdate datetime default now() not null ,			-- default : 레코드 추가시 기본으로 들어가는 값 설정, now() : 현재 시스템의 자동날짜 
    mpoint int default 0 not null                   -- 포인트             
    
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


-- ------------------------------------------------------

-- 게시판 테이블 생성
drop table if exists board;
create table board(

	bno			int primary key auto_increment,		-- 게시글 번호
	btitle 		varchar(1000) ,						-- 제목
    bcontent 	longtext,							-- 내용	[ 썸머노트 이용하여 사진/영상 대용량 추가 ]
    bfile		longtext,							-- 파일첨부 [ 게시물 1개당 첨부파일 1개 ]
    bdate		datetime default now(),				-- 작성일 : 기본 값 현재 시스템 날짜
    bview		int default 0,						-- 조회수 : 기본 값 0
    cno			int,								-- 카테고리 번호 fk 
    mno 		int,								-- 작성자
    constraint ccno_fk foreign key ( cno ) references category ( cno ) on delete cascade on update cascade , 
    constraint bmno_fk foreign key ( mno ) references member ( mno ) on delete cascade on update cascade 
    
);
select * from board;

-- ------------------------------------------------------



-- 댓글 테이블 생성 [ 1. 게시물 번호 2. 회원번호 3. 내용 4. 답글식별필드 ]
drop table if exists reply;
create table reply(

	rno int auto_increment,					-- 댓글 번호
	rcontent varchar(1000) not null,		-- 댓글 내용
    rdate datetime default now(), 			-- 댓글 작성일
    rindex int default 0,					-- 댓글, 대댓글 식별 필드 [ 0 : 상위 댓글, 숫자 : 상위댓글번호 ]
    mno int not null,						-- 작성자 회원번호
    bno int not null,						-- 게시물 번호
    
    constraint rno_pk primary key ( rno ),
    constraint rmno_fk foreign key ( mno ) references member ( mno ) on delete cascade , -- 회원 탈퇴 시 댓글도 함께 삭제
    constraint rbno_fk foreign key ( bno ) references board ( bno ) on delete cascade	 -- 게시물 삭제 시 댓글도 삭제
    
);
select * from reply;

-- 댓글작성 쿼리문
insert into reply(rcontent, mno, bno) values(?, ?, ?);

-- 댓글 호출
select r.rcontent, r.rdate, m.mid
from reply r, member m
where r.mno = m.mno
and r.bno = 17;

-- 댓글만 출력
select * from reply where rindex = 0;

-- 1번 댓글의 답글만 출력
select * from reply where rindex = 1;

-- 해당 게시물의 댓글만 출력
select r.rcontent, r.rdate, m.mid
from reply r, member m
where r.mno = m.mno
and r.bno = 18
and r.rindex = 0
order by r.rdate desc;

-- 해당 게시물의 1번 댓글의 답글만 출력
select r.rcontent, r.rdate, m.mid, r.rno
from reply r, member m
where r.mno = m.mno
and r.bno = 18 and r.rindex = 1;


-- ------------------------------------------------------




insert into board(btitle, bcontent) value( "aa", "aa");
select * from member where mid = "ㅇㅇㅇ";

-- 두개 테이블 검색 [ 1번 테이블 레코드 수 x 2번 테이블 레코드 수 ]
select * from member, board;	

-- 조건 [ pk - fk 일치한 경우만 표시 ]
select b.bno, b.btitle, b.bcontent, b.bfile, b.bdate, b.bview, b.cno, b.mno, m.mid  from member as m, board as b where m.mno = b.mno;

-- 5. 모든 글 출력
select b.*, m.mid  from member as m, board as b where m.mno = b.mno;

-- 6. 개별 글 출력
select b.*, m.mid  from member as m, board as b where m.mno = b.mno and bno =1;


create table api(
	
    api_no int auto_increment primary key , 	-- 평점 번호
    대표전화 varchar(20) ,		
	평점 int

);

-- csv 파일 -> db 테이블 가져오기
-- 1. 해당 db 오른쪽 클릭 -> table data import wizard


-- 모든 게시물 수 확인
select count(*) from board;

-- 검색 결과에서 limit를 이용한 개수 제한 [ 시작점, 개수 ]
select * from board limit 0, 3;

-- 검색결과 정렬[ 작성일 기준 정렬 desc 내림차순 asc 오름차순 -> 날짜는 최신일수록 크다 ]
select * from board order by bdate desc;

-- 페이지 보기 처리
select * from board order by bdate desc limit 0, 3; -- [ 1 페이지 ]
select * from board order by bdate desc limit 3, 3; -- [ 2 페이지 ]

-- 앞전 코드 + 정렬
select b.*, m.mid  from member as m, board as b where m.mno = b.mno order by b.bdate desc;

-- 앞전 코드 + 정렬 + 출력제한
select b.*, m.mid  from member as m, board as b where m.mno = b.mno order by b.bdate desc limit 0, 3;


-- 검색처리 sql문 -> 레코드 수 검색 
select count(*)
from board as b
where b.btitle like '%r%';


-- 검색된 게시물 수 확인
select count(*)
from member as m, board as b
where m.mno = b.mno and b.btitle like '%a%';

-- 전체 게시물
select b.*, m.mid
from member as m, board as b
where m.mno = b.mno
order by b.bdate desc
limit 0, 3;

-- 검색된 게시물 확인
select b.*, m.mid
from member as m, board as b
where m.mno = b.mno and b.bcontent like '%r%'
order by b.bdate desc
limit 0, 3;




insert into reply(rcontent, mno, bno) values(?, ?, ?);






