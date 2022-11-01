
// 공통 변수
let stock = null;



// 1. 현재 페이지내 제품 번호[a href="링크?pno=제품번호"]를 가지고와서
// ajax로 해당 제품 번호의 모든 정보를 가져오기

let pno = document.querySelector('.pno').value

$.ajax({

	url	:"/JSPWEB/admin/regist",
	type	: "get",
	data	:{ "type" : 2 , "pno" : pno },
	success	: re => {
		let product = JSON.parse( re );
	
		// 1. 제품 사진 대입
		document.querySelector('.pimg').src = "/JSPWEB/admin/pimg/"+product.pimg;
		// 2. 제품명 대입
		document.querySelector('.pname').innerHTML = product.pname;
		// 3. 제품 내용
		document.querySelector('.pcomment').innerHTML = product.pcomment;
		
		// 4. 가격 대입
		let phtml = '';
		if( product.pdiscount == 0 ) { // 4-1. 할인이 없을 때 [ 천단위 쉼표 함수 : 데이터.toLocaleString()]
			phtml += '<span class="psale">'+ ( product.pprice.toLocaleString() ) +'</span>'
				
				
		}else { // 4-2. 할인이 있을 때	// Math.round : 소수점 버리고 반올림
			phtml += '<div class="pprice"> '+ ( product.pprice.toLocaleString() ) +'원 </div>' 
				+ '<span class="pdisount"> '+ Math.round(product.pdiscount * 100) +'% </span>'	
				+ '<span class="psale"> '+ ( product.pprice - (product.pprice * product.pdiscount )).toLocaleString() +'원 </span>'			
		}
		document.querySelector('.pricebox').innerHTML = phtml;
		
		// 5. 해당 제품의 재고 목록 호출
		$.ajax({
			url		: "/JSPWEB/admin/stock",
			type	: "get",
			data	:{ "pno" : pno },
			success	: re => {
				stock = JSON.parse(re)
			
				// * 사이즈 목록 중복제거 *
					// 1. 사이즈 목록
				let sizelist = [];					// 1. 중복 값을 담을 배열 선언 
				stock.forEach( s => {
					sizelist.push( s.psize ) });	// 2. 중복 제거가 필요한 내용을 리스트에 담기
					// 2. 사이즈 목록 중복 제거
				let sizeset = new Set( sizelist )	// 3. 사이즈 리스트 => set 목록 변경 [ 중복제거 ]
				console.log( sizeset )
								
				// 6. 사이즈 종류
				let shtml = '<span> [ '
				sizeset.forEach( s => {
					shtml +=  " " + s + " " ;
				})
				shtml += ' ] </span>'				
				document.querySelector('.sizebox').innerHTML = shtml;
		
				// 7. 색상 select 구성
				let colorlist = [];
				stock.forEach( c => {
					colorlist.push( c.pcolor ) });
				
				let colorset = new Set( colorlist );
				console.log( colorlist )
				
				let chtml = '<option> 색상 </option>';
				colorset.forEach( c => {
					chtml += '<option value="'+ c +'"> '+ c +' </option>'
				})		
				document.querySelector('.cselect').innerHTML += chtml;
			} // 2번 s e
		})	// 2번 ajax e
		
	} // 1번 re e
}) // 1번 ajax e

let color = null;		// 선택한 색상
let sproductlist = [];	// 선택된 제품 옵션[색상,사이즈,수량] 리스트 선언
// 색상 select 박스를 체인지 했을 때 이벤트 
document.querySelector('.cselect').addEventListener('change' , (e) =>{
	color = e.currentTarget.value; // 이벤트를 발생한 객체[cselect]에 담겨져있는 값
	
	// 8. 색상 select에서 선택된 색상의 사이즈 select 구성
	let shtml = '' 
	stock.forEach( s => {
		if( s.pcolor == color ){ // 재고 목록 중 색상과 선택된 색상이 같으면
			shtml += '<option value="'+s.psize+'"> '+ s.psize +' </option>'
		}
	})
	document.querySelector('.sselect').innerHTML = shtml;
	
}) // change e


// 사이즈 select 박스를 체인지했을 때 이벤트
document.querySelector('.sselect').addEventListener('change' , (e)=>{
	let size = e.currentTarget.value;
	
	// 선택된 제품 정보와 옵션을 리스트에 객체로 담는다
	let sproduct = {
		pcolor	: color,
		psize	: size,
		amount	: 1
	}
	// 리스트에 담기
	sproductlist.push( sproduct );
	print() // 리스트에 존재하는 객체를 출력	

}) // change e

// 2. 선택된 제품 옵션 리스트를 출력하는 메소드 [ 1. 사이즈를 선택했을때 2. 옵션을 제거했을때 마다 실행]
function print(){
	
	let ohtml = '<tr>'
			+ '<th width="55%"> 상품명/옵션 </th>'				
			+ '<th width="25%"> 수량 </th>'				
			+ '<th width="30%"> 가격 </th>'				
			+ '</tr>';
	sproductlist.forEach( p =>{
		ohtml +=	'<tr> '
			+ '<td>'	
			+ '<span> 삼익 바이올린 입문용 풀세트 </span>'	
			+ '<br>'	
			+ '<span> 블랙 / 1/4 </span>'	
			+ '</td>'	
			+ '<td>'	
			+ '<div class="row g-0">'		
			+ '<div class="col-md-3">'						
			+ '<input class="form-control" value="1">'							
			+ '</div>'						
			+ '<div class="col-md-4"> <!-- 수량 버튼 구역 -->'						
			+ '<button class="amonut_btn"> ▲ </button>'							
			+ '<button class="amonut_btn"> ▼ </button>'							
			+ '</div>'						
			+ '<div class="col-md-1"> <!-- 취소 버튼 -->'						
			+ '<button class="cancel_btn"> x </button>'							
			+ '</div>'						
			+ '</div>'					
			+ '</td>'				
			+ '<td>'				
			+ '<span> 20,000원 </span><br>'					
			+ '<span class="pointbox"> (포인트) 2,000 </span>'					
			+ '</td>'				
			+ '</tr>'			
	})
		document.querySelector('.select_t').innerHTML = ohtml;
} // print e













