/*
	
	value		: 태그안에 value 속성이 있는 것 들
	input , select , textarea 등
	
	innerHTM	: 태그안에 value 속성이 없는 것 들
	div, span, table 등
	** textarea 는 둘다 됨

*/


bview()

// 1. 게시물 상세페이지가 열렸을때 실행되는 함수
function bview( bno ){
	$.ajax({
		url : "/JSPWEB/board/view",
		async : false,	// 동기식으로 변경 우선 순위를 정할 수 있음 실행이 끝날때 까지 다른애가 접근 x
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
				// alert('not null')
				let filelink = '<a href="../board/filedown?bfile='+ board.bfile +'">'+ board.bfile +'</a>';
				
				document.querySelector('.bfile').innerHTML = filelink;
			}
			console.log( board.btnaction )
			
			let btnbox = document.querySelector(".btnbox")	
			
			if( board.btnaction == true ){
				// 삭제버튼 활성화
				let deletebtn = '<button onclick="bdelete('+ board.bno +')"> 삭제 </button>';
				btnbox.innerHTML += deletebtn;
				// 수정버튼 활성화
				let updatebtn =  '<button><a href="/JSPWEB/board/update.jsp" > 수정 </a></button>';
				btnbox.innerHTML += updatebtn;
			}
		}
	})
	rlist() // 댓글 출력 메소드
}

// 2. 게시물 삭제 함수
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


// 3. 댓글 작성 함수
function rwrite(){

	let rcontent = document.querySelector('.rcontent').value;
	$.ajax({
		url : "/JSPWEB/reply/rwrite",
		data : { "rcontent" : rcontent , "type" : "reply" },
		type : "POST",
		success : function(re){
			
			if( re == 1 ){
				alert('댓글 등록 완료')
				rlist() // 댓글 출력
				// location.reload();
			}
			else if ( re == 0 ){
				alert('로그인 후 작성 가능합니다')
				location.href = '../member/login.jsp';
			}
			else{
				alert('댓글 등록 실패')
			}
		}
	})
} // rwrite e


// 4. 댓글 출력 함수
function rlist(){
	
	
	$.ajax({ // 댓글 호출 ajax
		url : "/JSPWEB/reply/rlist",
		data : { "type" : "reply" }, // 서블릿을 같이 사용하기위해 타입을 지정 -> reply 댓글용
		success : function(re){ // 댓글 호출이 성공했을 때 아래 실행
			let replylist = JSON.parse(re);
			
			
			// 모든 댓글을 출력하는 반복문
			let html = ''
			for( let i = 0; i < replylist.length; i ++ ){ // 댓글마다 반복문 돌면서 출력
				let reply = replylist[i];
				
				$.ajax({  // 댓글마다 대댓글 호출 ajax 대댓글 호출 = rno ---> rindex 
					url : "/JSPWEB/reply/rlist",
					data : { "type" : "rereply", "rno" : reply.rno }, // 서블릿을 같이 사용하기위해 타입을 지정 -> rereply 대댓글용
					async : false,	// 동기식 : 순서 기다릴 수 있도록 웨이팅 걸기 
					success : function(re){
						let rereplylist = JSON.parse(re);
						
						// 댓글 출력 [ 상위 ]
						html += '<div>'
							+ '<span>'+ reply.rcontent +'</span>'
							+ '<span>'+ reply.rdate +'</span>'
							+ '<span>'+ reply.mid +'</span>'
							+ '<button type = "button" onclick="rereplyview('+ reply.rno +')"> 답글 </button>'
							+ '<div class="reply'+ reply.rno +'"></div>'; // 댓글마다 사용되는 구역
						
							// 대댓글 출력 [ 하위 ]
							for( let j = 0; j < rereplylist.length; j++ ){
								let rereply = rereplylist[j]
								html += '<div style="margin : 15px 25px;">'
									+ '<span>'+ rereply.rcontent +'</span>'
									+ '<span>'+ rereply.rdate +'</span>'
									+ '<span>'+ rereply.mid +'</span>'
									+ '</div>';
							} // for e
						// 댓글 출력 [ 상위 ] html 닫는 div	
						html += '</div>';
					}
				})
			} // for e
			document.querySelector('.replylist').innerHTML = html;
		}
	})
} // rlist e


// 5. 대댓글[답글] 작성 구역 표시 함수
function rereplyview( rno ){
	
	let replydiv = document.querySelector('.reply' + rno);
	replydiv.innerHTML = '<input type="text" class="rerecontent'+rno+'"><button onclick="rereplywrite('+ rno +')"> 답글작성 </button>';
	
}


// 6. 대댓글[답글] 달기 실행 메소드
function rereplywrite( rno ){
	
	let rcontent = document.querySelector('.rerecontent'+rno).value;

	$.ajax({
		url : "/JSPWEB/reply/rwrite",
		data : { "rcontent" : rcontent , "rno" : rno, "type" : "rereply" },
		type : "POST",
		success : function(re){
			
			if( re == 1 ){
			alert('답글 등록 완료')
			rlist() // 댓글 출력
			// location.reload();
			}
			else if ( re == 0 ){
				alert('로그인 후 작성 가능합니다')
				location.href = '../member/login.jsp';
			}
			else{
				alert('답글 등록 실패')
			}
	
		}
	})	
} // rereplywrite e
