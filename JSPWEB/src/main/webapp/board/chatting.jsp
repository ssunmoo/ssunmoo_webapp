<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<!-- 사용자 정의 css -->
	<link href="../css/chatting.css" rel ="stylesheet">
	
</head>

<body>

	<%@include file="../header.jsp" %>
	
	<!-- 로그인한 회원 아이디 숨기기 [ 헤더.jsp 에 loginid 변수 존재 ]-->
	<input type="hidden" class="mid" value="<%=loginid%>">
	

	<div class="container"> <!-- 부트스트랩 css는 미리만들어진 class 사용 -->
		
		<!-- 채팅 구역 -->
		<div class="col-sm-6 offset-3 chattingbox">
		
		<div class="row">
		
			<!-- 접속회원 목록 구역 -->
			<div class="col-sm-4">	
				
			</div>
			
			<!-- 채팅창 구역 -->	
			<div class="col-sm-8">	
			
				<!-- 채팅창 -->
				<div class="contentbox my-3"> 
					
		
				</div> <!-- 채팅창 끝 -->
			
				<!-- 채팅 입력 창 -->
				<textarea rows="" cols="" class="form-control msgbox" onkeyup="enterkey()"></textarea>
				
				<!-- 이모티콘, 채팅보내기 -->
				<div class="row">
					<div class="col-sm-2"> <!-- 이모티콘 -->
						<button class="dropdown-toggle" type="button" id="emobutton" data-bs-toggle="dropdown"> 이모티콘 </button>
						
						<ul style="width:400px; height:200px;" class="dropdown-menu">
							<!-- 이모티콘 표시 구역 -->
							
						</ul>
						
					</div>
					<div class="col-sm-3 offset-7"> <!-- 채팅 보내기 버튼 -->
						<button class="form-control" type="button" onclick="send()"> 보내기 </button>
					</div>
				</div>
				
				
				
			</div>
		</div>
		
		
		</div> <!-- 채팅구역 e -->
	</div> <!-- 컨테이너 e -->
	


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	<script src="../js/board/chatting.js" type="text/javascript"></script>



</body>
</html>



<!--  

<div class="contentbox my-3"> 
		<div class="secontent my-3"> 
			<span class="date"> 오전 10 : 07 </span>	
			<span class="content"> 반갑다아아아 </span>
		</div>
		
		  
		<div class="alarm">	
			<span> 김땡땡 님이 들어오셨습니다.</span>
		</div>
		
		
		<div class="row g-0 my-3">
		
			
			<div class="col-sm-1 mx-2">
				<img width="100%" class="rounded-circle" alt="" src="/JSPWEB/img/멈뭄미.JPG">
			</div> 
			
			
			<div class="col-sm-9">
				<div class="recontent">
					<div class="name"> 김망구 </div>
					<span class="content"> 나두 반갑다아아아 </span>
					<span class="date"> 오전 10 : 09 </span>
				</div>
			</div>
		
		</div>
-->








