
board_list()
view_reply()

function board_list() {
	
	$.ajax({
		url : "/board/Board/board_list",
		// data : { },
		success : function( list ){
			let board_list = JSON.parse( list );
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
				// + '<td onclick="select_view()">' + b.b_title + '</td>'
				+ '<td onclick="select_view('+i+')" id ='+i+'>' + b.b_title + '</td>'
				+ '<td>' + b.b_name + '</td>'
				+ '<td>' + b.b_date + '</td>'
				+ '<td>' + b.b_view + '</td>'
				+ '</tr>';
			} // for 종료
			document.querySelector("#board_list").innerHTML = tag;
		}
	});
} // board_list 메소드 종료


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


function view_plus(){
	
	let b_no = document.querySelector("#b_no").innerHTML;
	$.ajax({
		url : "/board/Board/view_plus",
		data : { "b_no" : b_no },
		success : function( re ){
			// console.log(re)
			alert('되냐' +b_no)
			document.querySelector("#v_plus").innerHTML = b_no;
			location.reload();
		}
	})
} // view_plus 메소드 종료

	
function view_reply(){
	
	let b_no = document.querySelector("#b_no").innerHTML;
	$.ajax({
		url : "/board/Board/view_reply",
		data : { "b_no" : b_no },
		success : function( re ){
			alert(re)

		}
	})
	
}	
	