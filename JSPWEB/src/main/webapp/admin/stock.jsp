<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>

	<div class="container"> <!-- 부트스트랩 -->
	
		<div class="row my-3"> <!-- row : 하위 태그 가로배치 flax랑 같음 -->
			<h3> 재고 관리 </h3>
			<div class="col-md-4"> <!-- form-select : width:100% vs col-md-4 : width 100%중에 40% -> 두개 같이 못 씀 -->
				<select class="cselect form-select">
					<option> 카테고리 선택 </option>	
				</select>	
			</div>
			
			<div class="col-md-4"> <!-- col-md-4 : 12그리드 중 숫자만큼 사이즈 사용 -->
				<select class="pselect form-select">
					<option> 제품명 선택 </option>
				</select>
			</div>
		</div>
		
		<div class="row my-3"> <!-- my : 마진 y축, mx : 마진 x축 -->
			<div class="col-md-6">
				<h3> 재고 등록 </h3>
				<table class="table"> <!-- 부트스트랩 테이블 형식 -->
					<tr>
						<td style="width:20%"> 카테고리번호 </td> <td class="rows">  </td>
					</tr>
					<tr>
						<td style="width:20%"> 제품번호 </td> <td class="rows">  </td>
					</tr>
					<tr>
						<td style="width:20%"> 제품명 </td> <td class="rows">  </td>
					</tr>
					<tr>
						<td style="width:20%"> 사이즈 </td> <td class="rows"> <input type="text" class="psize form-control"> </td>
					</tr>
					<tr>
						<td style="width:20%"> 색상 </td> <td class="rows"> <input type="text" class="pcolor form-control"> </td>
					</tr>
					<tr>
						<td style="width:20%"> 재고수량 </td> <td class="rows"> <input type="text" class="pstock form-control"> </td>
					</tr>
					<tr>
						<td colspan="2"> <button onclick="setstock()" type="button" class="form-control"> 등록 </button> </td>
					</tr>
					
				</table>
			</div>
			
			<div class="col-md-6">
				<h3> 재고 출력 </h3>
				<table class="table getstock"> <!-- 부트스트랩 테이블 형식 -->
				
				</table>
			</div>
		</div>
		
	</div>















<script type="text/javascript" src="../js/admin/stock.js"></script>
</body>
</html>