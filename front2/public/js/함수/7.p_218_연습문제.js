/*
 	p_218 확인문제
 	
 */
 
 
 	// 확인문제 1. 
 function multiplyAll(a, b){
	let result = 1		// 1. a -> b 까지 모두 곱한 값을 저장하는 변수
	for(let i = a; i <= b; i++){
		// i는 a부터 b까지
		// result += i 	// 누적합계
		result *= i 	// 누적 곱 
	} // for 종료
	return result		// 함수 종료시 결과를 반환
}
 
 console.log('모두 곱한 결과 : ' + multiplyAll(1, 2))
 console.log('모두 곱한 결과 : ' + multiplyAll(1, 3))
 
 
 
 
 
 
  	// 확인문제 2-1.
  	
  	// 익명함수 선언 -> function(인수~)}
 const max = function( array ) {
	let maxvalue = array[0]	// 배열내 첫번째 값을 가장 큰 값
	for(let i of array){	// 배열내 요소(항목=값)를 하나씩 i에 대입하면서 반복
		if(maxvalue < i ){	// i의 값이 maxvalue 보다 크면 
		maxvalue = i		// maxvalue에 i 대입
		}
	}
		// for(let i of array){array[i]}
		// for(let i; i < array.length; i++){array[i]}
		// for(let i in 배열명){ 배열명[i] }: 배열에서 *인덱스를 하나씩 꺼내와서 대입 반복
		// for(let i of 배열명) : 배열에서 *값을 하나씩 꺼내와서 대입반복
		// for(let i; i<=배열명.length; i++){ 배열명[i] } :  
	return maxvalue
} 
	console.log('최대값 구하기 결과 : ' + max([1, 2, 3, 4]))
	

  	// 확인문제 2-2.
  	
 const max2 = function( ...array ) { // 가변 매개변수 함수 선언 -> ...매개변수명
	let maxvalue = array[0]	
	for(let i of array){	// 배열내 요소(항목=값)를 하나씩 i에 대입하면서 반복
		if(maxvalue < i ){	// i의 값이 maxvalue 보다 크면 
		maxvalue = i		// maxvalue에 i 대입
		}
	}
	return maxvalue
} 
	console.log('최대값 구하기 결과2 : ' + max2([1, 2, 3, 4])) 	
  		
	
	
	
  	// 확인문제 2-3.
  	
 const max3 = function( array, ...array2 ) {
	
	alert('타입확인: ' + typeof(array))
	alert('타입확인: ' + typeof(array2))
	
	let maxvalue = 0	// 최댓값 저장하는 변수
	let items = array2

	if(typeof(array) == 'object') {		// 배열(오브젝트)이면
		items = array
	}else if(typeof(array2) != 'number'){	// 숫자, 배열
		items = array2
	}



	// 최대값 구하기 함수
	for(let i of items){
		if(maxvalue < i ){
		maxvalue = i	
		}
	}
	return maxvalue
} 
	console.log('최대값 구하기 결과3 [배열 -> 매개변수 1개]: ' + max3([1, 2, 3, 4])) 	// 인수 2개 : 배열 1개 [1,2,3,4]
	console.log('최대값 구하기 결과3 [숫자 -> 매개변수 4개]: ' + max3(1, 2, 3, 4)) 		// 인수 2개 : 숫자1개[1], 배열1개[2,3,4]
			
	
	
	
	
	
/*	
	// 타입 확인 함수
	if(typeof(array) === 'number'){
		// typeof(메모리) : 자료형 확인 함수 [1. string 2. number 3. boolean 4. object]
	}
*/	
	
	
	
	
	
	