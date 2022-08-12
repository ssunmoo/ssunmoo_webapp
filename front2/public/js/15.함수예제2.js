/**
 * 
 */
 
function sumAll(a, b){
	// sumAll 이름으로 함수명 선언, a, b라는 이름으로 매개변수 선언
		// 매개변수 : 외부에서 함수 호출시 들어오는 값[데이터]
		
	let output = 0
		// 변수[사용목적 : 누적값 저장]
	
	for(let i = a; i <= b; i++){
		// i는 a부터 b까지 1씩 증가 반복처리
		output += i		// vs output = output + i 
	}
	
	return output	// output 함수를 호출했던 위치로 리턴한다
}

	console.log(`1부터 100까지의 합 : ${sumAll(1, 100)}`)
	console.log(`1부터 100까지의 합 : ${sumAll(1, 500)}`)
	
// 계산하기 버튼을 눌렀을때 함수	
function 계산버튼함수(){	
	alert('버튼눌림 성공')
	let snumber = Number(document.getElementById('sinput').value)
	let enumber = Number(document.getElementById('einput').value)
	let result = sumAll(snumber , enumber)
	
	document.getElementById('resultbox').innerHTML = '계산결과 : ' + result
	
	
}





















