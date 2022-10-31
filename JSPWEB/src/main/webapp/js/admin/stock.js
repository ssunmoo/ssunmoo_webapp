/*
	
	- 함수 : 함수명();
	- 익명함수 : function(인수){ }
	- 화살표함수 : 인수 => { }
	- 콜백함수 : 함수 실행 반환 결과를 콜백 함수에게 인수로 전달
		
	1. 함수1( 콜백 함수2(인수) ) : 함수안에 함수가 들어간 것 -> 콜백 함수	
		- 함수1에서 실행된 반환값을 콜백함수2의 인수로 전달
	2. 함수2( 인수 => function(인수){ } )
	3. 함수3( 인수 => 콜백함수4 )
	
	[ 활용 ]
	.addEventListener( '이벤트명', 함수 호출[1~3] ) : 이벤트 실행 후 결과 정보를 반환
	.forEach( 인수 => { } )
	
	== : 같다 [값만 비교]
	=== : 같다 [값과 자료형 비교]
	
*/

let productlist = null; // 모든 제품을 가지고있는 리스트 선언

let cselect = document.querySelector('.cselect'); 	// 카테고리 선택 상자
let pselect = document.querySelector('.pselect'); 	// 제품 선택 상자
let rows = document.querySelectorAll('.rows'); 		// 재고 등록 행(td)

// 1-1. 카테고리 선택을 클릭했을때 -> html 에서 온클릭 주는 것과 동일하나 결과값을 받아올 수 있음
cselect.addEventListener( "change", e => {
	let pcno = e.currentTarget.value	// 선택된 카테고리 번호 가져오기 
	getproduct( pcno );	// 선택된 카테고리 번호를 제품출력으로 넘기기
});
 
// 1-2. 제품 목록에서 선택을 했을때 재고 등록 html 구성 후 출력
pselect.addEventListener( "change", e => {
	let pno = e.currentTarget.value	// 선택된 카테고리 번호 가져오기 
	
	productlist.forEach( p => {
		
		if( p.pno == pno ){	// 해당 제품의 번호와 선택된 제품의 번호가 같으면
			rows[0].innerHTML = p.pcno;
			rows[1].innerHTML = p.pno;
			rows[2].innerHTML = p.pname;
			getstock(); // 제품을 클릭했을 때 제품 재고 메소드 호출
		}
	})
}); 


// 1. 페이지가 열리면 모든 카테고리 cselect에 넣어주기
getcategory()
function getcategory(){
	$.ajax({
		url : "/JSPWEB/board/pcategory",
		type : "GET",
		success : function( re ){
			let json = JSON.parse( re );
			
			let html = '';
			json.forEach( c => {
			// 배열 혹은 인덱스가 있는 리스트 : [객체].forEach( 반복변수명 , 인덱스, 배열객체명 => { 실행코드 })
				html += '<option value="'+c.pcno+'">'+c.pcname+'</option>'
			})
			cselect.innerHTML = html;
		}
	})
} // getcategory e

// 2. 선택된 카테고리 별 제품 리스트를 pselect에 넣어주기
function getproduct( pcno ){
	$.ajax({
		url 	: "/JSPWEB/admin/regist",
		data	: { "type" : 1 , "option" : "all" },	// 타입이 1이면 모든 제품 전체 출력  
		type 	: "get",			
		success : function( re ){
			productlist = JSON.parse( re );
			
			let html = '';
			productlist.forEach( p => {
				if( p.pcno == pcno ){ // 해당 제품의 카테고리 번호와 선택된 카테고리 번호가 같으면
					html += '<option value="'+p.pno+'" >'+p.pname+'</option>'
				}
			})
			pselect.innerHTML = html;
		}
	})
} // getproduct e



// 3. 재고 등록 버튼을 눌렀을 때
function setstock(){
	
	// 1. 등록할 테이터 구성
	let info = {
		psize : document.querySelector('.psize').value,
		pcolor : document.querySelector('.pcolor').value,
		pstock : document.querySelector('.pstock').value,
		pno : rows[1].innerHTML
	}

	// 2. 통신
	$.ajax({
		url		:"/JSPWEB/admin/stock",
		type	: "POST",
		data	: info,
		success	: re => {
			if( re == 'true'){
				alert('재고 등록 성공');
				getstock();
			}
			else{
				alert('재고 등록 실패');
			}
		} 
	})
} // setstock e

// 4. 제품별 재고 출력
function getstock(){
	
	$.ajax({
		url		:"/JSPWEB/admin/stock",
		type	: "GET",
		data	: { "pno" : rows[1].innerHTML },
		success	: re => {
			let json = JSON.parse( re )
			
			let html = '';
			html = '<tr>'
					+ '<th> 사이즈 </th> <th> 색상 </th> <th> 재고수량 </th> <th> 비고 </th>'	
					+ '</tr>'
			json.forEach( list => {
				html += '<tr>'
					+ '<td>'+ list.psize +'</td>'
					+ '<td>'+ list.pcolor +'</td>'
					+ '<td>'+ list.pstock +'</td>'
					+ '<td> - </td>'
					+ '</tr>'
			})
			document.querySelector('.getstock').innerHTML = html;
		}
	})
} // getstock e










