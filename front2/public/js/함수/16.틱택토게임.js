/**
 	틱택토게임(삼목)
 		1. 게임판[9칸] 구현
 		2. 버튼 눌림 기능
 		3. 사용자(선택) vs 컴퓨터(랜덤)
 			1. 사용자 버튼 O
 			2. 컴퓨터 버튼 X
 		4. 승리자 판단
 		
 	------------------
 	함수
 	function 함수명(매개변수, 매개변수2 ~){ 코드 }
 
 */


let 게임상황 = []	//현재 알을 둔 상황을 저장하는 배열
let 승리 = '' // 이긴 알을 저장하는 변수


// 1. 게임판 출력하는 함수
function 게임판그리기(){
	// function 함수 만들기 키워드
	// 게임판그리기 이름으로 함수 선언[매개변수x 리턴값x]
	
	승리 = '' // 승리 변수를 공백으로 초기화	
	게임상황 = [null,null,null,null,null,null,null,null,null,]
		// 배열에 9개를 null 로 초기화

	let 게임판 = ''	// 여러개 버튼(tag)을 저장하는 변수
	for(let i = 0; i < 9; i++){	// i는 0부터 8까지 1씩증가반복
		게임판 += `<button id=${i} onclick=버튼선택(${i})> ${i} </button>`
		// 게임판 변수에 버튼을 누적 더하기
		if(i % 3 == 2){
			게임판 += '<br>'	
		// 나머지가 2, 5, 8일때 줄바꿈처리
		}
	}
	// 문서(html)의 id가 gameboard에 위출력된 함수를 넣겠다
	document.getElementById('gameboard').innerHTML = 게임판
}

// 2. 버튼 선택 시 이벤트 함수[매개변수 i = 눌림 버튼 번호]
function 버튼선택(i){
	if(중복검사(i)){
		alert('안내) 이미 둔 자리입니다.')
		return	// 함수호출해서 해당 위치에 알이 있으면 함수 종료[아래코드 실행x]
	}
	// 사용자가 선택한 버튼의 id의 html -> O로 변경
	document.getElementById(i).innerHTML = 'O'
	// [컴퓨터]난수 발생
		// Math 		// Math : 수학 관련 메소드를 제공하는 클래스
		// random()		// Math.random() : 0~1 사이의 난수를 발생
						// Math.random() 	* 끝번호 -1
						// (Math.random() 	* 9) + 1 : 1~10 사이의 난수 
	게임상황[i] = 'O'	// 선택된 해당 알을 배열에 저장
	
	if(게임결과()){	// 게임 결과 함수에서 true가 리턴되면
		alert('게임 종료 승리 : ' + 승리)
		return		// 함수 강제종료
	}	
			
	while( true ){	//	while(true) : 무한루프[종료조건 : 랜덤위치에 알을 두었을때 반복종료]
		let rand = Math.floor(Math.random() * 9)	// 0~8 끝번호 -1 이니까 9를하면 8까지임
			// 1.Math.floor 내림 2.Math.round() 반올림 3.Math.ceil() 올림
			if(!중복검사(rand)){
			document.getElementById( rand ).innerHTML = 'X'
			게임상황[rand] = 'X'	// 해당 알을 배열에 저장
			break
			}
	}
	if(게임결과()){	// 게임 결과 함수에서 true가 리턴되면
		alert('게임 종료 승리 : ' + 승리)
		return		// 함수 강제종료		
	}
	
	
}
// 3. 현재 위치에 알이 있는지 검사하는 함수[중복검사]
function 중복검사( i ){
	if(게임상황[ i ] != null){	// 배열은 오두 null로 초기화했기 떄문에
								// null 아니면 O또는 X가 존재하는 의미[알이있다]
		return true  // null이 없으면 알이 있다
	}else{
		return false // null이 있으면 알이 없다
	}
}

// 4. 게임 결과를 판단하는 함수 출력
function 게임결과(){
	//	1. 가로로 이기는 수[0 1 2, 3 4 5, 6 7 8]
	for(let i = 0; i <= 6; i+=3){
		// i는 0부터 6까지 3씩 증가반복 [ 3회 : 0, 3, 6]
		if(게임상황[i] != null && 게임상황[i] == 게임상황[i+1] && 게임상황[i+1] == 게임상황[i+2]){
			// && 이면서 면서 이고 모두 그리고 [조건1 && 조건2 && 조건3]
				// i가 0일때 : 0 == 1 == 2, i가 3일때 : 3 == 4 == 5, i가 6일때 : 6 == 7 == 8
				
			승리 = 게임상황[i]	// 승리 변수에 i번째 알 저장
			return true // 가로로 승리가 나왔을 경우 함수 종료
		}
	}
	//	2. 세로로 이기는 수[0 3 6, 1 4 7, 2 5 8]
	for(let i = 0; i <= 2; i++){
		// i는 0부터 2까지 1씩 증가반복 [3회 : 0 1 2]
		if(게임상황[i] != null && 게임상황[i] == 게임상황[i+3] && 게임상황[i+3] && 게임상황[i+6]){
			승리 = 게임상황[i]	// 승리 변수에 i번째 알 저장
			return true // 가로로 승리가 나왔을 경우 함수 종료
		}
	}
	//	3. 대각선으로 이기는 수[0 4 8, 2 4 6]
	//	4. 무승부[위 상황이 아니면서 알이 9개면 게임종료]
}









