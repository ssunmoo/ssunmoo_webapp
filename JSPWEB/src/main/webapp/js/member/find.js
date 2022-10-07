
function findid(){
	
	// 1. 해당 태그들의 값 혹은 div 호출
	let mname = document.querySelector("#mname").value;
	let memail = document.querySelector("#memail").value;
	let findidconfirmbox = document.querySelector("#findidconfirmbox");
	
	// 2. 서블릿에게 데이터 보내기 [ 기본값 : get 메소드 ]
	$.ajax({
		
		url : "/JSPWEB/member/findid" ,	// 통신 경로
		data : { "mname" : mname, "memail" : memail} ,	// 보낼 데이터 { 이름 : 값, 이름 : 값 }
		success : function( 받은데이터 ){
			if( 받은데이터 !== 'null'){
				findidconfirmbox.innerHTML = "회원 아이디 : " + 받은데이터
			}
			else{
				findidconfirmbox.innerHTML = "동일한 회원정보가 없습니다."
			}
		}		
	});

}

/* 비밀번호 찾기 */

function findpw(){
	
	let mid = document.querySelector("#mid").value;
	let memail = document.querySelector("#memail").value;
	let findpwconfirmbox = document.querySelector("#findpwconfirmbox");
	
	$.ajax({
		url : "/JSPWEB/member/findpw" ,
		data : { "mid" : mid , "memail" : memail } ,
		success : function( result ){
			if( result === ''){
				findpwconfirmbox.innerHTML = "동일한 회원정보가 없습니다."
			}
			else{
				findpwconfirmbox.innerHTML = "임시 비밀번호는 : [ " + result + " ]";
			}
		}
		
	});
}


