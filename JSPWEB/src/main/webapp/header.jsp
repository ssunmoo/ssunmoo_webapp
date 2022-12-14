<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> The Music </title>
	<!-- 뷰포트 -->
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="/JSPWEB/css/header.css">
	
	<!-- 폰트어썸 -->	
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.14.0/css/all.css">
	
	<!-- 부트스트랩 CSS -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
	
	
</head>
<body>

	<div class = "webbox">
		<div class ="hd_top"> <!-- 상단 헤더 -->
			<div> <!-- 로고 -->
				<span class = "hd_title"> 
					<a class="nav-link" href="/JSPWEB/index.jsp"> The Music </a>
				</span>		
			</div>
				
			<!-- 세션 호출 [ JSP방식 = 템플릿마다 다름 ( JSP vs 리액트 ) -->
			<%
			// JSP 스크립트 태그 ( 태그안에 JAVA 문법 작성 가능 )
			String loginid = (String)session.getAttribute("mid"); 	
						// 형변환 : 세션자료형 = object// jsp 기본 객체로 세션 제공
			%>
			<ul class="hd_sub">	<!--  상단 메뉴 -->
			
			<!-- 비로그인 메뉴 // 세션이 없다     로그인 안했네...    -->
			<% if( loginid == null ){ %>
				<li> <a class="nav-link" href="/JSPWEB/member/login.jsp">로그인</a> </li>
				<li> <a class="nav-link" href="/JSPWEB/member/signup.jsp">회원가입</a></li>
			
			<!-- 관리자 계정 접속 -->
			<%	}else if( loginid.equals("admin") ){  %>
				<li> <a class="nav-link" href="/JSPWEB/admin/dashboard.jsp"> 관리자 모드 </a> </li>
				
			<!-- 로그인 메뉴  // 세션이 존재한다    로그인 했다..  -->
			<%	}else{  %>
				<li> <%=loginid %> 님 안녕하세요 </li>
				<li> <a class="nav-link" href="/JSPWEB/member/logout.jsp"> 로그아웃 </a> </li>
			<%  }	 %>
			
			<!--  공통 메뉴  -->
				<li> <a class="nav-link" href="/JSPWEB/member/info.jsp">마이쇼핑</a> </li>
				<li> <a class="nav-link" href="/JSPWEB/board/list.jsp">게시판</a> </li>
				
			</ul> <!--  상단 메뉴 end  -->
			
		</div>	<!-- 상단 헤더 종료 -->
		
		<ul class = "hd_menu"> <!-- 하단 헤더 -->
			<li> <a class="nav-link" href = "#"> NEW! </a> </li>
			<li> <a class="nav-link" href = "#"> 건반악기 </a> </li>
			<li> <a class="nav-link" href = "#"> 현악기 </a> </li>
			<li> <a class="nav-link" href = "#"> 전자드럼 </a> </li>
			<li> <a class="nav-link" href = "#"> 기타 </a> </li>
			<li> <a class="nav-link" href = "#"> 우쿨렐레 </a> </li>
			<li> <a class="nav-link" href = "#"> 관악기 </a> </li>
			<li> <a class="nav-link" href = "#"> 칼림바 </a> </li>
			<li> <a class="nav-link" href = "#"> 미디/음향 </a> </li>
			<li> <a class="nav-link" href = "#"> 이벤트 </a> </li>
			<li> <a class="nav-link" href = "/JSPWEB/board/api.jsp"> 공공데이터 </a> </li>
			<li> <a class="nav-link" href = "/JSPWEB/board/chatting.jsp"> 채팅방 </a> </li>
			<li class="serch_box">
				<span>
					<input>
					<i class="fas fa-search"></i>
				</span> 
				<a href = "/JSPWEB/product/cart.jsp"><i class="fas fa-shopping-cart"></i></a>
			</li>
		</ul> <!-- 하단 헤더 종료 -->

	</div>
	
	<!-- 부트스트랩 JS -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
	
	<!-- JQUERY 라이브러리 -->
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>

</body>
</html>



<!-- 

		헤더파일 [ 모든 페이지에서 호출되는 파일 ] 
		경로 : 상대경로x 절대경로로 작성 [ 사용하는 곳 마다 경로가 다르기 때문 ]
	 	
	 	1. 경로 중 맨앞 / 는 최상위 경로 : /JSPWEB/board/api.jsp
	 		localhost:8080/JSPWEB/board/api.jsp [o]
	 	2. 현재 경로 : JSPWEB/board/api.jsp
	 		현재 경로/JSPWEB/board/api.jsp [x]	

 -->
























