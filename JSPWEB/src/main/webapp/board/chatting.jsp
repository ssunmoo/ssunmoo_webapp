<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%@include file="../header.jsp" %>
	<!-- 로그인한 회원 아이디 숨기기 [ 헤더.jsp 에 loginid 변수 존재 ]-->
	<input type="hidden" class="mid" value="<%=loginid%>">
	
	<div class="webbox">

		<h3> 채팅 </h3>
		
		<!-- 받은 메세지 출력 구역 -->
		<div class="contentbox"></div> 
	
		<!-- 메세지 입력 구역 -->
		<textarea rows="" cols="" class="msgbox" onkeyup="enterkey()"></textarea>
		
		<!-- 메세지 보내기 버튼 -->
		<button type="button" onclick="send()"> 보내기 </button>
	
	
	
	</div>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	<script src="../js/board/chatting.js" type="text/javascript"></script>



</body>
</html>