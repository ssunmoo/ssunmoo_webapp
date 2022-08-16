/*
 
	  익명함수 = 람다
	  * JS : 함수도 자료이다.	[함수도 변수처럼 사용이 가능하다]
	  매개변수에 함수 전달이 가능하다. [매개변수 : 변수, 배열, 함수]
	  매개변수 : 자료형[1.String 2.Number 3.Boolean 4. Object()]
	  
	  함수호출( 변수/상수 )
	  함수호출( 배열 )
	  함수호출( 함수 )
	  함수호출( functing(){} )
  
 */

// 콜백 함수 정의 [p.221]
function callThreeTimes(callback) {
	for (let i = 0; i < 3; i++) {
		callback(i)
	}

}

function print(i) {
	console.log(`${i}번째 함수 호출`)
}

// 함수호출

callThreeTimes(print)


// 익명 콜백 함수 정의 [p.222]
function callThreeTimes2(callback) {
	for (let i = 0; i < 3; i++) {
		callback(i)
	}
}

// 콜백 함수 : 익명 함수로 사용하기
callThreeTimes2(function(i) {
	console.log(`${i}번째 함수 호출`)
}	// 익명함수 끝

)	// 함수호출 끝



// p.223 배열의 forEach() 함수 메소드
	// forEach() : 배열 반복문[인덱스 값 호출] 함수 [해당 배열 순회]


let numbers = [273, 52, 103, 32, 57]

numbers.forEach(function(value, index, array){
	console.log(`${index}번째 요소 : ${value}`)
})

// * forEach() 사용 안할때 

function for_print(numbers){
	for(let i = 0; i < numbers.length; i++){
		console.log(`${i}번째 요소 : ${numbers[i]}`)
	}
}

for_print(numbers)



// 4. 배열의 map() 함수 p.223 [반환값(return)으로 새로운 배열]

numbers = numbers.map(function(value, index, array){
	return value * value
})

console.log('map 실행 결과 : ' + numbers)
numbers.forEach(console.log)




// 4. 배열의 filter() 함수 p.224 [반환값(return true 이면)으로 새로운 배열]


const evenNumbers = numbers.filter(function(value){
	return value % 2 == 0	// 짝수 공식
})

console.log('원래 배열 : ' + numbers)
console.log('짝수 배열 : ' + evenNumbers)












