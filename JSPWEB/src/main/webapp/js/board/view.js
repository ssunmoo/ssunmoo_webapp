
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
			document.querySelector('.mno').innerHTML = board.mno;

		}
		
	})
	
}