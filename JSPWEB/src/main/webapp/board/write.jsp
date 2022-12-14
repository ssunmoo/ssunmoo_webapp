<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

	<!-- 썸머노트 API -->
	<!-- include summernote css/js -->
	<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
	<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
	
	

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
		<form> 
			제목 : <input type="text" id = "btitle" name ="btitle"> <br>
			
			<!-- 썸머노트 -->
		  	<textarea id="summernote" name="bcontent"></textarea>
			<!-- 내용 : <input type="text" id = "bcontent" name ="bcontent"> <br>  --> 
			첨부파일 : <input type="file" name ="bfile"> <br>
			<button type="button" onclick="bwrite()"> 글작성 </button>
		</form>
	</div>




<!-- 썸머노트 API -->
<!-- include libraries(jQuery, bootstrap) -->
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>

<!-- include summernote-ko-KR -->
<script src="lang/summernote-ko-KR.js"></script>

<script src="../js/board/write.js" type="text/javascript"></script>
</body>
</html>