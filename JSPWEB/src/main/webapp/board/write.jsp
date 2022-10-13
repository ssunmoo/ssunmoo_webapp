<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>

	<%@include file="../header.jsp" %>
	<div class="webbox">
	
	<!-- 로그인이 안되어있을 경우 로그인 페이지로 전환 -->
	<% if( loginid == null ) response.sendRedirect("/JSPWEB/member/login.jsp");%>
	
	
	<!-- 1. form = 동기 [ 페이지전환o ] , 2. ajax = 비동기/동기 선택 [ 페이지전환x ] -->
	
		<h3> [ 글쓰기 ]</h3>
		<!-- 1번째 방법 form
		<form method="get" action="/JSPWEB/board/write">
			제목 : <input type="text" name = "b_title"> <br>
			내용 : <input type="text" name = "b_content">
			<button type="submit"> 글작성 </button>	
		</form>
		 -->
	
		<!-- 2번째 방법 ajax -->
		제목 : <input type="text" id = "btitle"> <br>
		내용 : <input type="text" id = "bcontent"> <br>
		첨부파일 : <input type="file"> <br>
		<button onclick="bwrite()"> 글작성 </button>
	
	</div>




<script src="../js/board/write.js" type="text/javascript"></script>
</body>
</html>