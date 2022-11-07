<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<style>
		td{
			line-height: 150%;
		}
		.cart_t td:nth-child(3) {
		 	padding-top: 20px;
		}
		.cart_t td:nth-child(1),.cart_t td:nth-child(4),.cart_t td:nth-child(5),.cart_t td:nth-child(6) {
		 	padding-top: 35px;
		}
		
	</style>
	


<head>
<meta charset="UTF-8">
</head>
<body>
	<%@include file="../header.jsp"%>
	
	<div class="container">
	
		<table class="table cart_t">
			<!-- 카트에 담은 제품 정보 출력될 자리 -->
		</table>	
		
		<button type="button"> 선택삭제 </button>
		<button type="button"> 전체삭제 </button>
		<button type="button"> 쇼핑하기 </button>
		<button onclick="payload()" type="button"> 결제하기 </button>
		
	</div>

















	<script src="/JSPWEB/js/product/cart.js" type="text/javascript"></script>
</body>
</html>