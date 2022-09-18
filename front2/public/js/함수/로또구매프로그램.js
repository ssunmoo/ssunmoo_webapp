/*
 	로또 구매
 		1. 사용자	: 6개의 버튼을 선택한다.
 			조건	: 한번 클릭(선택), 두번 클릭(취소), 최대 6개까지 선택가능
 		2. 컴퓨터	: 추첨번호[1 ~ 45 난수] 생성
 		3. 사용자와 컴퓨터의 추첨번호 비교 결과
 		
 	
 */

// 변수 선언
// 함수의 지역변수 특징 : { } 안으로 들어갈 수 있다. { } 밖으로는 못나감
let select_numbers = []	// 특정 함수에서만 사용하는 것이 아니기 때문에 함수안에 사용하지않고
						// 여러 함수에 사용할 것이기 때문에 밖에다 선언
 						// 함수 안에 사용 시 계속 초기화 됨
 						// 사용자 선택 번호 리스트[배열]
 						
let lotto_numbers = []	// 컴퓨터 난수 번호 리스트[배열]
 
 						
// 1. 버튼 만들기 함수
function btn_print(){
	
	let btnlist = '' // 1 ~ 45개의 버튼을 저장하는 변수
	for( let i = 1; i <= 45; i++){
		// i는 1부터 45까지 1씩 증가 반복
		btnlist += `<button id=${i} onclick=btn_click(${i})> ${i} </button>`
		if(i % 5 == 0){
			// i가 5의 배수이면 btnlist 뒤에 줄바꿈 처리 해줘!!!
			btnlist += '<br>'
		}
	}	
	// 현재 문서의 btnbox 라는 id를 갖는 태그를 호출해서 html에 변수 대입
	document.getElementById('btnbox').innerHTML = btnlist;
}

// 2. 버튼 눌렀을때 함수[ 매개변수 i -> 내가 클릭한 버튼의 순서 ]
function btn_click(i){
	
	// 배열내 존재하는 숫자 인지 확인
	let index = select_numbers.indexOf(i)
	if( index >= 0 ){ // 선택한 수가 배열내 존재하면
	
		alert( '이미 선택한 번호 입니다. [취소합니다.]')
		select_numbers.splice(index, 1)
	}else{	// 선택한 수가 배열내 존재하지 않으면
			// 배열 내 개수 체크
		if(	select_numbers.length == 6){	// 배열에 6개가 들어오면 더이상 받지 않겠다!!
			alert('더 이상 선택할 수 없습니다')
			return // 결과에 부합하면 [아래 코드 실행x]
		}
		// 선택한 번호 배열에 저장
		select_numbers.push(i) // 배열명.push(데이터) : 배열의 데이터 추가
	}
	
	document.getElementById('selectbox').innerHTML = select_numbers;
}	
		
	/*
	
	// 중복배제
	if( select_number.indexOf(i) >= 0 ){ // -1이 아닌 애들 찾는다
	// 배열명.indexOf(데이터) : 배열내 해당 데이터의 인덱스 검색
	// 해당 데이터가 존재하면 찾은 인덱스 출력	
	// 해당 데이터가 존재하지 않으면 -1 출력
	alert( '이미 선택한 번호 입니다. [다시 선택]')
	return // 함수 종료
	}

	// 선택한 번호 배열에 저장
	select_number.push(i) // 배열명.push(데이터) : 배열의 데이터 추가
	document.getElementById('selectbox').innerHTML = select_number;
}
*/

// 3. 추첨번호 생성 함수
function lotto_number(){
	if(	select_numbers.length != 6){
		alert('6개의 수를 모두 입력 후 추첨해 주세요')
		return
	}
	
	// 난수 생성 [ 1 ~ 45 생성 ]
	while(true){	// 무한루프 [ 추첨번호가 6개가되면 종료 ]
	let rand = Math.floor((Math.random()*45)+1) // Math.random 0~1 사이의 실수 생성
								 				// Math.random() *끝값) +시작값 : 시작값 ~ 끝값 사이의 난수 실수 생성
						 						// Math.floor(실수) : 소수점 버림 함수
		let index = lotto_numbers.indexOf( rand )
		if(index == -1 ){ // 존재하지 않으면
			if(lotto_numbers.length == 6){	// 배열내 수가 6개이면 종료
				break	// 가장 가까운 반복문 끝내기
			}else{	// 배열수가 6개가 아니면 해당 난수를 배열에 저장
			
			lotto_numbers.push( rand )
			} // else e
		}
	} //while e
	
	// html 태그에 배열을 출력하는 태그
	document.getElementById('lottobox').innerHTML = lotto_numbers	
	// 결과 함수 출력
	lotto_result()
}	

// 4. 추첨번호 비교 결과 함수

function lotto_result(){
	let count = 0	// 두 배열 간 총 동일한 숫자의 개수 	
	// 얘는 for문 안에 넣으면 안됨
	// 3. 세번째 방법. 두 배열간 교집합 함수
	// filter( ) : 새로운 배열 생성[return true인 경우]
	// 배열명.includes(값) : 해당 배열에 값이 존재하면 true
	let result_numbers = select_numbers.filter((value) => {
	lotto_numbers.includes(value)

	})
	
	count = result_numbers.length
	let msg = '' // 출력할 메시지를 저장하는 변수
	
	if( count == 0 ){
		msg += '꽝'
	}else if(count == 1){
		msg += '1개 맞았습니다. ' + result_numbers
	}else if(count == 2){
		msg += '2개 맞았습니다. [5등] ' + result_numbers
	}else if(count == 3){
		msg += '3개 맞았습니다. [4등] ' + result_numbers
	}else if(count == 4){
		msg += '4개 맞았습니다. [3등] ' + result_numbers
	}else if(count == 5){
		msg += '5개 맞았습니다. [2등] ' + result_numbers
	}else if(count == 6){
		msg += '6개 맞았습니다. [1등] ' + result_numbers
	}
	document.getElementById('resultbox').innerHTML = msg
}


/*

	두 배열간 교집합[동일한 데이터] 구하기 방법
	
1. 첫번째 방법. 6배열 * 6배열 = 36번 확인함

	for(let i of select_numbers){
		// for(변수명 of 배열명) : 배열내 요소를 하나씩 변수에 대입 반복
		
		for( let j of lotto_numbers){
			if( i == j ){	// 동일하면
				count++		// 1 증가
			}	// if e
		}	// for e
		
		
2. 두번째 방법. 비교1 정보를 인덱스에 저장해서 비교2 대상에 같은게 있나 뿌림
		if(lotto_numbers.indexOf(i) != -1){
			count++
		}
	
	}	// for e

3. 세번째 방법.
	let result_numbers = select_numbers.filter((value) => lotto_numbers.includes(value))
	count = result_numbers.length	
	
*/











