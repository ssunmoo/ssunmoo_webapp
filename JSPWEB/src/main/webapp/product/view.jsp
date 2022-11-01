<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

	<meta charset="UTF-8">
	<link href="/JSPWEB/css/productview.css" rel="stylesheet">
</head>
<body>
	<%@include file="../header.jsp"%>
	
	<% 
		// 1. 경로에 있는 pno request 요청
		int pno = Integer.parseInt(request.getParameter("pno"));
	%>
	<input type="hidden" value="<%=pno%>" class="pno"> 
	<div class="container"> <!-- b: container -->
		
		<div class="row"> <!-- b: row 가로배치 -->
			<!-- 대표이미지 -->
			<div class="col-md-6"> <!-- b: 12그리드 중 6사용 -->
				<img class="pimg" alt="" src="/JSPWEB/img/pro01.jpg">	
			</div>
			<!-- 상품정보 -->
			<div class="col-md-6">
				<div class="infobox">
				
					<!-- 제품명 -->
					<h4 class="pname"> </h4>
					
					<!-- 제품설명 -->
					<div class="pcomment"> </div>
					
					<!-- 가격 -->
					<div class="pricebox"> <!-- 할인율이 있을 경우 -->
						<div class="pprice"> </div>
						<span class="pdisount">  </span> <!-- 할인율 -->
						<span class="psale"> </span> <!-- 판매가 -->
					</div>
					
					<!-- 사이즈 종류 -->
					<div class="sizebox">
						<span> [ 1/4, 2/4, 3/4, 4/4 ] </span>
					</div>
					
					<!-- 제품 옵션 -->
					<table class="table into_t"> <!-- b : table -->
						<tr> <td> 배송구분 </td> <td> 2,500원 (5만원 이상 구매시 무료배송) </td> </tr>
						<tr> <td> 카드혜택 </td> <td> 무이자 할부 </td> </tr>
						<tr> <td> 적립혜택 </td> <td> 3,000 (1% 적립) </td> </tr>
						
						<!-- 색상 선택 -->
						<tr class="colorbox">
							<td> 색상 </td>
							<td>
								<select class="cselect">
								
	
								</select>
							</td>
						</tr>
						<!-- 색상 선택 e -->
						
						<!-- 사이즈 선택 -->
						<tr>
							<td> 사이즈 </td>
							<td>
								<select class="sselect">
									<option> 사이즈 </option>
								
								</select>
							</td>	
						</tr>
						<!-- 사이즈 선택 e-->
					</table>
					
					<!-- 선택된 제품 창 -->
					<table class="table select_t">
						<!-- print() 출력 구역 -->
					</table>
					
					<!-- 선택된 제품들의 총 가격 -->
					<div class="row">
						<div class="col-md-6"> 총 상품 금액 </div>
						<div class="col-md-6 totalprice"> 40,000원 </div>	
					</div>
					
					<!-- 버튼 목록  -->
					<div class="btnbox">
						<button> 바로 구매 </button>
						<button> 장바구니 담기 </button>
						<button> 찜하기 🤍 </button> <!-- 로그인된 회원이 찜하기 누르기 전 -->
					</div>
					
				</div> <!-- infobox e -->
			</div>
		</div>	
		
	</div>

<script type="text/javascript" src="/JSPWEB/js/product/productview.js"></script>
</body>
</html>