<%@page import="model.dto.BoardDto"%>
<%@page import="model.dao.BoardDao"%>
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
		<h3> 글 조회 </h3>
		<table class="table">
			<tr>
				<td> 번호 </td> <td class = "bno"> </td>
			</tr>
			<tr>	
				<td> 제목 </td> <td class = "btitle"> </td>
			</tr>
			<tr>	
				<td> 내용 </td> <td class = "bcontent"> </td>
			</tr>
			<tr>	
				<td> 작성자 </td> <td class = "mid"> </td>
			</tr>
			<tr>	
				<td> 첨부파일 </td> <td class = "bfile"> </td>
			</tr>
		</table>
		
		<div class="btnbox">
			<a href = "list.jsp"> 목록보기 </a>
		</div>
		
		<!-- 댓글 작성할 수 있는 틀 구성 -->
		<div class="replybox">
			<textarea rows="" cols="" class="rcontent"></textarea>
			<button type="button" onclick="rwrite()"> 댓글작성 </button>
		</div>
		
		<!-- 댓글을 출력할 수 있는 틀 -->
		<div class="replylist">
					
		</div>
		
		

	</div> 













	
<script src="../js/board/view.js" type="text/javascript"></script>
<script src="../js/board/bdelete.js" type="text/javascript"></script>
</body>
</html>

