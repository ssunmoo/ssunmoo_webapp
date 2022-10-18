
let pageinfo = {
	listsize : 3,	// 한페이지당 게시물 표시 개수
	page : 1		// 현재 페이지 번호
}

list(1)				// js 열람시 
function list( page ){
	
	pageinfo.page = page;	// 객체 정보 변경
	
	$.ajax({
		url : "/JSPWEB/board/list",
		data : pageinfo,	// 페이지 정보 객체 전달
		success : function(re){
			let boards = JSON.parse(re)
			
			// 1. Object 내 게시물 리스트 호출
			let boardlist = boards.data;
			
			let html = "";
			for( let i = 0; i < boardlist.length; i++ ){
				
				// 1. 리스트에서 하나씩 꺼내기
				let b = boardlist[i];
				// console.log("게시판:"+b)
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
			document.querySelector(".btable").innerHTML = html
			
			// 1. 페이징버튼 html 구성
			let pagehtml = '';
			
			// 2. [ 이전 버튼 ]
			if( page <= 1 ){
				// 현재 페이지가 첫 페이지 이면 이전 페이지 불가 제한
				pagehtml += '<button onclick="list('+(page)+')"> 이전 </button>';
			}
			else{
				pagehtml += '<button onclick="list('+(page-1)+')"> 이전 </button>';
			}
			
			// 4. [ 페이지번호 버튼 ] 시작 버튼 - 마지막 버튼 출력
			for( let page = boards.startbtn; page <= boards.endbtn; page++ ){
				pagehtml += '<button type="button" onclick="list('+ page +')">'+ page +'</button>'
			}
			
			// 3. [ 다음 버튼 ]
			if( page >= boards.totalpage ){
				// 현재 페이지가 마지막 페이지면 다음 페이지 불가 제한
				pagehtml += '<button onclick="list('+(page)+')"> 다음 </button>';
			}
			else{
				pagehtml += '<button onclick="list('+(page+1)+')"> 다음 </button>';
			}
			document.querySelector('.pagebox').innerHTML = pagehtml;
			
			
		} // success 메소드 종료
	})
}



function viewload( bno ){
	$.ajax({
		url : "http://localhost:8080/JSPWEB/board/viewload",
		data : { "bno" : bno },
		success : function(re){
			
			location.href="http://localhost:8080/JSPWEB/board/view.jsp";	
		}
	})
}












