<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel = "stylesheet" href = "../css/signup.css">
</head>
<body>
	
	
	<!-- 헤더 페이지 호출  -->
	<%@include file = "../header.jsp" %>
	<!-- 세션을 이용한 페이지 제어  -->
	<%
		// header.jsp 파일의 변수 호출 
		if( loginid == null ){
			response.sendRedirect("login.jsp"); 
		}
	%>
	
	<!-- 본문 -->
	
	<div class="webbox">
		<form class ="signupform" action="/JSPWEB/member/signup2" method="post">
		
		<h2 class = "page_title"> [ 회원정보 ] </h2>
		<h3 class = "part_title"> 기본정보 </h3>
		<!-- name : form 사용, id : js 사용 -->
		
		<table class = "signup_table">
			<tr>
				<td class = "col1"> 회원번호 </td>
				<td class = "col2" id = "mno"> </td>
				<td class = "col3"> </td>			
			</tr>

			<tr>
				<td class = "col1"> 가입일 </td>
				<td class = "col2" id = "mdate"> </td>
				<td rowspan="2" class = "col3"> </td>			
			</tr>
			
			<tr>
				<td class = "col1"> 포인트 </td>
				<td class = "col2" id = "mpoint"> </td>
				<td rowspan="2" class = "col3"> </td>			
			</tr>
			
			<tr>
				<td class = "col1"> 아이디 </td>
				<td class = "col2" id = "mid">  </td>
				<td class = "col3"> </td>			
			</tr>
			
			<tr>
				<td class = "col1"> 비밀번호 </td>
				<td class = "col2"> <input readonly="readonly" type="password" name = "mpw" id = "mpw"> </td>
				<td class = "col3"> <button type="button"> 수정 </button> </td>				
			</tr>
			
			<tr>
				<td class = "col1"> 이름 </td>
				<td class = "col2"> <input readonly="readonly" type="text" name = "mname"  id = "mname"> </td>
				<td class = "col3"> <button type="button" onclick="update_action()"> 수정 </button> </td>			
			</tr>
			
			<tr>
				<td class = "col1"> 전화번호 </td>
				<td class = "col2"> <input readonly="readonly" type="text" name = "mphone" id = "mphone"> </td>
				<td class = "col3"> <button type="button"> 수정 </button> </td>			
			</tr>
			
			<tr>
				<td class = "col1"> 이메일 </td>
				<td class = "col2"> <input readonly="readonly" type="text" name = "memail" id = "memail"> </td>
				<td class = "col3"> <button type="button"> 수정 </button> </td>			
			</tr>
			
			<tr>
				<td rowspan="2" class = "col1"> 주소 </td>
				<td colspan="2" class = "col2">
				<span class="address_btn1">
					<input readonly="readonly" type="text" id="sample4_postcode" placeholder="우편번호" name = "address1">
					<input readonly="readonly" type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기"><br>
				</span>
				
				<span class="address_btn2">
					<input readonly="readonly" type="text" id="sample4_roadAddress" placeholder="도로명주소" name = "address2">
					<input readonly="readonly" type="text" id="sample4_jibunAddress" placeholder="지번주소" name = "address3">
				</span>
				</td>
			</tr>
			
			<tr>
				<td class = "col2"> <input readonly="readonly" type="text" id="sample4_detailAddress" placeholder="상세주소" name = "address4"> </td>
				<td class = "col3" > <button type="button"> 수정 </button> </td>			
			</tr>
			
		</table>
		
		<div class="signup_btnbox">
			<button type="button" onclick="form_submit()"> 회원탈퇴 </button>
		</div>
		
		</form>
	</div>
	
	
	<!--
	<br>
	<div class = "webbox">
	<h3> [ 회원 목록 ] </h3>
		<table id = "memberlisttable">
			
		</table>
	</div>
	  -->

	<!-- JS -->
	<script src="../js/member/info.js" type="text/javascript"></script>
	
</body>
</html>