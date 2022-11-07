// * JS는 f5(새로고침)할때마다 메모리 초기화 * 

// 전송방식 : 1. 보내기 버튼 2. 메세지 입력 상자에서 엔터 키를 눌렀을 때
function enterkey(){
	// 엔터를 눌렀을 때
	if( window.event.keyCode == 13 ){	// window.event.keyCode : 키보드에 입력된 데이터를 숫자 표현 [ 엔터 = 13 ]
		send();
		
	}
} // enterkey e

// 1. 소켓을 사용할 수 있도록 변수 선언
let websocket = null	// 소켓 사용 저장 변수

// 2. 로그인 id 호출 [ jsp or ajax 둘 중 하나로 호출 ]
let mid = document.querySelector('.mid').value;
let room = document.querySelector('.room').value;
alert(room);

// 3. 회원/비회원 구분
if( mid !== 'null' ){	// 로그인이 되어있으면 소켓 사용

	// JS에서 지원하는 클라이언트 웹 소켓 클래스 [ new WebSocket( "ws://ip:port/프로젝트명/서버소켓엔드포인트/"+변수) ]
	websocket = new WebSocket("ws://192.168.17.131:8080/JSPWEB/chatting/"+mid);
	
	// 3. 2번에서 구현된 메소드를 클라이언트 소켓에 대입
	websocket.onopen = function(e){
		onopen(e)
	}
	
	websocket.onclose = function(e){
		onclose(e)
	}
	
	websocket.onmessage = function(e){
		onmessage(e)
	}
	
	websocket.onerror = function(e){
		onerror(e)
	}
}
else{	// 로그인이 안되어있으면
	alert("로그인이 필요합니다")
	location.href ="/JSPWEB/member/login.jsp";
}


// 2. 메소드 구현 [ 1. 접속했을 때 2. 나갔을 때 3. 메세지를 보냈을 때 4. 메세지를 받았을 때 ]

// 접속했을 때
function onopen(e){	
	
}
// 나갔을 때
function onclose(e){
	
}

// 메세지 전송
function send(){

	// 1. 보낼 데이터 객체 구성	// 객체 = { 속성 : 값 }
	let msg = { // 전송할 데이터 객체
		type : room ,  // 일반메시지
		content : document.querySelector('.msgbox').value , // 작성내용
		mid : mid ,  // 보낸 사람 
		date : new Date().toLocaleTimeString(), // 날짜 
		img : '프로필.png' // 사진
	}
	// 입력된 메세지 전송
	websocket.send( JSON.stringify(msg) ); 
	// JSON --> 문자열 변환 : JSON.stringify()
	// 문자열 --> JSON 변환 : JSON.parse()

	// 전송 후 입력상자 초기화
	document.querySelector('.msgbox').value = '';
}


// 이모티콘 전송
function emosend( i ){

	let msg = {
		type : "emo" ,  // 이모티콘
		content : i , // 이미지번호
		mid : mid , // 보낸 사람
		date : new Date().toLocaleTimeString() , // 날짜 
		img : '프로필.png'
	}
	websocket.send( JSON.stringify(msg) )
} // emosend e

	// alert(e);
	// e : 서버 소캣으로 부터 받은 정보가 담겨져있음
	
	// e.data : 받은 정보의 메세지
	// alert("e.data"+ e.data);

function onmessage(e){ // 메세지를 받았을 때 
	
	let msg = JSON.parse(e.data) // 받은 데이터 객체
	console.log(e.data)
	// 전송 타입이 일반 메세지이면
	if( msg.type == room ){ 
		
		// 내가 보낸 메세지면
		if( msg.mid == mid ){ // 보낸 사람 아이디와 접속된 아이디가 동일하면
			let html = document.querySelector('.contentbox').innerHTML;
			
			html += '<div class="secontent my-3">'
					+ '<span class="date">'+ msg.date +'</span>'		
					+ '<span class="content">'+ msg.content +'</span>'		
					+ '</div>'	
					
			document.querySelector('.contentbox').innerHTML = html
		}	
		// 상대방이 보낸 메세지면
		else{	
			let html = document.querySelector('.contentbox').innerHTML;
			
			html +=  '<div class="row g-0 my-3"> '+
					'<div class="col-sm-1 mx-2">'+
					'	<img width="100%" class="rounded-circle" alt="" src="/JSPWEB/img/망곰이.png">'+
					'</div> '+
					'<div class="col-sm-9">'+
					'	<div class="recontent">'+
					'		<div class="name">'+ msg.mid +'</div>'+
					'		<span class="content">'+ msg.content +'</span>'+
					'		<span class="date">'+ msg.date +'</span>'+
					'	</div>'+
					'</div> '+
					'</div>';
			document.querySelector('.contentbox').innerHTML = html		
		}
	}
	// 전송 타입이 이모티콘 이면
	else if( msg.type == "emo" ){
		
		// 내가 보낸 이모티콘이면
		if( msg.mid == mid ){
			
			let html = document.querySelector('.contentbox').innerHTML;
			
			html += '<div class="secontent my-3">'
					+ '<span class="date">'+ msg.date +'</span>'		
					+ '<img src="/JSPWEB/img/imoji/emo'+ msg.content +'.gif" width:"90px">'	
					+ '</div>'	
					
			document.querySelector('.contentbox').innerHTML = html
		}
		// 상대방이 보낸 이모티콘이면
		else{
			let html = document.querySelector('.contentbox').innerHTML;
			
			html += '<div class="row g-0 my-3">'
					+ '<div class="col-sm-1 mx-2">'
				 	+ '<img width="100%" class="rounded-circle" alt="" src="/JSPWEB/img/망곰이.png">'
					+ '</div>'
					+ '<div class="col-sm-9">'
					+ '<div class="recontent">'
					+ '<div class="name">'+ msg.mid +'</div>'
					+ '<img src="/JSPWEB/img/imoji/emo'+ msg.content +'.gif" width:"90px">'
					+ '<span class="date">'+ msg.date +'</span>'
					+ '</div>'
					+ '</div>'
					+ '</div>';
			document.querySelector('.contentbox').innerHTML = html
		}
	} // else if e
	
	// 채팅방에 들어오고 나가기
	else if( msg.type == "alarm" ){
		let html = document.querySelector('.contentbox').innerHTML;
		
		html += '<div class="alarm">'
				+ '<span> '+ msg.content +'</span>'		
				+ '</div>'	
		document.querySelector('.contentbox').innerHTML = html		
	}
	
	// 스크롤을 하단으로 내리기 //
	document.querySelector('.contentbox').scrollTop = document.querySelector('.contentbox').scrollHeight;
	////////////////////
	
} // onmessage e

function onerror(e){
	alert(e)
}


emoview()
// 이모티콘 호출
function emoview(){

	let html = "";
	for(let i = 1; i <= 43; i++ ){
		html += 
		'<img src="/JSPWEB/img/imoji/emo'+i+'.gif" width="70px" onclick="emosend('+i+')">'
	}
	document.querySelector('.dropdown-menu').innerHTML = html	
	
} // emoview e




















/*
	// 1. 출력 구역 호출
	let contentbox = document.querySelector('.contentbox')
	
	// 2. html 꾸미기
	let html = '<div>' 
			+ '<span> ' + msg.mid + ' :  </span>'
			+ '<span>' + msg.content + '</span>'
			+ '<span> [ ' + msg.date + ' ] </span>'
			+ '</div>'
			
	
	// 3. 받은 메세지를 HTML에 출력
	contentbox.innerHTML += html;
	*/
















