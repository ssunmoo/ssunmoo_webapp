
// cart.js 저장소에서 저장한 'checkplist' 이름의 객체 호출
let checkplist = JSON.parse(localStorage.getItem('checkplist'));
// console.log(localStorage.getItem('checkplist')); // 제이슨 문자열 확인
// console.log(checkplist); // 제이슨 문자열을 제이슨 객체로 변환한 것 확인

// 수령인 정보에 체크 여부에 따라 기존 정보 넣어줄지 말지 선택 -> 회원정보 호출 메소드가 있기 때문에 회원 정보 가져오기 가능
let checkbtn = document.querySelector('.checkbtn');
	
	checkbtn.addEventListener( 'click', (e) =>{ 
	if( e.currentTarget.checked == true ){ // 1. 체크박스를 체크했으면 기존 회원 정보 넣기
		document.querySelector('.oname').value = member.mname;	
		document.querySelector('.ophone').value = member.mphone;
		document.querySelector('.oaddress').value = member.maddress;
	} else{	// 2. 아니면 공백처리
		document.querySelector('.oname').value = '';	
		document.querySelector('.ophone').value = '';
		document.querySelector('.oaddress').value = '';
	}
});	// click e
	

// 로그인 되어있는 회원정보 호출
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


// 결제 수단 선택
let pmethod = null;
function paymethod( payM ) {
	pmethod = payM; // 선택된 결제방식을 pmethod에 저장
	alert(pmethod);
} // paymethod e

	
	
/* 아임포트 결제 API */
function requestPay() {	// payM : 매개변수로 받아서 매개변수에 따른 결제 방식 선택 가능
	var IMP = window.IMP;   	// 생략 가능
	IMP.init("imp11138713");	// 내 식별코드 : 아임포트 관리자 페이지에서 확인가능
	
      IMP.request_pay({ 
          pg: "kakaopay",
          pay_method: pmethod,
          merchant_uid: "",  	// 주문번호 [ 1. 자동번호 , 2. 직접설정( 날짜+시간+mid+난수 ) ]
          name: '',
          amount: '', // 숫자타입
          buyer_email: '',
          buyer_name: '',
          buyer_tel: '',
          buyer_addr: '',
          buyer_postcode: ''
      }, function (rsp) { // callback
          if ( rsp.success ) {
              // 결제 성공 시 로직,
          } else {
              // 결제 실패 시 로직 [ 테스트하는 것이기 때문에 실제 결제 못함 실패했을때 성공한걸로 처리하기 ],
           	alert('결제 못해 이걸로 만족해~');
           	setorder();
          }
      });
} // requestPay e


function setorder(){
	let oinfo = { // 수령인 객체
		oname : document.querySelector('.oname').value,
		ophone : document.querySelector('.ophone').value,
		oaddress : document.querySelector('.oaddress').value,
		orequest : document.querySelector('.orequest').value
	}
	$.ajax({
		url		: "/JSPWEB/product/order",
		data	: { "data" : JSON.stringify(checkplist), "oinfo" : JSON.stringify(oinfo) },
		type	: "post",
		success	: re => {
			if( re == 'true' ){
				alert('주문 완료');
				location.href = '/JSPWEB/product/ordersuccess.jsp';
				localStorage.removeItem('checkplist'); // 저장소 초기화
			} else{
				alert('주문 실패 [관리자 문의]')
			}
		}
		
	})
	
	
} // setorder e











/*
	oname;						// 수령인 이름
	ophone;						// 수령인 연락처
	oaddress;					// 수령인 주소
	orequest;					// 배송 메세지 
	odamount;					// 수량
    odprice;               		// 결제 금액 [ 결제 시 할인율 등이 달라질 수 있어서 넣음 ]
	pstno;						// 재고 번호
*/

