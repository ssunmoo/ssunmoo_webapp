<%@page import="model.dto.ProductDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.dao.ProductDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div class="container">
		
		<table class="table">
			<tr>
				<th style= "width:5%"> 대표이미지 </th>
				<th style= "width:10%"> 제품번호 </th>
				<th style= "width:10%"> 카테고리 </th>
				<th style= "width:10%"> 제품명 </th>
				<th style= "width:10%"> 정상가 </th>
				<th style= "width:10%"> 할인율 </th>
				<th style= "width:10%"> 판매가 </th>
				<th style= "width:10%"> 제품상태 </th>
				<th style= "width:15%"> 등록날짜 </th>
				<th style= "width:10%"> 비고 </th>
			</tr>

		</table>
	</div>






<%-- 		
		JS없이 이렇게도 출력 가능하다~~ 보여준 예시
		<%
			// 서블릿 [자바 코드를 입력할 수 있는 공간]
			ArrayList< ProductDto > list = new ProductDao().getProductlist();
					
		%>
		
		<%
			for( int i = 0; i < list.size(); i++ ){
		%>		
			<tr>
				<td><%=list.get(i).getPname() %></td>			
				<td><img alt="" src="/JSPWEB/admin/pimg/<%=list.get(i).getPimg() %>">  </td>
			</tr>
		<%		
			}
		%>
--%>


<script type="text/javascript" src="../js/admin/list.js"></script>

</body>
</html>