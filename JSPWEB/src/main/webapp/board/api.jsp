<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%@include file="../header.jsp" %>

	<div class="container">	<!-- 부트스트랩 컨테이너 -->
		
		<!-- 3. 9월 서울 아파트 실 거래가 테이블 -->
		<table class="data2 table">
			<tr>
				<th> 시군구 </th>
				<th> 번지 / 본번 / 부번 </th>
				<th> 단지명 </th>
				<th> 전용면적 </th>
				<th> 계약년월 </th>
				<th> 계약일 </th>
				<th> 계약금액(만원) </th>
				<th> 층 </th>
				<th> 건축년도 </th>
				<th> 도로명 </th>
				<th> 해제사유발생일 </th>
				<th> 거래유형 </th>
				<th> 중개사소재지 </th>
			</tr>
			
		</table>
			
		
		
		
		<!-- 1. 지도를 표시할 div API -->
		<div id="map" style="width:100%;height:350px;"></div>
		<!--  -->
		
		<!-- 2. 약국 상세 정보 div -->
		<div class="detailbox">
			
		</div>
		
		<div class="row">	<!--  부트스트랩 css 속성 -->
			<div class="col-sm-3">	<!--  부트스트랩 css 속성 12조각 중 3그리드 사용 -->
				<input type="text" class="form-control addrinput"> <!--  부트스트랩 css 속성 -->
			</div>
			
			<div class="col-sm-1">	<!--  부트스트랩 css 속성 12조각 중 1그리드 사용 -->
				<button type="button" class="btn" onclick="addrsearch()"> 검색 </button> <!--  부트스트랩 css 속성 -->
			</div>
		</div>
		
		
		<table class="table data1">	<!-- 부트스트랩 테이블 -->
			
		</table>
		
	</div>


	
	<!-- 지도 api 가져오기 -->
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=971b65d363651896c4786950c2402af6&libraries=services"></script>
	
	<script type="text/javascript" src="../js/board/api.js"></script>

</body>
</html>