/*
 
 	함수 : 미리 정의된 코드
 		기본 형태 : 1. 매개변수 2. 정의코드 3. 리턴값
 		사용 목적 : 1. 재활용 2. 메모리 효율성 3.매개변수에 따른 서로 다른 리턴값
 		사용 코드 : function 함수명 ( 매개변수 ~ ){ 정의코드 return 리턴값 }	
 				매개변수(인수) : 함수 안으로 들어오는 수(선택사항) 선택사항이기 때문에 없을수도있음
 					- 자료형이면 가능 [변수, 상수, 배열, 함수]
				리턴값(반환) : 함수 밖으로 나가는 수 	(선택사항) 	
 		** 함수도 자료형이다! [ Object -> 1. array(배열) 2. function ]
 			
 	1. 익명함수 : 이름이 없는 함수
 		function (){ }
 		
 	2. 선언적 함수 : 일반 함수 	
 		function 함수명(){ }
 		
  	3. 나머지 매개변수 : 매개변수의 개수가 정확하지 않을 때 ...으로 입력 -> 배열로 받아옴
  		function 함수명(...매개변수){ } 
  		
 	4. 기본 매개변수 : 매개변수의 초기값 설정
   		function 함수명(매개변수 = 값){ } 
		
 	5. 콜백함수 : 함수도 자료형이기 때문에 매개변수로 전달이 가능하다.
 		function 함수명(매개변수){
			
		 } 
		function 함수명2(){ } 
 		함수명(console.log)
 
 		* 미리 만들어진 콜백 형태의 배열내 함수들
 		forEach() 	: 반복문
 		map()		: 새로운 배열 생성 [return 된 값을 새로운 배열에 저장]
 		filiter()	: 새로운 배열 생성 [return 된 값이 true인 경우에만 새로운 배열 저장]

	6. 화살표 함수 : function 을 생략
		(매개변수) => 결과
 	
 
 */
 
 
 
 
 // p.226 화살표함수
 //	function, return 생략
 // (인수) => 결과
  let numbers = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
 
 /*
 numbers.filter(function(value){
	return value % 2 == 0	
}) 아래 코드와 동일한 것 function 을 => 로 바꿔준 것
 
 */
 
 
 // 화살표 함수를 사용했을 때
 numbers
 	.filter((value) => value % 2 == 0)
 	.map((value) => value * value )
 	.forEach((value) => {
		console.log(value)
})
 
 
 // 화살표 함수가 아닐때
  numbers
 	.filter(function(value) {
	return value % 2 == 0
})	.map(function(value) {
	return value * value
})	.forEach(function(value) {
		console.log(value)
})
 
 
 
 
 
 // 메소드 체이닝(결과 연결)을 사용하지 않을 때
 	// 배열명.메소드1().메소드2() : 메소드1 결과를 가지고 메소드2 실행
 	
let array1 = numbers.filter((value) => value % 2 == 0) 	
console.log("짝수 배열 : " + array1) 
let array2 = array1.map((value) => value * value)
console.log("짝수들의 제곱 : " + array2) 
array2.forEach((value) => console.log(value))
 
 
 
 
 
 
 
 
 
 
 
 