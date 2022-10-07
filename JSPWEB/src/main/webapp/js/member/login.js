
/* ---- HTML과 서블릿 통신 ---- */

// 0. 로그인 버튼을 눌렀을때 반복 실행 --> 함수

// 함수정의 : function( 함함 수명 매개변수 )
// onclick="함수명()"; 클릭했을때 함수 실행
function login() {
	// 1. html에 입력된 데이터 가져오기 [ DOM 객체 ]  
	let mid = document.querySelector('#mid').value;
	let mpw = document.querySelector('#mpw').value;
	let loginconfirmbox = document.querySelector('#loginconfirmbox');
	console.log( "111" );
	$.ajax({
		url: "/JSPWEB/member/login",
		data: { "mid": mid, "mpw": mpw },
		success : function(re) {
			console.log( "aaa" );
			if (re === '1') {
				alert('로그인 성공')
				location.href = '/JSPWEB/index.jsp';	/* js 하이퍼링크 */
			} 
			else if( re === '2' ){
				loginconfirmbox.innerHTML = '패스워드가 다릅니다.'
			}
			else if( re === '3' ){
				loginconfirmbox.innerHTML = '데이터베이스 오류.'
			}
			else if( re === '0' ){
				loginconfirmbox.innerHTML = '존재하지 않는 아이디 입니다.'
			}
			else {
				alert('로그인 실패')
				loginconfirmbox.innerHTML = '회원정보가 다릅니다.' /* 해당 id에 문자열 넣기 */
			}
		}
	});

}


	// 2. 받은 변수 2개를 서블릿으로 보내기[ jquery : JS 라이브러리 ]
	 // 1. ojaruy : 라이브러리 포함
	 // 2. AJAX : 비동기식 통신 시법
	 	// url : "통신경로"
	 	// data : 전송할 데이터 { 키 : 값 , 키 : 값}
		// success : function( 매개변수 ){ }




















/* ----  ---- */