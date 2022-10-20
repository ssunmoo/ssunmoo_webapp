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
let mid = document.querySelector('.mid').value

// 3. 회원/비회원 구분
if( mid !== 'null' ){	// 로그인이 되어있으면 소켓 사용

	// JS에서 지원하는 클라이언트 웹 소켓 클래스 [ new WebSocket( "ws://ip:port/프로젝트명/서버소켓엔드포인트/"+변수) ]
	websocket = new WebSocket("ws://localhost:8080/JSPWEB/chatting/"+mid);
	
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
	location.href ="../member/login.jsp";
}


// 2. 메소드 구현 [ 1. 접속했을 때 2. 나갔을 때 3. 메세지를 보냈을 때 4. 메세지를 받았을 때 ]

function onopen(e){	// 접속했을 때
	alert("채팅방에 들어왔습니다"+e)
}

function onclose(e){ // 나갔을 때
	alert("채팅방에서 나갔습니다"+e )
}

function send(){ // 메세지를 보냈을 때

	// 1. 보낼 데이터 객체 구성
	let mag = {	// 객체 = { 속성 : 값 }
		content : document.querySelector('.msgbox').value,	// 보낸 내용
		mid : mid,	// 보낸시간 아이디
		date : new Date().toLocaleTimeString()				// js 현재 시간
	}
	// 입력된 메세지 전송
	websocket.send( JSON.stringify(mag) ); 
	// JSON --> 문자열 변환 : JSON.stringify()
	// 문자열 --> JSON 변환 : JSON.parse()

	// 전송 후 입력상자 초기화
	document.querySelector('.msgbox').value = '';
}

function onmessage(e){ // 메세지를 받았을 때 
	// console.log("아이디 :"+ from)
	// console.log(e.data)
	
	let msg = JSON.parse(e.data)
	
	// alert(e);
	// e : 서버 소캣으로 부터 받은 정보가 담겨져있음
	
	// e.data : 받은 정보의 메세지
	// alert("e.data"+ e.data);
	
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

}

function onerror(e){
	alert(e)
}







