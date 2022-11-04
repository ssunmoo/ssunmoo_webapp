

let cartlist = null; // 장바구니 리스트
let totalprice = 0; // 총 주문금액

// 1. 장바구니에 담긴 내용 출력
getcart()
function getcart(){
	
	$.ajax({
		url:"/JSPWEB/product/cart",
		type:"get",
		success: re => {
			cartlist = JSON.parse( re )
			// console.log(cartlist)
			
			let html = '<tr>'
				+ '<th width="5%"> <input type="checkbox"> </th>' 
				+ '<th width="10%"> 이미지 </th>'
				+ '<th width="40%"> 상품정보 </th>'
				+ '<th width="15%"> 수량 </th>'
				+ '<th width="20%"> 가격 </th>'
				+ '<th width="5%"> 비고 </th> '
			 	+ '</tr>'
			
			cartlist.forEach( c => {
				html += '<tr>'
				+ '<td> <input type="checkbox"> </td>'
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

// 회원정보 호출
let member = null;
getmember()
function getmember(){
	$.ajax({
		url 	: "/JSPWEB/member/info" ,
		success : re => {
			member = JSON.parse( re );
		}
	})
} // getmember e

/* 아임포트 결제 API */
function requestPay() {
	var IMP = window.IMP;   	// 생략 가능
	IMP.init("imp11138713");	// 내 식별코드 : 아임포트 관리자 페이지에서 확인가능
	
      IMP.request_pay({ 
          pg: "kakaopay",
          pay_method: "card",
          merchant_uid: "",  	// 주문번호 [ 1. 자동번호 , 2. 직접설정( 날짜+시간+mid+난수 ) ]
          name: cartlist[0].pname + ' 외 '+ cartlist.length+'건',
          amount: totalprice, 	// 숫자타입
          buyer_email: member.memail,
          buyer_name: member.mname,
          buyer_tel: member.mphone,
          buyer_addr: member.maddress,
          buyer_postcode: "01181"
      }, function (rsp) { // callback
          if (rsp.success) {
              // 결제 성공 시 로직,
              
          } else {
              // 결제 실패 시 로직 [ 테스트하는 것이기 때문에 실제 결제 못함 실패했을때 성공한걸로 처리하기 ],
           	alert('결제 못해 이걸로 만족해');
           	
          }
      });
    }  
  
  
  
  
  
  
  
  
  
  
  
  
