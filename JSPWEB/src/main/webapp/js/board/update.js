
// 첨부파일 삭제 버튼을 눌렀을때 실행
function bfiledelete() {

	// 1.
	if ( confirm('삭제 하시겠습니까?') ) { // 만약에 confirm [ 확인 = true , 취소 = false]  
		
		$.ajax({
			url: "/JSPWEB/board/bfiledelete",
			success: function(re) {
				if (re === 'true') {
					alert('첨부파일 삭제 완료')
					// location.reload()
					document.querySelector(".oldfilebox").innerHTML = ''; // 공백처리

					// 특정 태그만 새로고침 : 제이쿼리 제공
					$("#oldfilebox").load(location.href + ' #oldfilebox');
				}
				else {
					alert('첨부파일 삭제 실패')
				}
			}
		})
	}
	
} // bfiledelete 메소드 종료


bview()
// 게시글 수정 페이지에서 사용되는 기존 게시물 불러오기
function bview() {

	$.ajax({
		url: "/JSPWEB/board/view",
		success: function(re) {
			let board = JSON.parse(re)
			
			document.querySelector(".btitle").value = board.btitle;
			
			// 썸머 노트는 내용 저장 시 html 형식으로 저장되기 때문에
			document.querySelector(".bcontent").innerHTML = board.bcontent;
			
			// 첨부파일이 존재하면
			if (board.bfile !== 'null') {
				let filedelete = board.bfile + '<button type ="button" onclick ="bfiledelete()"> 첨부파일 삭제 </button>'

				// 위에 구성한 html 출력
				document.querySelector(".oldfilebox").innerHTML = filedelete;
			}
		}
	})

	/* 썸머노트 실행 */
	$(document).ready(function() {
		$('#summernote').summernote({

			placeholder: '내용을 입력하세요 ',
			maxHeight: null,
			minHeight: 300,
			lang: 'ko-KR' // default: 'en-US'

		});
	});

} // bview 종료




// 첨부파일 수정
function bupdate() {

	let form = document.querySelector('form');
	let formdata = new FormData( form );
	
	console.log(formdata)
	
	$.ajax({
		url : "/JSPWEB/board/bupdate",
		data : formdata ,
		
		// 첨부파일 보내기 양식
		type : "POST" ,
		contentType : false,
		processData : false,
		
		success : function ( re ){
			if( re === 'true'){
				alert('수정 성공')
				location.href = 'view.jsp';
			}
			else{
				alert('수정 실패')
			}
		}
	});
} // bupdate 종료































