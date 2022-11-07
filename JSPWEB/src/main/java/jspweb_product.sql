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
select * from productsize;


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
select * from productstock;

-- 제품 사이즈 등록 쿼리문
insert into productsize( psize, pno ) value ( ? , ? );

-- 제품 색상 등록 쿼리문
insert into productstock( pcolor, pstock, psno) values ( ?, ?, ? );

-- 제품별 재고 출력
select ps.psno, ps.psize, pst.pstno, pst.pcolor, pst.pstock 			-- 원하는 필드만
from productsize as ps, productstock as pst								-- 두개의 테이블을 합해서
where ps.psno = pst.psno and ps.pno = 2									-- ps.pno로 검색했을때 ps.psno 와 pst.psno 가 동일 하면
order by ps.psize desc;						

-- 좋아요 테이블
drop table plike;
create table plike( -- sns <--> 친추 
	plikeno int auto_increment,
    mno int,
    pno int,
    
    constraint plik_pk primary key ( plikeno ),
    constraint plik_mno_fk  foreign key ( mno ) references member( mno ),
	constraint plik_pno_fk  foreign key ( pno ) references product( pno )
);

-- 해당 제품의 찜하기 여부 확인
select * from plike where pno = ? and mno = ?;

-- 찜하기가 되어있으면 삭제
delete from plike where pno = ? and mno = ?;

-- 찜하기가 안되어있으면 넣기
insert into plike( pno , mno ) values( ?, ? );

-- 전체 찜하기 확인
select * from plike;


-- 장바구니 테이블
drop table if exists cart;
create table cart(

	cartno int auto_increment,			-- 사이즈, 색상, 제품정보를 모두 가져올 수 있음 [ fk로 연결되어있기 때문에 ]
    amount int, 						-- 옵션 수량
    pstno int,							-- 제품 재고 정보
    mno int,							-- 회원번호

	constraint cart_pk primary key( cartno ),
    constraint cart_pstno_fk foreign key( pstno ) references productstock ( pstno ),
	constraint cart_mno_fk foreign key( mno ) references member ( mno )
);

-- 재고번호 찾기

-- 장바구니에 선택한 제품 옵션 추가
insert into cart( amount, pstno, mno ) values(?, ?, ?);

-- 재고 테이블 검색
select * from productstock; 

-- 재고 테이블에 pno 없기 때문에 오류 발생
select * from productstock where pno = 7; 

-- 사이즈 테이블에는 pno 있음
select * from productsize where pno = 7;

--
select * from productsize where pno = 7 and psize = '4/4';

-- 두개이상 테이블 검색
select * from productsize as ps, productstock as pst where ps.psno = pst.psno and psize = 'm' and pcolor = '파랑';


-- 1. 서브쿼리 방법 [ select 안에 select ] 
select psno from productsize where pno = 7 and psize = '3/4';

select pstno
from productstock pst, ( select psno from productsize where pno = 7 and psize = '3/4') sub
where pst.psno = sub.psno and pcolor = '갈색';

-- ---------------------------------------------------------------------------------------------------------------------

-- 선택한 옵션을 장바구니에 추가하기  [ 22-11-03 ]
insert into cart ( amount , pstno , mno )
values (
	1, 
	(select pstno
	from productstock pst, ( select psno from productsize where pno = 7 and psize = '3/4') sub
	where pst.psno = sub.psno and pcolor = '갈색'), 
	3
 );
 
 select * from cart;
 select * from member;
-- ex) 3번 회원의 장바구니 호출 [ mno -> 카트번호, 재고번호, 제품명, 제품사진, 가격, 할인율, 색상, 사이즈, 수량  ]

-- 회원 장바구니
select * from cart where mno = 3; 

-- 카트, 재고 테이블 조회
select * from cart c , productstock pst where c.pstno = pst.pstno; 

-- 카트, 재고, 사이즈 테이블 조회
select * from cart c , productstock pst , productsize ps
where c.pstno = pst.pstno and pst.psno = ps.psno;

-- 카트, 재고, 사이즈, 제품 조회
select * from cart c , productstock pst , productsize ps, product p
where c.pstno = pst.pstno and pst.psno = ps.psno and ps.pno = p.pno;


-- ex) 3번 회원의 장바구니 호출 [ mno -> 카트번호, 재고번호, 제품명, 제품사진, 가격, 할인율, 색상, 사이즈, 수량  ]
select
	c.cartno as 장바구니번호,
	pst.psno as 재고번호,
    p.pname as 제품명,
    p.pprice as 가격,
    p.pimg as 제품이미지,
    p.pdiscount as 할인율,
    pst.pcolor as 색상,
    ps.psize as 사이즈,
    c.amount as 수량
from cart c , productstock pst , productsize ps, product p
where c.pstno = pst.pstno and pst.psno = ps.psno and ps.pno = p.pno;

-- (p.pprice - (p.pprice * p.pdiscount)) * c.amount as 결제금액	


-- INNER JOIN 버전 : 관계 pk-fk 가 있고 2개이상 테이블이 있을 경우 
select
	c.cartno as 장바구니번호,
	pst.psno as 재고번호,
    p.pname as 제품명,
    p.pprice as 가격,
    p.pimg as 제품이미지,
    p.pdiscount as 할인율,
    pst.pcolor as 색상,
    ps.psize as 사이즈,
    c.amount as 수량
from 
	cart c inner join 
	productstock pst inner join
    productsize ps inner join
    product p
on c.pstno = pst.pstno
	and pst.psno = ps.psno
    and ps.pno = p.pno;

-- natural JOIN 버전 : 관계 pk-fk 가 있고 2개이상 테이블이 있을 경우 

select
	c.cartno as 장바구니번호,
	pst.psno as 재고번호,
    p.pname as 제품명,
    p.pprice as 가격,
    p.pimg as 제품이미지,
    p.pdiscount as 할인율,
    pst.pcolor as 색상,
    ps.psize as 사이즈,
    c.amount as 수량
from 
	cart c natural join 
	productstock pst natural join
    productsize ps natural join
    product p;

-- natural JOIN 버전 간소화
select
	c.cartno, pst.psno, p.pname, p.pimg, 
    p.pprice, p.pdiscount, pst.pcolor, ps.psize, c.amount
from 
	cart c natural join 
	productstock pst natural join
    productsize ps natural join
    product p
where
	c.mno = 3;
    
    
        
    
-- ------------------------------------------------

-- 주문 테이블 [ 22-11-04 ]
drop table if exists porder;
create table porder(
	
	ono int auto_increment,			-- 주문 번호
	oname varchar(100),				-- 수령인 이름
	ophone varchar(100),			-- 수령인 연락처
	oaddress varchar(100),			-- 수령인 주소
	orequest varchar(100),			-- 배송 메세지 
	odate datetime default now(),	-- 주문 날짜
	mno int,							-- 주문자 회원 번호
    
    constraint ono_pk primary key ( ono ),
    constraint orderno_mno_fk foreign key ( mno ) references member ( mno )
    
);
select * from porder;

-- 주문 상세 테이블
drop table if exists porderdetail;
create table porderdetail(
	
	odno int auto_increment,				-- 주문 상세 번호
	odamount int,				-- 수량
    odprice int,                -- 결제 금액 [ 결제 시 할인율 등이 달라질 수 있어서 넣음 ]
	odactive int default 0,		-- 결제 상태[ 0 : 결제 완료 / 4: 취소 / 1 : 배송 준비 중 / 2: 배송 중 / 3: 배송 완료 등 ]
	pstno int,					-- 재고 번호
    ono int,              	  	-- 주문 번호
    
    constraint odno_pk primary key ( odno ),
    constraint od_pstno_fk foreign key ( pstno ) references productstock ( pstno ),
    constraint od_ono_fk foreign key ( ono ) references porder ( ono )
    
);
 select * from porderdetail;   
    
    
    
    
    
    
    
    
    
    
    
    