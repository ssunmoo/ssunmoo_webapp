
// 공통 전역 변수 [ 여러 함수에서 공유해서 사용하기 위해 ]
let stock = null; 		// 재고목록
let product = null; 	// 제품
let color = null;		// 선택한 색상
let productlist = [];	// 선택된 제품 옵션[색상,사이즈,수량] 리스트 선언
let psale = 0; 			// 할인율이 적용된 판매가

// ** 현재 페이지내 제품 번호[a href="링크?pno=제품번호"]를 가지고와서
// ajax로 해당 제품 번호의 모든 정보를 가져오기
let pno = document.querySelector('.pno').value


// --------------------------[ 이벤트 처리 부분 s ]------------------------------------- //

// 1. 색상 select 박스를 체인지 했을 때 이벤트 
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


// 2. 사이즈 select 박스를 체인지했을 때 이벤트
document.querySelector('.sselect').addEventListener('change' , (e)=>{
	let size = e.currentTarget.value;
	
	// 1. 안내 문구 선택 시 함수 종료
	if( size == '사이즈'){
		return;
	}
	
	// 2. 이미 존재한 옵션을 다시 선택한 경우 해당 옵션의 수량을 증가하고 함수 종료
	for( p of productlist ){
		if( p.pcolor == color && p.psize == size ){ // 동일한 것 찾아서 수량으로 증가
			p.amount++;
			print();
			return;
		}
	}
	
	// 3. 선택된 제품 정보와 옵션을 리스트에 객체로 담기
	let sproduct = {
		pcolor	: color,
		psize	: size,
		amount	: 1
	}
	
	// 리스트에 담아서 출력
	productlist.push( sproduct );
	print() // 리스트에 존재하는 객체를 출력	

}) // change e


// 3. 찜하기 버튼 눌렀을 때
let btnlike = document.querySelector('.btnlike');
btnlike.addEventListener('click',  (e)=>{
	
	// 1. 로그인 유무 판단 [ 1. ajax 통신으로 세션 유무 확인 *2. HTML에서 가지고오기 ]
	let mid = document.querySelector('.mid').value; // html에서 mid 가져오기
	if ( mid == 'null' ){ // 로그인이 안되어있으면
		alert('로그인 후 가능한 기능입니다.');
		return;
	}
	
	// 2. 찜하기 등록 혹은 삭제 처리
		$.ajax({
			url		: "/JSPWEB/product/plike",
			type	: "post",
			data	: { "pno" : pno },
			success	: re =>{
				if( re == '1'){ 		// 찜하기 취소
					alert('찜하기 취소')					
					 btnlike.innerHTML = '찜하기🤍';	
				}else if( re == '2'){	// 찜하기 등록 
					alert('찜하기 성공')
					 btnlike.innerHTML = '찜하기💖';
				}else{	// 오류
					alert('DB 오류')
				}
			}
		})
}) // click e





// --------------------------[ 이벤트 처리 부분 e ]------------------------------------- //



// js 오픈 시 최초로 함수 1번 실행
getproduct( pno );	// 제품 정보 호출 [ pno 필요 ] 
getstock( pno );	// 제품 재고 호출 [ pno 필요 ] 
sethtmlprint();		// 위 메소드 안에 있는 ajax가 모두 실행된 후에 pring 실행


// 1. 해당 제품 번호의 제품 정보 호출
function getproduct( pno ){
	$.ajax({ // 결과와 상관 없이 다음 코드 진행 [ async : true 결과를 기다리지 않고 실행 VS async : false 결과를 받아온 후 실행 ]
		url	:"/JSPWEB/admin/regist",
		type	: "get",
		async	: false, // 웨이팅 : 결과가 있을때까지 다른거 실행 막겠다
		data	:{ "type" : 2 , "pno" : pno },
		success	: re => {
			product = JSON.parse( re );
		}	
	})
} // getproduct e
	
// 2. 해당 제품의 정보를 HTML에 대입하는 메소드
function sethtmlprint(){
	
	// 1. 제품 사진 대입
	document.querySelector('.pimg').src = "/JSPWEB/admin/pimg/"+product.pimg; 
	// 2. 제품명 대입
	document.querySelector('.pname').innerHTML = product.pname; 
	// 3. 제품 내용
	document.querySelector('.pcomment').innerHTML = product.pcomment; 
	
	// 4. 가격 대입
	let phtml = '';
	if( product.pdiscount == 0 ) { // 4-1. 할인이 없을 때 [ 천단위 쉼표 함수 : 데이터.toLocaleString()]
		psale = product.pprice;
		phtml += '<span class="psale">'+ psale.toLocaleString() +'</span>'
			
			
	}else { // 4-2. 할인이 있을 때	// Math.round : 소수점 버리고 반올림
		psale = ( product.pprice - (product.pprice * product.pdiscount ))
		phtml += '<div class="pprice"> '+ ( product.pprice.toLocaleString() ) +'원 </div>' 
			+ '<span class="pdisount"> '+ Math.round(product.pdiscount * 100) +'% </span>'	
			+ '<span class="psale"> '+ psale.toLocaleString() +'원 </span>'			
	}
	document.querySelector('.pricebox').innerHTML = phtml;
	
	// ----------------------------------------------------------------------- //
	
	// * 사이즈 목록 중복제거 *
	let sizelist = [];					// 1. 중복 값을 담을 배열 선언 
	stock.forEach( s => {
		sizelist.push( s.psize ) });	// 2. 중복 제거가 필요한 내용을 리스트에 담기
	
	// 2. 사이즈 목록 중복 제거
	let sizeset = new Set( sizelist )	// 3. 사이즈 리스트 => Set 목록 변경 [ 중복제거 ]
	console.log( sizeset )
					
	// 4. 사이즈 종류
	let shtml = '<span> [ '
	sizeset.forEach( s => {
		shtml +=  " " + s + " " ;
	})
	shtml += ' ] </span>'				
	document.querySelector('.sizebox').innerHTML = shtml;

	// 5. 색상 select 구성
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
	
} // sethtmlprint e
	
	
// 3. 해당 제품의 재고 목록 호출	
function getstock( pno ){
	$.ajax({
		url		: "/JSPWEB/admin/stock",
		type	: "get",
		async	: false,
		data	:{ "pno" : pno },
		success	: re => {
			stock = JSON.parse(re)
		}
	})
} // getstock e



// 4. 선택된 제품 옵션을 출력하는 메소드 [ 1. 사이즈를 선택했을때 2. 옵션을 제거했을때 마다 실행]
function print(){
	
	let ohtml = '<tr>'
			+ '<th width="55%"> 상품명/옵션 </th>'				
			+ '<th width="25%"> 수량 </th>'				
			+ '<th width="30%"> 가격 </th>'				
			+ '</tr>';
			
	let totalprice = 0;		// 선택한 옵션의 총 금액 [전체판매가]
	let totalamount = 0;	// 선택한 옵션의 총 수량 [전체수량]
	
	productlist.forEach( ( p, i ) =>{
		let tsale = psale * p.amount	// 할인이 적용된 판매가 * 수량
		let tpoint = Math.round(tsale * 0.01)		// ( 판매가 * 수량 ) * 1%
		
		totalprice += tsale		// 각 옵션별 판매가를 전체 판매가에 누적 더하기
		totalamount += p.amount // 각 옵션별 수량을 전체 수량에 누적 더하기
		
		ohtml += '<tr>'
			+ '<td>'	
			+ '<span>'+ product.pname +'</span>'	
			+ '<br>'	
			+ '<span>'+p.pcolor+' / '+p.psize+'</span>'	
			+ '</td>'	
			+ '<td>'	
			+ '<div class="row g-0">'		
			+ '<div class="col-md-4">'						
			+ '<input readonly="readonly" class="form-control" value="'+p.amount+'">'							
			+ '</div>'						
			+ '<div class="col-md-4"> <!-- 수량 버튼 구역 -->'						
			+ '<button class="amonut_btn" onclick="amountup('+i+')"> ▲ </button>'							
			+ '<button class="amonut_btn" onclick="amountdown('+i+')"> ▼ </button>'							
			+ '</div>'						
			+ '<div class="col-md-1"> <!-- 취소 버튼 -->'						
			+ '<button class="cancel_btn" onclick="pcancel('+i+')"> x </button>'							
			+ '</div>'						
			+ '</div>'					
			+ '</td>'				
			+ '<td>'				
			+ '<span>'+tsale.toLocaleString()+'원</span><br>'					
			+ '<span class="pointbox">(포인트) '+tpoint.toLocaleString()+'</span>'					
			+ '</td>'				
			+ '</tr>'			
	}) // for e
	document.querySelector('.select_t').innerHTML = ohtml;
	let tohtml = totalprice.toLocaleString()+'원 ('+ totalamount +'개)';
	document.querySelector('.totalprice').innerHTML = tohtml;
} // print e


// 5. 수량 증가 버튼을 눌렀을 때 [ 현재 재고까지만 가능 ]
function amountup( i ){ // 무엇을 증가할 것인지 식별해야하기 때문에 i값을 파라미터로 받아오기
	
	// 최대 재고 수량
	let maxstock = 0;
	
	// 선택한 옵션의 재고 찾기
	stock.forEach( s => {
		if( s.pcolor == productlist[i].pcolor && s.psize == productlist[i].psize ){ // 재고 목록에서 찾은 옵션과 선택한 옵션이 일치하면
			maxstock = s.pstock // 재고 대입
		}
	})
	
	if( productlist[i].amount >= maxstock ){
		alert('재고가 부족합니다.');
		return;
	}
	productlist[i].amount++;
	print();
} // amountup e


// 6. 수량 감소 버튼을 눌렀을 때
function amountdown( i ){
	if( productlist[i].amount <= 1){
		alert('최소 구매 수량 입니다.');
		return;
	}
	productlist[i].amount--;
	print();
} // amountdown e

// 7. 선택된 제품 제거
function pcancel( i ){
	productlist.splice( i, 1 );	// splice() : 잘라내기 i번째부터 1개의 인덱스 자르기
	print();					// 변경 사항 다시 보여줘야하니까 프린트 호출
} // pcancel e

// 배열에 객체 추가 배열.push() 
// 배열에 객체 삭제 배열.splice( 인덱스, 삭제할갯수 )





