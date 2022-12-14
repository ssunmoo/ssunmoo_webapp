

let page_info = {
	
	list_size : 3,	// 한페이지에 표시할 게시물 개수
	page : 1		// 현재 페이지 번호
	
}

board_list()

// 전체 게시글 출력
function board_list( page ) {
	
	page_info.page = page;
	
	$.ajax({
		url : "/board/Board/board_list",
		data : page_info,
		success : function( list ){
		alert(list)
			let boards = JSON.parse( list );
			
			let board_list = boards.data;
			console.log(board_list)
			
			let tag = '<tr>'
				+ '<th> 번호 </th>'
				+ '<th> 제목 </th>'
				+ '<th> 이름 </th>'
				+ '<th> 작성일 </th>'
				+ '<th> 조회수 </th>'
			+ '</tr>';
			
			for( let i = 0; i < board_list.length; i++ ){
				let b = board_list[i];
				
				tag += '<tr>'
				+ '<td>' + b.b_no + '</td>'
				+ '<td onclick="select_view('+i+')" id ='+i+'>' + b.b_title + '</td>'
				+ '<td>' + b.b_name + '</td>'
				+ '<td>' + b.b_date + '</td>'
				+ '<td>' + b.b_view + '</td>'
				+ '</tr>';
			} // for 종료
			
			document.querySelector("#board_list").innerHTML = tag;
			
			let pagehtml = '';
		
			pagehtml += '<button type="button"> 이전 </button>';
			
			pagehtml += '<button type="button"> 중간숫자들~~ </button>';
			
			pagehtml += '<button type="button"> 다음 </button>';
			
			document.querySelector(".pagebox").innerHTML = pagehtml;
		}
	});
} // board_list 메소드 종료


// 게시글 상세보기
function select_view( i ){
	// 등록된 게시글 보여주는거니까 가져오기만
	// console.log(i)
	$.ajax({
		url : "/board/Board/board_select_view",
		success : function( list ){
		let select_view = JSON.parse( list );
		let s = select_view[i];
		// console.log(select_view)
		let tag = '<table>'
				+ '<tr>'
				+ '<th> 번호 </th>'
				+ '<th> 제목 </th>'
				+ '<th> 내용 </th>'
				+ '<th> 이름 </th>'
				+ '<th> 작성일 </th>'
				+ '<th> 조회수 </th>'
				+ '</tr>'	
				+ '<tr>'
				// + '<td id ='+ s.b_no +'>' + s.b_no + '</td>'
				+ '<td id="b_no">' + s.b_no + '</td>'
				+ '<td>' + s.b_title + '</td>'
				+ '<td>' + s.b_content + '</td>'
				+ '<td>' + s.b_name + '</td>'
				+ '<td>' + s.b_date + '</td>'
				+ '<td id="v_plus">' + s.b_view + '</td>'
				+ '</tr>'			
				+ '</table>'
				+ '</div>'
				+ '<div class = "box3_pw">'
				+ '비밀번호 <input type="password" id="b_pw2">'
				+ '</div>'
				+ '<button onclick="board_delete()" class = "box3_btn"> 글삭제 </button>'
				+ '<button onclick="view_reply()" class = "reply_btn"> 댓글달기 </button>'
				//+ '<div id = "delete_btn"> </div>';
			//count++;
			document.querySelector("#b_select_view").innerHTML = tag;
		}
	})
	view_plus()
} // select_view 메소드 종료

// 조회수 증가
function view_plus(){
	
	let b_no = document.querySelector("#b_no").innerHTML;
	$.ajax({
		url : "/board/Board/view_plus",
		data : { "b_no" : b_no },
		success : function( re ){
			// console.log(re)
			// alert('되냐' +b_no)
			document.querySelector("#v_plus").innerHTML = b_no;
			location.reload();
		}
	})
} // view_plus 메소드 종료

	
// 댓글 등록 창 출력	
function view_reply(){
	
	let b_no = document.querySelector("#b_no").innerHTML;
	$.ajax({
		url : "",
		data : { "b_no" : b_no },
		success : function( re ){
	
		let tag = '<div class = "box5">'
				+ '<div class ="box4_title">↪ 댓글을 입력하세요 </div>'
				+ '<div class = "box4_con">'
				+ '<input type ="text" id = "r_reply">'
				+ '</div>'
				+ '</div>'
				+ '<button onclick="reply_up()" class = "reply_up_btn"> 댓글등록 </button>'
		document.querySelector(".box4").innerHTML = tag
		}
	})
} // view_reply 메소드 종료


// 댓글 등록
function reply_up(){
	
	let b_no = document.querySelector("#b_no").innerHTML;
	let r_reply = document.querySelector("#r_reply").value;
	
	
	$.ajax({
		url : "/board/Board/reply_up",
		data : { "b_no" : b_no, "r_reply" : r_reply },
		success : function( re ){
			alert("댓글 등록 완료")
			reply_view();	
		}
	})		
} // reply_up e

// 댓글 출력
function reply_view(){
	$.ajax({
		url : "/board/Board/reply_view",
		success : function( array ){
			
			let reply_view = JSON.parse( array );
			for( let i = 0; i < reply_view.length; i++ ){
				let rv = reply_view[i];

			let tag = '<div class = "box5">'
					+ '<div class ="box4_title">↪ Re.</div>'
					+ '<div class = "box4_con">'
					+ '<div id = "r_reply">' + rv.r_reply + '</div>'
					+ '</div>'
					+ '</div>'
					//+ '<button onclick="" class = ""> 댓글삭제 </button>';	
			
			document.querySelector(".box6").innerHTML = tag
			}
		}
	})		
} // reply_view e










	