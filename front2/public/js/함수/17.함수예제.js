/*
 
 	1. 인수
 	2. 실행문
 	3. 결과
 	
 	함수 : 미리 정의된 코드 집합 (필요할때 쓰려고 미리 저장)	
 		alert, prompt -> js 내장함수

	함수 만들기(정의) :
		 function 함수명(매개변수, 매개변수2, ~~){ 
			실행코드
			return 리컨값
		}
 	
 	함수 호출
 		js : 함수명(매개변수1, 매개변수2 ~ )
 		html :  tag 속성 내 이벤트 속성
 			onclick : 클릭했을때
 			onclick = "함수명(매개변수1, 매개변수2, ~~)"
 	
 */
 
 //	1. 매개변수x 리턴값x 함수 정의
 function 함수1(){
	alert('함수1실행')
}
 
 // 2. 매개변수o 리턴값x 함수 정의
 function 함수2(value){
	alert('출력 : ' + value)
}
 
 // 3. 매개변수o 리턴값o 함수 정의
 function 함수3(value, value2){
	alert('함수3 출력 : ' + value + value2)
	return value + value2
}
 
 // 4. 매개변수x 리턴값o 함수 정의
 function 함수4( ){
	alert('함수4 출력 : ')
	return 10
}
 
 
 // 호출
함수1() // js에서 정의된 함수를 호출하는 방법
함수2( 50 )	// 함수 호출 시 매개변수 전달
let result = 함수3( 3, 5 ) // 2개의 매개변수 전달
let result2 = 함수4()
 
 
 
 
 // p.204 최솟값을 구하는 함수
 	// min 이름으로 함수 선언하는데 매개변수가 array 이다
 function min(array){
	let output = array[0]	// array에서 0번째 인덱스를 호출해서 output에 저장
	for(const item of array){
		// 배열에 요소를 하나씩 item에 대입 반복
			// for(변수 in 배열) : 배열내 [인덱스]를 하나씩 대입 반복
			// for(변수 of 배열) : 배열내 [요소의 값]을 하나씩 대입 반복
		if(output > item){	// 해당 값이 output 보다 작으면
			output = item	// output 해당 값으로 교체
		}
	}
	return output	// 함수가 종료되면서 함수를 호출했던 곳으로 반환[리턴]
}
 
 const testArray = [52, 273, 32, 103, 275, 24, 57]	// 배열을 선언하고 7개의 값을 초기화
 console.log(`${testArray} 중에서`)	// 배열 출력
 console.log(`최솟값 = ${ min(testArray) }`)	// 함수 결과 출력
	// console.log(): js 내장 함수 [콘솔에 메시지를 출력하는 함수] 
 
 
 
 
 
 
 
 
 
 
 