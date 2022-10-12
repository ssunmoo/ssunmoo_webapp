
board_list()

function board_list() {
	
	$.ajax({
		url : "/board/Board/board_list",
		// data : { },
		success : function( list ){
			let board_list = JSON.parse( list );
			// alert("나와라!!!!")
			
			let tag = '<tr>'
				+ '<th> 번호 </th>'
				+ '<th> 제목 </th>'
				+ '<th> 내용 </th>'
				+ '<th> 이름 </th>'
				+ '<th> 작성일 </th>'
				+ '<th> 조회수 </th>'
			+ '</tr>';
			for( let i = 0; i < board_list.length; i++ ){
				let b = board_list[i];
				
				tag += '<tr>'
				+ '<td>' + b.b_no + '</td>'
				+ '<td>' + b.b_title + '</td>'
				+ '<td>' + b.b_content + '</td>'
				+ '<td>' + b.b_name + '</td>'
				+ '<td>' + b.b_date + '</td>'
				+ '<td>' + b.b_view + '</td>'
				+ '</tr>';
			} // for 종료
			document.querySelector("#board_list").innerHTML = tag;
		}
	});
	
	
	
	
	
}