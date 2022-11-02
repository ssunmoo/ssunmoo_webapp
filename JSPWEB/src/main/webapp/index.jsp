<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/main.css" rel="stylesheet">
</head>
<body>
	<%@include file="../header.jsp"%>

	<!-- 대문 [ 이미지 슬라이드 - 캐러셀 ]  -->
	<div id="carouselExampleControls" class="carousel slide carousel-fade" data-bs-ride="carousel" data-bs-interval="10000">
														<!-- carousel-fade: 이미지슬라이드 페이드효과 , data-bs-interval: 변경되는 시간 -->		
		<!-- 이미지 삽입 구역 -->
		<div class="carousel-inner"> 
			<div class="carousel-item active" >	<!-- active : 현재 보이는 이미지 [ 슬라이드 될때마다 active의 위치가 변경됨 ]-->
				<img src="/JSPWEB/img/main_img01.jpg" class="d-block w-100" alt="..."> <!-- w-100 : 가로 100% -->
			</div>
			<div class="carousel-item">
				<img src="/JSPWEB/img/main_img02.jpg" class="d-block w-100" alt="...">
			</div>
			<div class="carousel-item">
				<img src="/JSPWEB/img/main_img03.jpg" class="d-block w-100" alt="...">
			</div>
			<div class="carousel-item">
				<img src="/JSPWEB/img/main_img04.jpg" class="d-block w-100" alt="...">
			</div>
		</div>
		
		<!-- 왼쪽 버튼 -->
		<button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="prev">
			<span class="carousel-control-prev-icon" aria-hidden="true">
			</span> <span class="visually-hidden">Previous</span>
		</button>
		<!-- 오른쪽 버튼 -->
		<button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="next">
			<span class="carousel-control-next-icon" aria-hidden="true"></span>
			<span class="visually-hidden">Next</span>
		</button>
		
	</div>

	<!-- 광고/이벤트 -->
	
	
	<!-- 제품 출력 -->
	<div class="container"> <!-- 부트스트랩 전체 박스권 -->
		
		<div class="box_title"> 
			<div> < MD`S PICK > </div>
			<div> 이번주 MD 추천상품입니다 </div>
		</div>
		
		<div class="itemlist"> <!-- 일정 구역 -->
			
		</div> <!-- item e -->
			
	</div>
	
	
	
	
	
	
	
	<!-- 아이템 만든거
	
		<div class="item"> 1개의 제품[아이템]
		<a href="#">
			<img src="/JSPWEB/img/pro01.jpg"> 대표 이미지
		</a>
		<div class="item_info"> 제품 정보
			<div class="item_title"> 제품명
				삼익 입문용 바이올린 LUNA 풀세트
			</div> 
			
			<div class="item_size"> 4/4 사이즈 </div> 옵션
			
			<div class="item_price"> 350,000원 </div> 정상가
			
			<div class="item_dc_box">
				<span class="item_discount"> 83% </span> 할인율
				<span class="item_sals"> 69,000원 </span> 할인가
			</div>
			
			<div class="item_review"> 찜수 218 리뷰 수 412 </div> 리뷰
			<div> 배지 구역
				<span class="badge rounded-pill text-bg-warning"> 당일배송 </span>
				<span class="badge rounded-pill text-bg-danger"> 주문폭주 </span>
			</div>
		</div> 
		</div>
		
		
		-->
	
	
	
	
	
	

<script type="text/javascript" src="js/index.js"></script>

</body>
</html>