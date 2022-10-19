<%@page import="model.dao.BoardDao"%>
<%@page import="model.dto.BoardDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- 부트스트랩 CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">


</head>
<body>

	<%@include file="../header.jsp" %>
	<div class="webbox">
		
		<a href="write.jsp"> 글쓰기 </a>
		
		<!-- 1. jsp로 테이블 표시 [ HTML(jsp) -> 서블릿 x -> Dao ] -->

<%-- 		<table>
			<tr>
				<th> 번호 </th>
				<th> 제목 </th>
				<th> 작성자 </th>
			</tr>
			<%	// <% :스크립트 태그 : HTML에 Java를 작성할 수 있는 공간
			ArrayList<BoardDto> list = BoardDao.getInstance().getlist();	
			
			for( int i = 0; i < list.size(); i++ ){
			%>	
				<tr>
					<td> <%=list.get(i).getBno() %> </td>
					<td> <%=list.get(i).getBtitle() %> </td>
					<td> <%=list.get(i).getMno() %> </td>
				</tr>
			<%
			}		// <%= : 표현식(호출)
			%>
			
		</table>
 --%>	
		
		<!-- js로 테이블 표시 [ HTML(jsp) -> js -> 서블릿 -> Dao ] -->
		
		<!-- 5. 게시물 수 표시 -->
		<div> 게시물 수 : <span class="totalsize"> </span> </div>
		
		<!-- 6. 화면에 표시할 게시물 수 -->
		<div>
			<select class="listsize" onchange="blistsize()">
				<option vlaue="5"> 5 </option>
				<option vlaue="10"> 10 </option>
				<option vlaue="15"> 15 </option>
				<option vlaue="20"> 20 </option>
			</select>
		</div>
		
		<!-- 1. 게시물 출력 부분  -->
		<table class = "btable table" >
			<tr>
				<th> 번호 </th>
				<!-- 제목 클릭 시 페이지 이동 -->
				<th> 제목 </th>
				<th> 작성자 </th>
				<th> 작성일 </th>
				<th> 조회수 </th>
			</tr>
			
		</table>
		
		<!-- 페이징 처리 출력 부분 -->
		<div class="pagebox"> 
		</div>
		
		
		<!-- 4. 검색 처리 출력 부분 -->
		<div> 
			<select class="key">
				<option value="b.btitle"> 제목 </option>
				<option value="b.bcontent"> 내용 </option>
				<option value="m.mid"> 작성자 </option>
			</select>
			<input class="keyword" type="text" placeholder="검색어">
			<button type="button" onclick="bsearch()"> 검색 </button>
		</div>
		
	</div>




















<!-- 부트스트랩 JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>

<script src="../js/board/list.js" type="text/javascript"></script>
</body>
</html>