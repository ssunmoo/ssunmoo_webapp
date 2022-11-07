<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<%@include file="../header.jsp"%>
	<div class="container">
		
		<h5> 수령인 정보 </h5>
		<input type="checkbox" class="checkbtn"> 회원과 동일
		
		<form>
			이름 <input type="text" class="oname"> <br>
			연락처 <input type="text" class="ophone"> <br>
			주소 <input type="text" class="oaddress"> <br>
			배송메세지 <input type="text" class="orequest"> <br>
			<button type="button" onclick="paymethod('card')"> 신용카드 결제 </button>
			<button type="button" onclick="paymethod('phone')"> 핸드폰 결제 </button>
			<button type="button" onclick="paymethod('trans')"> 계좌이체 </button><br>
			<button type="button" onclick="requestPay()"> 결제하기 </button>
		</form>
		
		
	</div>
	
	
	<!-- 아임포트 결제 API -->
	<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.2.0.js"></script>
	
	<script src="/JSPWEB/js/product/pay.js" type="text/javascript"></script>
</body>
</html>