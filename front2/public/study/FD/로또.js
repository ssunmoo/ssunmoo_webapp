/*

	1. 로또 시작하기 버튼을 눌렀을때 로또 버튼 45개 출력
	2. 45개 버튼 중 선택한 번호가 누적되어 출력되도록
	3. 중복 숫자는 누를 수 없음
	4. 6개까지만 선택 가능
		- 번호 추첨
	5. 당첨번호 6개가 랜덤으로 출력되도록(6개 한번에, 6개 까지만)
	6. 중복 숫자는 출력될 수 없음
	7. 내가 선택한 번호와 추첨된 번호 비교
	8. 당첨된 번호가 어떤 것인지 출력
	9. 당첨자 발표(1등. 22억! 2등. 3천만원! 3등. 100만원 4등. 5만원 5등. 5천원 꽝!)

*/


let 로또번호저장 = [];		// 빈칸으로 만들었다가 배열로 수정
let count = 0;
let 난수저장 = [];
let 당첨박스 = [];

// 로또 버튼 45개 만들기
function 로또버튼생성(){
	
	let 로또판생성 = '';	// 0으로 만들었다가 0이 찍혀서 빈칸으로 수정
	for( let i = 1; i < 46; i++ ){	// 
		로또판생성 += `<button id=${i} onclick=선택(${i})> ${i} </button>`					
								// 온클릭에 function 이름을 넣어서 바로 실행되도록
		if( i % 5 == 0 ){
			로또판생성 += `<br>`
		}						
	} // for 종료
	document.getElementById('로또판생성').innerHTML = 로또판생성 // 저장된 버튼들을 html에 있는 로또판생성에 보내줌
}// f 종료



// 로또 숫자를 눌렀을때 실행
function 선택( i ){

	for ( let j = 0; j < 6; j++ ){
		if ( 로또번호저장[j] == null ){	// 로또번호저장 배열[j]번째가 값이 없을 경우
			로또번호저장[j] = `${ i }`
			document.getElementById('내번호출력').innerHTML = 로또번호저장
			
			중복검사()
			count++;
			
			if ( count == 6 ){
				alert("번호 선택이 완료되었습니다.")
				컴퓨터선택()
				return;
			} // if 종료
			return;
		}// if 종료
	}//for 종료
}// f 종료


// 랜덤함수 => 컴퓨터 턴

function 컴퓨터선택( ){ // 내가 선택하면 컴퓨터가 난수 하나씩 선택해줌 근데 배열에 담겨지지 않음

	while( 난수저장.length < 6 ){ // 난수저장.length < 6 랭스가 6미만까지 
		let 랜덤출력 = Math.floor(Math.random()*45+1);		// Math 함수를 사용해서 랜덤 숫자를 출력 
		
		if ( 난수저장.indexOf( 랜덤출력 ) > 0 ) { // 값이 있을때
			난수저장.push( 랜덤출력 )
			console.log( 난수저장 )
			break;
		}
		else {
			break;
		}
	} // while 종료
	당첨()
	console.log(당첨박스)
} // 함수 종료

// 중복검사 함수써서 같은 값이 있는지


function 중복검사(){
	for ( let i = 0; i < 로또번호저장.length; i++){
		if( 로또번호저장[i] == i ){	// 선택한 숫자가 동일할 경우
		로또번호저장[i] = null	// 이미 값을 저장했으니 비워줘야함
		count--;
		alert("이미 선택한 번호입니다. 다시 선택해주세요.")
		continue;
		} // if 종료
	} // for 종료
} // 함수 종료



function 당첨 ( ){
	for( let i = 0; i < 6; i++ ){
		for (let j = 0; j < 6; j++ ){
			if( 로또번호저장[i] == 난수저장[j] ){
				당첨박스 = j;
			} // if 종료
		} // for 종료
	} // for 종료
	document.getElementById('결과').innerHTML = 당첨박스
} // 함수 종료
















