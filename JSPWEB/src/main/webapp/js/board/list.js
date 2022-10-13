viewload()
list()
function list(){
	
	$.ajax({
		url : "/JSPWEB/board/list",
		success : function(re){
			// alert(re)
			// console.log(re)
			let boardlist = JSON.parse(re)
			console.log(boardlist) 
			
			let html = "";
			for( let i = 0; i < boardlist.length; i++ ){
				
				// 1. 리스트에서 하나씩 꺼내기	
				let b = boardlist[i];
				console.log("게시판:"+b)
				// 2. i번째 객체의 정보를 html 형식으로 변환 출력
				html += '<tr>'
					+ '<td>' + b.bno + '</td>'
					// + '<td><a href="../board/view.jsp?bno=' + b.bno + '">' + b.btitle + '</td>'
					+ '<td onclick="viewload(' + b.bno + ')">' + b.btitle + '</td>'
					+ '<td>' + b.mid + '</td>'
					+ '<td>' + b.bdate + '</td>'
					+ '<td>' + b.bview + '</td>'
					+ '</tr>';
					
			}
			console.log("htmlㅋㄴ솔"+html)
			document.querySelector(".btable").innerHTML += html
		} // success 메소드 종료
	})
}



function viewload( bno ){
	$.ajax({
		url : "http://localhost:8080/JSPWEB/board/viewload",
		data : { "bno" : bno },
		success : function(re){
			// alert('넘어가니?')
			location.href="http://localhost:8080/JSPWEB/board/view.jsp";	
		}
	})
	
}


/*



*/
