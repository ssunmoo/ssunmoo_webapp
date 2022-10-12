<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3> [ 게시판 ] </h3>
	▷ 제목	: <input type="text" id="b_title"><br>
	▷ 내용	: <input type="text" id="b_content"><br> 
	▷ 이름	: <input type="text" id="b_name"><br> 
	▷ 비밀번호	: <input type="password" id="b_pw"><br><br>
	<button onclick="regist()"> 글등록 </button>
		
	<br>
	<h3> [ 글목록 ] </h3>
	<table id = "board_list">
	</table>
	
	<br>
	<h3> [ 글 상세보기 ] </h3>
	<table id = "b_select_view">
	</table>
	
	<br>
	<button onclick="board_delete()"> 글삭제 </button>
	<div id = "delete_btn"> </div>
	
	
	
	

<!--  헤더 제리쿼리 -->
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	
<script src="../js/regist.js" type="text/javascript"></script>
<script src="../js/board_list.js" type="text/javascript"></script>
<script src="../js/board_delete.js" type="text/javascript"></script>

 
</body>
</html>