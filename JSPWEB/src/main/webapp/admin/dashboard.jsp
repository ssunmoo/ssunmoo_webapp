<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<!-- 부트스트랩 CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
	
<link href="../css/dashboard.css" rel="stylesheet">



</head>
<body>

	<!-- 관리자 페이지 -->
	<!-- 만약에 세션이 없거나 관리자가 아니면 -->
	<%
		String mid = (String)session.getAttribute("mid");
		if(  mid == null || !mid.equals("admin") ){
			response.sendRedirect("../index.jsp");
		}
	%>
	
	<!-- marquee : 텍스트 슬라이드(전광판), scrollamount :슬라이드 속도 -->
	<marquee scrollamount="10"> 공지사항 표시 위치 </marquee>

	<!-- 사이드 바 [ 펼치기/접기 ] -->
	<div class="sideber">
		<h1> admin menu </h1>
		<ul class="side_menu">
			<li class="side_item"><a onclick="pagechage('regist.jsp')"> 제품등록 </a></li>
			<li class="side_item"><a onclick="pagechage('list.jsp')"> 제품목록 </a></li>
			<li class="side_item"><a onclick="pagechage('stock.jsp')"> 재고관리 </a></li>
			<li class="side_item"><a href="#"> 주문관리 </a></li>
			<li class="side_item"><a href="#"> 매출관리 </a></li>
			<li class="side_item"><a href="#"> 회원목록 </a></li>
			<li class="side_item"><a href="#"> 배송관리 </a></li>
			<li class="side_item"><a href="/JSPWEB/member/logout.jsp"> 로그아웃 </a></li>
		</ul>
	</div>

	<!-- 본문 페이지가 보이는 div -->
	<div id="mainbox">
		<!-- 사이드바에서 메뉴 클릭 시 jsp 표시되는 구역 -->
		
			
	</div>



















<!-- 부트스트랩 JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>

<!-- JQUERY 라이브러리 -->
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>

<script type="text/javascript" src="../js/admin/dashboard.js"></script>
</body>
</html>