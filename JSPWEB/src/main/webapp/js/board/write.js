function bwrite(){
	
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
}



/*

	js 객체 만들기
	let 객체명 = { 속성명:데이터 }




*/