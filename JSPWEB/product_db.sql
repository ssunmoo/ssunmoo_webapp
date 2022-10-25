use jspweb;

drop table if exists pcategory;
-- 제품 카테고리 테이블 
create table pcategory(
	
	pcno int auto_increment,						-- 카테고리번호
    pcname varchar(100),							-- 카테고리이름
	
    constraint pcno_pk primary key( pcno )
);
select * from pcategory;


drop table if exists product;
-- 제품테이블
create table product(
	
    pno	int auto_increment,							-- 제품번호
    pname varchar(100),								-- 제품명
	pcomment varchar(1000),							-- 제품설명
    pprice int unsigned, 							-- 제품가격	 int : +- 20억, unsigned 사용시 음수 제거 : 0~40억
	pdiscount float, 								-- 제품할인율 [소수점]
	pactive tinyint,   								-- 제품상태 : 0[준비중], 1[판매중], 2[재고없음]으로 사용 예정
	pimg varchar(100), 								-- 썸네일 경로
	pdate datetime default now(), -- 등록날짜			-- 등록 날짜
	pcono int,										-- 제품 카테고리 번호 FK						
    
    constraint pno_pk primary key( pno ),
	constraint pcon_kf foreign key( pcono ) references pcategory( pcono ) on update cascade on delete cascade
);
select * from product;






