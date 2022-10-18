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
	
	
		<form> 
			제목 : <input type="text" name ="btitle" class = "btitle"> <br>
			<!-- 썸머노트 -->
		  	<textarea id="summernote" name="bcontent" class = "bcontent"></textarea>
			첨부파일 : <input type="file" name ="bfile" class = "bfile"> <br>
			
			<!-- 기존 첨부파일 이름과 첨부파일 삭제 버튼 표시 -->
			<div class = "oldfilebox" id = "oldfilebox"> </div>
			
			<!-- form 태그 안에서 button 사용시에는 type 필수 넣기 -->
			<button type="button" onclick="bupdate()"> 수정완료 </button>
		</form>
	</div>




<!-- 썸머노트 API -->
<!-- include libraries(jQuery, bootstrap) -->
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>

<!-- include summernote-ko-KR -->
<script src="lang/summernote-ko-KR.js"></script>

<script src="../js/board/update.js" type="text/javascript"></script>
</body>
</html>