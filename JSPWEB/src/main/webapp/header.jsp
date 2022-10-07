<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Dangam </title>
	<!-- 뷰포트 -->
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="/JSPWEB/css/header.css">
	<!-- 폰트어썸 -->	
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.14.0/css/all.css">
	
</head>
<body>

	<div class = "webbox">
		<div class ="hd_top"> <!-- 상단 헤더 -->
			<div> <!-- 로고 -->
				<span class = "hd_title"> 
					<a href="/JSPWEB/index.jsp"> Dangam </a>
				</span>		
			</div>
				
			<ul class="hd_sub"> <!-- 상단 메뉴 -->
				<li> <a href = "/JSPWEB/member/login.jsp"> 로그인 </a> </li>
				<li> <a href = "/JSPWEB/member/signup.jsp"> 회원가입 </a> </li>
				<li> <a href = "#"> 마이쇼핑 </a> </li>
				<li> <a href = "#"> 고객센터 </a> </li>
			</ul>
		</div>	<!-- 상단 헤더 종료 -->
		
		<ul class = "hd_menu"> <!-- 하단 헤더 -->
			<li> <a href = "#"> NEW! </a> </li>
			<li> <a href = "#"> 1+1 이벤트 </a> </li>
			<li> <a href = "#"> 아우터 </a> </li>
			<li> <a href = "#"> 상의 </a> </li>
			<li> <a href = "#"> 바지 </a> </li>
			<li> <a href = "#"> 슈즈 </a> </li>
			<li> <a href = "#"> 악세사리 </a> </li>
			<li> <a href = "#"> BEST </a> </li>
			<li> <a href = "#"> 트레이닝 </a> </li>
			<li> <a href = "#"> SALE </a> </li>
			<li> <a href = "#"> MUSCLE-FIT </a> </li>
			<li class="serch_box">
				<span>
					<input>
					<i class="fas fa-search"></i>
				</span> 
				<i class="fas fa-shopping-cart"></i>
			</li>
		</ul> <!-- 하단 헤더 종료 -->

	</div>
	<!--  헤더 제리쿼리 -->
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
</body>
</html>