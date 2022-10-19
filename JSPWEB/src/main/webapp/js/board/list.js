// 페이징 처리
let pageinfo = {
	
	listsize : 5,	// 한페이지당 게시물 표시 개수
	page : 1,		// 현재 페이지 번호
	
	key : '',		// 검색 키 [ 공백은 값이 없다는 뜻 ]
	keyword : ''	// 검색 키워드5

}

list(1)				// js 열람시 메소드 1번 실팽 [ 첫 화면에서 1페이지 되도록 ]

// 1. 게시글 출력 메소드
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
		
		// 5. 검색된 전체 게시물 수 출력	
		document.querySelector('.totalsize').innerHTML = boards.totalsize;	
			
		} // success 메소드 종료
	})
} // list e


// 2. 제목 클릭 시 페이지 이동 함수
function viewload( bno ){
	$.ajax({
		url : "http://localhost:8080/JSPWEB/board/viewload",
		data : { "bno" : bno },
		success : function(re){
			
			location.href="http://localhost:8080/JSPWEB/board/view.jsp";	
		}
	})
} // viewload e


// 4. 검색 처리 메소드
function bsearch(){
	
	pageinfo.key = key = document.querySelector(".key").value;
	pageinfo.keyword = keyword = document.querySelector(".keyword").value;
	
	// 검색 완료 시 첫페이지로 출력되도록해야 함
	list( 1 )	// 메소드 호출 시 파라미터 사용하여 첫 페이지로 보여지게끔
		
} // bsearch e


// 6. 게시물 표시 개수 : 한 페이지에 보여지는 게시글 수 체인지 이벤트 사용하여 변경하기
function blistsize(){
	
	pageinfo.listsize = document.querySelector('.listsize').value;
	list( 1 )
	
} // blistsize e











