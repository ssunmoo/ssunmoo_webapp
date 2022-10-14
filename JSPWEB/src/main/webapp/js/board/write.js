/* 썸머노트 실행 */
$(document).ready(function() {
	$('#summernote').summernote({
	
		placeholder: '내용을 입력하세요 ',
		maxHeight : null,
		minHeight : 300,
		 lang: 'ko-KR' // default: 'en-US'
	});
	
});


function bwrite(){
	
	let form = document.querySelector("form")		// 1. 폼 태그 호출
	console.log(form)
	
	let formdata = new FormData(form)				// 2. 객체화된 폼의 정보 호출
	console.log(formdata)												// [ form 안에 입력받은 데이터 input ]
	
	$.ajax({ // ajax 통신 전송 타입 : 문자열
		url:"/JSPWEB/board/write" ,	// 1. 서블릿 주소
		data : formdata , 			// 2. ajax 기본값이 문자열이기 때문에 form 전송 불가능
		
		// [ 첨부 파일 전송 시 아래 코드 추가 ]
		// 첨부파일은 post 방식 사용, get 방식 불가
		type : 'POST' ,			
		
		// [ 전송할 데이터의 타입 ]
		contentType : false ,
		// 기본값 : application x-www-form-urlencoded [ charset = UTF-8 : 바이트 첨부파일 지원 x ]
		// false : mutipart/form-data [ 대용량 바이트 첨부파일 지원 o ]
		
		// [ 전송시 사용되는 타입 ]
		processData : false , 
		// 기본값 : 전송 url 데이터 명시 http://example.com?title=tit&content=cont
		// flase : http://example.com
		
		success : function(re){
			// alert(re)
			if( re === 'true'){
				alert("글 등록 완료")
				location.href = "list.jsp"
			}
			else{
				alert("글 등록 실패")
			}
		}
		
	});
	
	
	
	
	/* --- 파일 전송 없이(폼x) 했던 거 ---
	let inputs = document.querySelectorAll("input")
	// inputs[0] 은 헤더에있는 검색창 input임
	
	console.log(inputs)
	
	let data = {
		btitle : inputs[1].value ,
		bcontent : inputs[2].value
	}
	console.log(data)
	
	
	
	$.ajax({
		url : "/JSPWEB/board/write",
		data : data,
		success : function (re){
			// ㄴalert(re)
			if( re === 'true'){
				alert("글 등록 완료")
				location.href = "list.jsp"
			}
			else{
				alert("글 등록 실패")
			}
		}
	});
	*/
}
	


/*

	js 객체 만들기
	let 객체명 = { 속성명:데이터 }




*/