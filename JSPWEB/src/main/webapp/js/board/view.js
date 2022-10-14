
bview()
// 개별 게시글
function bview( bno ){
	$.ajax({
		url : "/JSPWEB/board/view",
		data : { "bno" : bno },
		success : function(re){
			
			let board = JSON.parse(re);
			console.log(board);			
			
			document.querySelector('.bno').innerHTML = board.bno;
			document.querySelector('.btitle').innerHTML = board.btitle;
			document.querySelector('.bcontent').innerHTML = board.bcontent;
			document.querySelector('.mid').innerHTML = board.mid;
			
			console.log(board.bfile);
			/*
				<a href="URL?변수명.데이터"> : get 메소드로 해당 URL에 데이터 전송
			*/
			if( board.bfile ){ // 데이터 없는 경우 0, null
				alert('not null')
				let filelink = '<a href="../board/filedown?bfile='+ board.bfile +'">'+ board.bfile +'</a>';
				
				document.querySelector('.bfile').innerHTML = filelink;
			}
			console.log( board.btnaction )
			
			let btnbox = document.querySelector(".btnbox")	
			
			if( board.btnaction == true ){
				// 삭제버튼 활성화
				let deletebtn = '<button onclick="bdelete('+ board.bno +')"> 삭제 </button>';
					btnbox.innerHTML += deletebtn;
			}
				// 수정버튼 활성화
			let updatebtn =  '<button "><a > 삭제 </a></button>';
			btnbox.innerHTML += updatebtn;
			
		}
	})
	
}

bdelete()

function bdelete(bno){
	$.ajax({
			url : "/JSPWEB/board/bdelete",
			data : { "bno" : bno },
			success : function(re){
				if( re === 'true'){
					alert('글 삭제 성공')
					location.href="../board/list.jsp";
				}
				else{
					alert('글 삭제 실패')
				}
			
			
			}
	});

}









