
board_list()

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
		console.log(select_view)
		
		let s = select_view[i];
		// console.log(select_view)
		let tag = '<tr>'
				+ '<th> 번호 </th>'
				+ '<th> 제목 </th>'
				+ '<th> 내용 </th>'
				+ '<th> 이름 </th>'
				+ '<th> 작성일 </th>'
				+ '<th> 조회수 </th>'
				+ '</tr>'	
				+ '<tr>'
				+ '<td>' + s.b_no + '</td>'
				+ '<td>' + s.b_title + '</td>'
				+ '<td>' + s.b_content + '</td>'
				+ '<td>' + s.b_name + '</td>'
				+ '<td>' + s.b_date + '</td>'
				+ '<td>' + s.b_view + '</td>'
				+ '</tr>';
				
			document.querySelector("#b_select_view").innerHTML = tag;
		}
	})
} // b_ch 메소드 종료




	
	