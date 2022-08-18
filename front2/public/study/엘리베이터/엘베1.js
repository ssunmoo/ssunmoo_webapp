

let call_floor = ''
let ev_floor = ''


function elevator(){
	// 엘리베이터 리스트 버튼을 출력해줄 함수 선언
	
let elevator_list = ''	// 엘리베이터 버튼을 저장할 변수
	for(let i = 5; i > 0 ; i--){	// i는 5부터 1까지 1개씩 감소
		elevator_list += `<button id=${i} onclick=버튼선택(${i})> ${i} </button>`
		// 엘리베이터 리스트에 버튼을 누적 더하기	
		if(i % 1 == 0){	// 한줄로 처리하고싶음, 1로 나눴을때 값이 남지 않으면 줄바꿔줘  
			elevator_list += '<br>'
		}
	}
	document.getElementById('elevator_display').innerHTML = elevator_list
	// html의 id가 elevator_algorithm에 출력된 함수를 넣겠다
}



function startEv(call_floor, ev_floor ){ // 엘베 가동 시작
	alert("starEv()");
	
	let gap = ev_floor - call_floor;
	
	for(let i = 0; i == start; i++){
	 //엘리베이터 위치와 내 위치가 같아질때까지 반복해줘..
		
		alert('엘베도착')
		
	}
}



































