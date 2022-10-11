<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	
	<!-- 헤더 페이지 호출  -->
	<%@include file = "../header.jsp" %>
	<!-- 세션을 이용한 페이지 제어  -->
	<%
		// header.jsp 파일의 변수 호출 
		if( loginid == null ){
			response.sendRedirect("login.jsp"); 
		}
	%>
	<!-- 본문 -->
	<div class = "webbox">
		<h3> [ 회원 정보 ] </h3>
		
		<button onclick="viewdelete()"> 회원탈퇴 </button>
		<div id = "deletebox">
			
		</div>
			
		<table>
			<tr>
				<td> 회원번호 : </td> <td id="mno"> </td>
			</tr>
			
			<tr>
				<td> 아이디 : </td> <td id="mid"> </td>
			</tr>
			
			<tr>
				<td> 이름 : </td> <td id="mname"> </td>
			</tr>
			
			<tr>
				<td> 전화번호 : </td> <td id="mphone"> </td>
			</tr>
			
			<tr>
				<td> 이메일 : </td> <td id="memail"> </td>
			</tr>
			
			<tr>
				<td> 주소 : </td> <td id="maddress"> </td>
			</tr>
			
			<tr>
				<td> 가입날자 : </td> <td id="mdate"> </td>
			</tr>
			
			<tr>
				<td> 포인트 : </td> <td id="mpoint"> </td>
			</tr>
		</table>
		
	</div>
	
	<br>
	
	<div class = "webbox">
	<h3> [ 회원 목록 ] </h3>
		<table id = "memberlisttable">
			
		</table>
	</div>
	
	

	<!-- JS -->
	<script src="../js/member/info.js" type="text/javascript"></script>
	
</body>
</html>