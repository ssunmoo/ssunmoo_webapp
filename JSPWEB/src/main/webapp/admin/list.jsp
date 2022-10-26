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
		
		<%
			// 서블릿 [자바 코드를 입력할 수 있는 공간]
			ArrayList< ProductDto > list = new ProductDao().getProductlist();
					
		%>
		
		
		<table class="table">
			<tr>
				<th> 대표이미지 </th>
				<th> 제품번호 </th>
				<th> 카테고리 </th>
				<th> 제품명 </th>
				<th> 정상가 </th>
				<th> 할인율 </th>
				<th> 판매가[가격*할인율] </th>
				<th> 제품상태 </th>
				<th> 등록날짜 </th>
			</tr>



		</table>
	</div>






<%-- 		
		JS없이 이렇게도 출력 가능하다~~ 보여준 예시
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