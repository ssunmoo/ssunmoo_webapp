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
		<h3> [ 로그인 페이지 ] - js ajax 비동기식 전송 </h3>
			▷ 아이디	: <input type = "text" id ="mid"> <br>
			▷ 비밀번호	: <input type = "password" id ="mpw"> <br>
			<div id = "loginconfirmbox"></div>
			<button type="button" onclick="login()"> 로그인 </button>
			
			<ul>
				<li> <a href = "signup.jsp"> 회원가입 </a> </li>
				<li> <a href = "findid.jsp"> 아이디 찾기 </a> </li>
				<li> <a href = "findpw.jsp"> 비밀번호 찾기 </a> </li>
			</ul>
			
			
	</div>
		
		
		
		
	<!--
		<h3> [ 로그인 페이지1 ] - form 전송 </h3>
	
		<form action="/JSPWEB/member/login" method="post">
		▷ 아이디	: <input type = "text" name ="mid"> <br>
		▷ 비밀번호	: <input type = "password" name ="mpw"> <br>
		<input type="submit" value="로그인">
		</form>
	 -->

	<script src="../js/member/login.js" type="text/javascript"></script>
	
</body>
</html>