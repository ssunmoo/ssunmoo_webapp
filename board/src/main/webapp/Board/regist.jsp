<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel = "stylesheet" href="../css/board_css.css">
</head>
<body>

	<div class="container">
		<div class = "box1">
			<h3> 게시판 </h3>
			<table>
				<tr>
					<td> 제목 </td> <td> <input type="text" id="b_title"> </td>
				</tr>
				<tr>	
					<td > 내용 </td> <td> <input type="text" id="b_content"> </td>
				</tr>
				<tr>
					<td> 이름 </td> <td> <input type="text" id="b_name"> </td>
				</tr>
				<tr>
					<td> 비밀번호 </td> <td> <input type="password" id="b_pw"> </td>
				</tr>
				
			</table>
			<button onclick="regist()" class = "box1_btn"> 글등록 </button>
		</div>		
		
		<div class = "box2">
			<h3> 글목록 </h3>
			<table id = "board_list">
			</table>
			
			<br>
			<!-- 페이징처리 출력 박스 -->
			<div class="pagebox">
			</div>
			
		</div>
		
		<div class = "box3">	
			<h3> 글 상세보기 </h3>
			<div id = "b_select_view">
				
			</div>
			
			<div class = "box4">
			<!-- 
				<div class = "box5">
					<div class ="box4_title">↪ Re.</div>
					<div class = "box4_con">
						<input type ="text" id = "view_reply">
					</div>
				</div>
			
			 -->
				
			</div>
			<div class = "box6">
			</div>
			
			
		</div>

		
	</div>
	

<!--  헤더 제리쿼리 -->
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	
<script src="../js/regist.js" type="text/javascript"></script>
<script src="../js/board_list.js" type="text/javascript"></script>
<script src="../js/board_delete.js" type="text/javascript"></script>

 
</body>
</html>