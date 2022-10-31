use jspweb;

drop table if exists pcategory;
-- 제품 카테고리 테이블 
create table pcategory(
	
	pcno int auto_increment,						-- 카테고리번호
    pcname varchar(100),							-- 카테고리이름
	
    constraint pcno_pk primary key( pcno )
);
select * from pcategory;

-- 카테고리 추가 쿼리문
insert into pcategory(pcname) values('dd');


drop table if exists product;
-- 제품테이블
create table product(
	
    pno	int auto_increment,							-- 제품번호
    pname varchar(100),								-- 제품명
	pcomment varchar(1000),							-- 제품설명
    pprice int unsigned, 							-- 제품가격	 int : +- 20억, unsigned 사용시 음수 제거 : 0~40억
	pdiscount float, 								-- 제품할인율 [소수점]
	pactive tinyint default 0,   					-- 제품상태 : 0[준비중], 1[판매중], 2[재고없음]으로 사용 예정
	pimg varchar(100), 								-- 썸네일 경로
	pdate datetime default now(), -- 등록날짜			-- 등록 날짜
	pcno int,										-- 제품 카테고리 번호 FK						
    
    constraint pno_pk primary key( pno ),
	constraint pcon_fk foreign key( pcno ) references pcategory( pcno ) on update cascade on delete cascade
);
select * from product;

-- 제품 등록 쿼리문
insert into product( pname, pcomment, pprice, pdiscount, pimg, pcono) values(?,?,?,?,?,?);

-- 제품 전체보기 쿼리문
select * from product;

select p.*, ca.pcname from product p, pcategory ca  where pno = 2;

-- board 필드 전체와 member 필드 중 mid 출력 쿼리문
select b.*, m.mid  from member as m, board as b where m.mno = b.mno and bno =1;

-- 제품 수정 쿼리문
update product set pname = "망곰", pcomment = "구엽다", pprice = "38000", pdiscount = "0.2", pimg = "망곰이2.png", pcno = "2" where pno = 2;

-- 제품상태가 1(판매중)인 상품만 정렬해서 출력 쿼리문
select * from product where pactive = 1 order by pdate desc;

-- 제품별[pno] 사이즈[psize] 테이블 생성
drop table if exists productsize;
create table productsize(
	psno int auto_increment,		-- 제품 사이즈 번호
    psize varchar(100),				-- 제품 사이즈
    pno int,						-- 제품 번호
    
    constraint psno_pk primary key ( psno ),
    constraint pno_fk foreign key ( pno ) references product ( pno )
);

-- 사이즈별[psizw] 색상[pcolor] 재고[pstock] 테이블 생성
drop table if exists productstock;
create table productstock(
	pstno int auto_increment,		-- 제품 색상&재고 번호
    pcolor varchar(100),			-- 제품 색상
    pstock int,						-- 제품 재고
    psno int,						-- 제품 사이즈 번호
    
	constraint pstno_pk primary key ( pstno ),
    constraint psno_fk foreign key ( psno ) references productsize ( psno ) 
);

-- 제품 사이즈 등록 쿼리문
insert into productsize( psize, pno ) value ( ? , ? );

-- 제품 색상 등록 쿼리문
insert into productstock( pcolor, pstock, psno) values ( ?, ?, ? );

-- 제품별 재고 출력
select ps.psno, ps.psize, pst.pstno, pst.pcolor, pst.pstock 			-- 원하는 필드만
from productsize as ps, productstock as pst								-- 두개의 테이블을 합해서
where ps.psno = pst.psno and ps.psno = 1								-- ps.psno로 검색했을때 ps.psno 와 pst.psno 가 동일 하면
order by ps.psize desc;						







