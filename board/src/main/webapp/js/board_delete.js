//alert('1')
function board_delete(){
	
	let b_pw = document.querySelector('#b_pw').value
	let b_pw2 = document.querySelector('#b_pw2').value
	let b_no = document.querySelector('#b_no').innerHTML
	
	alert("b_pw : " + b_pw );
	console.log("b_pw : " + b_pw );
	
	alert("b_no : " + b_no );
	console.log("b_no : " + b_no );
	
//alert('2')
//console.log("b_pw2 : " + b_pw2);
console.log("b_pw2 : " + b_pw2 );

	$.ajax({
		url : "/board/Board/board_delete",
		data : { "b_pw2" : b_pw2 , "b_no" : b_no },
		success : function(re){
			alert("ajax안 :" +b_no)
			alert(re)
			if( re === '1' ){
				alert('삭제 완료')
				//console.log(re);
				//console.log("b_pw2 : "+b_pw2);
				console.log("b_pw : "+b_pw);
				location.reload();
			}
			else {
				alert('삭제 실패')
				//console.log(re);
				//console.log("b_pw2 : "+b_pw2);
				console.log("b_pw : "+b_pw);
				location.reload();
			}
		}
	});
}