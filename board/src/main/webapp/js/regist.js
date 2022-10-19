
function regist(){
	
	// js 객체 생성 : 자료형 변수명 = { 속성 : 값 }  (4개 하나로 묶음)
	let info = {
		
		b_title : document.querySelector("#b_title").value ,
		b_content : document.querySelector("#b_content").value,
		b_name : document.querySelector("#b_name").value,
		b_pw : document.querySelector("#b_pw").value
		
	}
	// console.log( info );
	
	$.ajax({
		url: "/board/Board/regist",
		data: info,
		success : function( result ) {
			if ( result == 'true' ){
				alert("게시글 등록 성공")
				location.href = '/board/Board/regist.jsp';
			}
			else{
				alert("게시글 등록 실패")
			}
		}
	});
} // regist 메소드 종료