/*

	객체지향 프로그래밍
	클래스[ 객체 설계도 ] 
	객체[ object ] : 메모리들의 집합소
	객체 멤버
		1. 변수[데이터 1개], 상수[데이터 1개], 배열, 함수
	예) 
		자동차 = 객체 				붕어빵틀[클래스 설계도]
			핸들 = 객체				붕어빵 = 객체
			의자 = 객체					
			엔진 = 객체				
		
*/



// p.291

/* 1. 객체선언 = {
	속성1 key : value ,
	속성2 key : array[] ,
	메소드 : function(){ } }
	
*/

const object = {
	name : '혼자 공부하는 파이썬',
	price : 18000,
	publicsher : '한빛미디어'
}

// 2. 객체 내 속성/메소드 확인 호출 시 [ .연산자 ]
	// 객체명.속성명[key]
	// 갹채명.메소드()			: 메소드 이기 때문에 매개변수(인수)가 필요함 / () 소괄호 필수
	
if( object.name !== undefined ){ // 만약에 객체내 name 속성이 있는지
	
	console.log('name 속성이 있습니다.')		
}else{
	console.log('name 속성이 없습니다.')
}


if(object.author !== undefined){
	
	console.log('author 속성이 있습니다.')		
}else{
	console.log('author 속성이 없습니다.')
}




// p. 293 상함(항이 3개) 연산자
// 조건(논리) ? 참 : 거짓


object.name = object.name !== undefined ? object.name : '제목 미정'
			// 조건 : object.name == undefined		// name 이라는 속성이 없으면
			// 참  : '제목미정'
			// 거짓 : object.name // 기존 그대로
object.author = object.author !== undefined ? object. author : '저자 미상'


// 객체 출력
console.log(object)


/*

//	p.294 배열의 다중할당
let array = [1, 2, 3]		// 배열의 원형
let [ a, b ] = [ 1, 2 ]		// 배열의 다중 할당
console.log( a )
console.log( b )

		// a = 1
		// b = 2
	
	
[ a, b ] = [ b, a ]
console.log( a )
console.log( b )

*/


let arrayA = [1, 2, 3, 4, 5]
const [a, b, c] = arrayA
console.log(a, b, c)



// p.295

const { name, price } = object
	// object 객체 내 속성 꺼내기 -> 변수에 저장 

console.log( name )
console.log( price )


const { n = name, p = price } = object
	// object 객체 내 속성 꺼내기 -> 변수에 저장 

console.log( n )
console.log( p )


// let n2 = object.name 랑 같음



































