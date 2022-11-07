

let cartlist = null; // 장바구니 리스트
let totalprice = 0; // 총 주문금액

getcart()

// 장바구니 체크 표시하기
let checkbtnlist = document.querySelectorAll('.checkbtn') // 1. 모든 체크박스 가져오기
checkbtnlist[0].addEventListener('click', (e) => {
	
	// 2. 첫번째 체크 박스를 체크할 경우 모든 체크 박스에 체크
		// e.currentTarget : 이벤트를 발생시킨 대상의 이벤트 정보를 가져올 수 있음
		// checked : 속성[ 체크여부 ] : 체크가 되어있으면
	if( e.currentTarget.checked == true ){ 
		checkbtnlist.forEach( c => {
			c.checked = true;	// 모든 체크 박스에 체크
		})
	} else{ // 아니면 체크박스에 모든 체크 해제
		checkbtnlist.forEach( c => {
			c.checked = false;	// 모든 체크 박스에 체크 해제
		})
	}
}) // click e



let checkplist = []; // 장바구니에서 선택한 제품만 저장하는 리스트

// 2. 장바구니에서 체크 된 제품만 결제 페이지로 이동
function payload(){
	
	checkbtnlist.forEach( ( c, i ) =>{			// 리스트를 돌려서
		if( i != 0 && c.checked == true ){ 		// 체크가 되어있는 경우
			checkplist.push( cartlist[i-1] ); 	// 0번 인덱스는 모든 체크 기능이므로 빼야 함
		}
	})	
	if( checkplist.length == 0 ){				// 만약에 체크된 제품이 없을 경우
		alert('1개 이상 선택해 주세요');
		return;
	}
	localStorage.removeItem('checkplist'); 		// 저장소 초기화
	// 저장소 생성 [ 'checkplist' 라는 이름으로 checkplist 객체 저장 ]
	localStorage.setItem( 'checkplist', JSON.stringify(checkplist) ); // JSON.stringify() 제이슨 문자열로 저장
	location.href = '/JSPWEB/product/pay.jsp';	
} // payload e



// 1. 장바구니에 담긴 내용 출력
function getcart(){
	
	$.ajax({
		url		:"/JSPWEB/product/cart",
		type	:"get",
		async	: false, // 결과가 있을때 까지 대기 상태
		success	: re => {
			cartlist = JSON.parse( re )
			// console.log(cartlist)
			
			let html = '<tr>'
				+ '<th width="5%"> <input type="checkbox" class="checkbtn"> </th>' 
				+ '<th width="10%"> 이미지 </th>'
				+ '<th width="40%"> 상품정보 </th>'
				+ '<th width="15%"> 수량 </th>'
				+ '<th width="20%"> 가격 </th>'
				+ '<th width="5%"> 비고 </th> '
			 	+ '</tr>'
			
			cartlist.forEach( c => {
				html += '<tr>'
				+ '<td> <input type="checkbox" class="checkbtn"> </td>'
				+ '<td> <img width="80%" src="/JSPWEB/admin/pimg/'+ c.pimg +'"> </td>'
				+ '<td> '+ c.pname +' <br> '+ c.pcolor +' / '+ c.psize +' </td>'
				+ '<td> '+ c.amount +' </td>'
				+ '<td> '+ (c.amount * ( c.pprice-( c.pprice * c.pdiscount ) )).toLocaleString() +'원</td>'
				+ '<td> <button> × </button> </td>'
				+ '</tr>'
				totalprice += c.amount * ( c.pprice-( c.pprice * c.pdiscount ) );
			})
			document.querySelector('.cart_t').innerHTML = html;
		}
	})
}



 
  
  
  
  
  
  
  
  
  
  
