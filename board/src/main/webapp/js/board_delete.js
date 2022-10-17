//alert('1')
function board_delete(){
	
	let b_pw = document.querySelector('#b_pw').value
	let b_pw2 = document.querySelector('#b_pw2').value
	let b_no = document.querySelector('#b_no').innerHTML
	
	
//alert('2')
//console.log("b_pw2 : " + b_pw2);

	$.ajax({
		url : "/board/Board/board_delete",
		data : { "b_pw2" : b_pw2 , "b_no" : b_no },
		success : function(re){
			if( re === '1' ){
				alert('삭제 완료')
				location.reload();
			}
			else {
				alert('삭제 실패')
				location.reload();
			}
		}
	});
}