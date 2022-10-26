
// 1. 등록 버튼을 눌렀을 때
function regist(){
	
	/* 첨부파일이 포함되어있을 경우 폼을 전체 가져옴 */
	let form = document.querySelector('form')
	let formdata = new FormData( form ); // FormData 객체 생성
	
	$.ajax({
		url : "/JSPWEB/admin/regist",
		data : formdata ,
		/* form 전송이 첨부파일일 경우 [ 아래 3가지 필수 ] write.js 참고 */
		type : "POST", 
		processData : false, 
		contentType : false, 
		success : function( re ){
			
			if( re == 'true' ){
				alert('제품 등록 성공')
				location.reload();
			}	
			else{
				alert('제품 등록 실패')
			}
		}
	})
} // regist e


// 2. 첨부파일 등록(변경) 시 미리보기 구현 [ 사진만 가능 ]
let pimg = document.querySelector('#pimg')
pimg.addEventListener('change', function( e ){// file change 이벤트 // e : event 객체 [ 이벤트 정보 : target, data 등 ]
	
	// 1. js 파일 클래스 [ FileReader(); ]
	let file = new FileReader();			// 파일 클래스를 이용한 객체 생성
	// console.log( e );					// 이벤트 객체
	// console.log( e.target );				// 이벤트를 실행한 타겟 : <input type="file" id="pimg">
	// console.log( e.target.files[0] );	// 해당 태그의 등록된 파일 호출
	
	// 2. 해당 첨부 파일의 경로 읽어오기 [ 객체명.readAsDataURL( 파일 ) ] 
	file.readAsDataURL( e.target.files[0] );// e.target.files[0] : 첨부파일로 등록된 이미지
	
	// 3. 이미지 태그에 첨부된 이미지 대입 -> 이미지는 src 속성 사용해서 변경 가능
	file.onload = function( e ) {			// e : file load 이벤트 
		document.querySelector('#pimgpre').src = e.target.result	// 서버[ 사용자의 c 드라이브 경로 요청 x ]와 관련없음
	
	}
	
})


// 3. 카테고리 추가 버튼을 눌렀을때 이벤트 구현
function pcategoryview(){
	
	document.querySelector('.pcategoryaddbox').innerHTML
	= '<input type="text" id="pcname">'
	+ '<button type="button" onclick="setpcategory()"> 카테고리 등록버튼 </button>';
	
}

// 4. 카테고리 등록 버튼을 눌렀을때 이벤트
function setpcategory(){
	
	$.ajax({
		url : "/JSPWEB/board/pcategory",
		type : "POST",
		data : { "pcname" : document.querySelector('#pcname').value },
		success : function( re ){
		
			if( re == 'true' ){
				alert('카테고리 등록 성공')
				document.querySelector('.pcategoryaddbox').innerHTML = '';	// 성공 시 빈공간으로 초기화
				getpcategory()	// 성공 시 카테고리 목록 보여지기 (새로고침)
			}
			else{
				alert('카테고리 등록 실패')
			}

		}
	})
} // pcategoryadd e

getpcategory()
// 5. 카테고리 생성
function getpcategory(){
	$.ajax({	// 서버랑 연결
		url : "/JSPWEB/board/pcategory",
		type : "get",
		success : function( re ){		// 성공 시 스트림 언어로 받아오기
			let json = JSON.parse(re);	// 스트림 언어를 제이슨 언어로 변환 
			
			let html = '';
			for( let i = 0; i < json.length; i++ ){
				let categroy = json[i];	// json 객체의 i 번째에 있는 정보를 담기
				html += '<input type="radio" name="pcno" value="'+ categroy.pcno +'">' + categroy.pcname;
																	// 카테고리 번호		// 카테고리 이름
			}
		document.querySelector('.pcategorybox').innerHTML = html
		}
	})	
}// getpcategory() e














