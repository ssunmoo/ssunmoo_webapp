/*
	식별쉽게
	css = class 명
	js = id 명으로 기재할거임!

	[등록]
	// 1. html input 태그에 입력된 데이터를 가져온 후 각 변수에 담기
	// 2. 객체에 담기
	// 3. 글 등록 버튼을 눌렀을때 1, 2번 반복 실행 
	// 4. 게시물 여러개를 저장할 공간 생성 = 배열 사용
	// 5. 글 등록이 완료될때 마다 board 객체를 배열에 저장한다.
	// 6. 기존 내용물 지우기
	
	[출력]
	// 1. js가 시작될때 / 새로운 글이 등록될때마다 [게시물출력]
	
	[보기]
	// 1. 게시물을 출력해서 제목을 클릭할때마다 [게시물 보기] 함수 실행
		// 1. 내가 클릭한 게시물() : 매개변수를 전달해야함 [클릭한 게시물의 번호(중복 없는 속성)]
	
 */
 

	// 여러개 board 객체를 저장할 배열 선언
let boardlist = [ ] 
// 함수 밖에 있어서 초기화되지 않고 저장됨


	// js가 시작될때 
 	게시물출력()
 	
  	// 3. 함수 선언 [글 등록 버튼을 누를때 마다 1,2번 반복 실행] 
function 글등록(){
	
	// 1. html input 태그에 입력된 데이터를 가져온 후 각 변수에 담기
	 let bwriter = document.getElementById('bwriter').value
	 let bpassword = document.getElementById('bpassword').value
	 let btitle = document.getElementById('btitle').value
	 let bcontent = document.getElementById('bcontent').value
	 // value 인풋 등 값이 있는 속성에만 .value 값을 빼온다는 뜻으로 넣을 수 있음
	 // div, span 등은 innerHTML 사용해서 가져와야됨	 
	 
	 // 2. 객체에 담기
	 let board = {
		작성자 : bwriter,
		비밀번호 : bpassword,
		제목 : btitle,
		내용 : bcontent,
	}
	
	// 5. 객체를 배열에 저장
	boardlist.push( board )	// 배열명.push( 데이터 ) : 배열에 데이터 추가 함수
	// board 에 기재된 내용이 boardlist 에 저장되어있음
	alert('[안내] 글 등록이 완료되었습니다.')
	
	// 6. input 초기화
		document.getElementById('bwriter').value = ''
		document.getElementById('bpassword').value = ''
		document.getElementById('btitle').value = ''
		document.getElementById('bcontent').value = ''
	// 7. 글 등록시 게시물 출력 함수 호출
	게시물출력()
	
} // 글등록 함수 end 

		

 // 1. 
 function 게시물출력(){
	let html = '<tr> <th> 번호 </th> <th> 제목 </th> <th> 작성자 </th> </tr>'
	
	// 반복문 누적 더하기!
	for(let i = 0; i < boardlist.length; i++){
		// i는 0부터 배열의 길이까지 1씩 증가			// 배열내 i번째 객체내 '제목' 키 호출 -> 값 이 나옴
		html += '<tr> <th> ' + i + '</th> <th><a href="#" onclick="게시물보기('+i+')"> ' + boardlist[i].제목 + '</a> </th> <th> ' + boardlist[i].작성자 + '</th> </tr> '

	}
	
	document.getElementById('boardlist').innerHTML = html
	// 게시물 출력 함수 end
}

 
 	// i 값을 매개변수로 전달해주는게 가장 중요,,,,
function 게시물보기(i){
	boardlist[i].제목
	boardlist[i].작성자
	boardlist[i].내용
	
	document.getElementById('viewtitle').innerHTML = boardlist[i].제목
	document.getElementById('viewwriter').innerHTML = boardlist[i].작성자
	document.getElementById('viewcontent').innerHTML = boardlist[i].내용
}
 
 
 
 
// 글삭제 버튼은 게시물 출력된거에 '' 공백넣어서 초기화시키면될거같다
// 할수있을까,,ㅎ,,
 
 
 
 

 
 