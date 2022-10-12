
/* 정규 표현식 : 문자의 특정 규칙, 패턴, 집합을 표현할 때 사용하는 언어 */

// 0.아이콘
let sicon = '<i class="fas fa-check-circle"></i>';
let bicon = '<i class="fas fa-ban"></i>';


// 1. col3 div 모두 가져오기
let col3 = document.querySelectorAll('.col3')	// All -> 배열로 가져옴


/* ---- 아이디 ---- */
function mevent1(){										// 1. 아이디 입력[keyup]시 이벤트 발생 = 메소드 실행
	let mid = document.querySelector("#mid").value;		// 2. 입력 받은 아이디 호출
	let midj = /^[a-z0-9]{5,20}$/;						// 3. 정규 표현식 작성
	if( midj.test(mid) ){								// 4. 정규표현식에 알맞으면
		$.ajax({										// 5. 아이디 중복 체크 실행 [ 비동기식 ]
			url : "/JSPWEB/member/idcheck",
			data : { "mid" : mid } ,					// 서블릿으로 데이터 보내기
			success : function( result ){ 				// 서블릿에서 데이터 받기
				if( result === 'true' )	{
					col3[0].innerHTML = bicon + '사용중인 아이디입니다';
				}		
				else{
					col3[0].innerHTML = sicon;
				}
			} // success 메소드 종료
		}) // ajax 종료
	} // if 종료
	else{	// 정규 표현식에 알맞지 않으면
		col3[0].innerHTML = bicon + '소문자/숫자 조합 5~20글자 입력';
	}
} // mevent1 메소드 종료


/* ---- 비밀번호 ---- */
function mevent2(){
	let mpw = document.querySelector("#mpw").value;
	let mpwj = /^[a-zA-Z0-9]{8,20}$/;
	if( mpwj.test(mpw) ){
		col3[1].innerHTML = sicon;
		mevent3();	// 한번 더 체크
	}
	else{
		col3[1].innerHTML = bicon + '영대소문자/숫자 조합 8~20글자 입력';
	}
} // mevent2 메소드 종료

/* ---- 비밀번호 확인 ---- */
function mevent3(){
	let mpw = document.querySelector("#mpw").value;
	let mpwconfirm = document.querySelector("#mpwconfirm").value;
	let mpwj = /^[a-zA-Z0-9]{8,20}$/;
	
	if( !mpwj.test(mpwconfirm) ){	// 정규표현식이 다르면
		col3[1].innerHTML = bicon + '영대소문자/숫자 조합 8~20글자 입력';
	}
	else if( mpwconfirm != mpw ){	// 두 비밀번호가 다르면
		col3[1].innerHTML = bicon + '비밀번호가 다릅니다';
	}
	else{							// 정규표현식도 맞고 두비밀번호가 맞으면
		col3[1].innerHTML = sicon;
		mevent2();	// 한번더 체크
	}
} // mevent3 메소드 종료


/* ---- 이름 ---- */
function mevent4(){
	let mname = document.querySelector("#mname").value;
	let mnamej = /^[a-zA-Z가-힣]{2,20}$/
	if( mnamej.test(mname) ){
		col3[2].innerHTML = sicon;
	}
	else{
		col3[2].innerHTML = bicon + '영대소문자 혹은 한글 2~20글자 입력';
	}
} // mevent4 메소드 종료

/* ---- 전화번호 ---- */
function mevent5(){
	let mphone = document.querySelector("#mphone").value;
	let mphonej = /^([0-9]{2,3})-([0-9]{3,4})-([0-9]{3,4})$/
	if( mphonej.test(mphone) ){
		col3[3].innerHTML = sicon;
	}
	else{
		col3[3].innerHTML = bicon + 'xxx-xxxx-xxx 형식으로 입력';
	}
} // mevent5 메소드 종료


/* ---- 이메일 ---- */
function mevent6(){
	let memail = document.querySelector("#memail").value;
	let memailj = /^[a-zA-Z0-9+-_.]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-]+$/
	if( memailj.test(memail) ){
		
		$.ajax({
			url : "/JSPWEB/member/emailcheck",
			data : {"memail" : memail },
			success : function( result ){
				if( result === 'true' ){
					col3[4].innerHTML = bicon + '사용중인 이메일 입니다';
				}
				else{
					col3[4].innerHTML = sicon;
				}
			} // success 메소드 종료
			
		})

		col3[4].innerHTML = sicon;
	}
	else{
		col3[4].innerHTML = bicon + '이메일 형식으로 입력';
	}
} // mevent6 메소드 종료


/* ---- 주소 ---- */

let sample4_postcode = document.querySelector("#sample4_postcode");
let sample4_roadAddress = document.querySelector("#sample4_roadAddress");
let sample4_jibunAddress = document.querySelector("#sample4_jibunAddress");
let sample4_detailAddress = document.querySelector("#sample4_detailAddress");

function address_check( 이벤트 ){
	let 값변수 = 이벤트.currentTarget.value;
	if ( 값변수.indexOf(',') != -1 ){
		col3[5].innerHTML = bicon + '주소에 [쉼표] 입력 불가능';
	}
	else{
		col3[5].innerHTML = sicon;
	}
	
}

// 체인지 이벤트 넣기 change -> 값이 바뀔때마다 
sample4_postcode.addEventListener( "change", address_check) // 체인지된 객체의 정보를 address_check 함수에게 전달 
sample4_roadAddress.addEventListener( "change", address_check)
sample4_jibunAddress.addEventListener( "change", address_check)
sample4_detailAddress.addEventListener( "change", address_check)		

/*
	tag객체명.addEventListener( "이벤트명", 함수명(파라미터) );
	tag객체명.addEventListener( "이벤트명", function(파라미터){} );
	tag객체명.addEventListener( "이벤트명", (e) => {} );

	문자열.indexOf(찾을문자) : 해당 문자열에 찾을 문자의 인덱스 번호 [ -1 : 없다 ]
*/


/* ---- 회원가입 전송 확인 ---- */
function form_submit(){
	
	// 1. 아이비 ~ 주소 모두 유효성 검사 검토
	// col3[0] : 아이디 ~~ col3[5] : 주소
	for( let i = 0; i <= 5; i++ ){
		if( col3[i].innerHTML !== sicon ){
			alert("입력이 되지 않은 정보가 있습니다")
			return false;
		}
	}
	// 이용 약관 체크 박스 검토
	if( document.querySelector("#confirm1").checked == false ){
		// tag 객체명.checke	: 체크가 되어있으면 true, 아니면 false
		alert("이용약관에 동의해 주세요")
		return false;
	}
	if( document.querySelector("#confirm2").checked == false ){
		// tag 객체명.checke	: 체크가 되어있으면 true, 아니면 false
		alert("개인정보 수집을 동의해 주세요")
		return false;
	}
	
	document.querySelector(".signupform").submit(); // 해당 form 전송 // 폼객체.submit()
	// document.querySelector(".signupform")
	// ignupform 이라는 class를 가지고 있는tag 호출
		
		
		
		
		
} // form_submit 메소드 종료






















































/* 카카오 우편 API 시작 */

    //본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
    function sample4_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var roadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 참고 항목 변수

                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample4_postcode').value = data.zonecode;
                document.getElementById("sample4_roadAddress").value = roadAddr;
                document.getElementById("sample4_jibunAddress").value = data.jibunAddress;
                
                // 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
                if(roadAddr !== ''){
                    document.getElementById("sample4_extraAddress").value = extraRoadAddr;
                } else {
                    document.getElementById("sample4_extraAddress").value = '';
                }

                var guideTextBox = document.getElementById("guide");
                // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
                if(data.autoRoadAddress) {
                    var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                    guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
                    guideTextBox.style.display = 'block';

                } else if(data.autoJibunAddress) {
                    var expJibunAddr = data.autoJibunAddress;
                    guideTextBox.innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
                    guideTextBox.style.display = 'block';
                } else {
                    guideTextBox.innerHTML = '';
                    guideTextBox.style.display = 'none';
                }
            }
        }).open();
    }


/* 카카오 우편 API 종료 */