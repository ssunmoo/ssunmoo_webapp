/*

	자료 : 데이터
	자료형 : 데이터 타입
		1. 숫자 2. 문자열 3. 불
	
	1. 숫자
	소수점이 있는 숫자와 없는 숫자를 모두 같은 자료형으로 표현
	
	
	2. 문자열
	사용방법 : ' ', " "
	문자열 길이 : 문자열.length

	3. 불
	true / false
	
	undefined = null 과 같음
	
	
	4. 자료형 변환
	Number(데이터) : 숫자 형변환
	String(데이터) : 문자열 형변환
	Boolean(데이터) : 불 형변환
	
	
	
	
*/

console.log("안녕하세요");
console.log("안녕하세요".length);

console.log(273);
console.log(273.311);


const pi = 3.141592;
console.log(pi);
// pi = 4.14;
// 상수는 변경 불가 [ java -> final / static 과 같음 ]

let pi2 = 3.141492;
console.log(pi2);
pi2 = 4.14;

// prompt("입력받는창");
// confirm("예/아니오!");


// 문제1 지폐세기
// 조건 : 금액 입력받기
// 출력 : 십만원 3장
//		 만원 2장
//		 천원 1장
//		 백원 0장


let 금액 = Number(prompt("금액을 입력하세요"));
console.log("입력받은 금액 : " + 금액);

console.log("십만원 : " + parseInt(금액/100000));
금액 = (금액%100000)

console.log("만원 : " + parseInt(금액/10000));
금액 = (금액%10000)

console.log("천원 : " + parseInt(금액/1000));
금액 = (금액%1000)

console.log("백원 : " + parseInt(금액/100));

// parseInt(숫자) = 정수로 변환

let 금액2 = Number(prompt("금액을 입력하세요"));
console.log("입력받은 금액 : " + 금액2);

let 십만원 = parseInt( 금액2/100000 );
console.log("십만원 : " + 십만원);
금액2 -= 십만원*100000;	 // 원 금액에서 십만원권 제거

let 만원 = parseInt( 금액2/10000 );
console.log("만원 : " + 만원);
금액2 -= 만원*10000;	// 원 금액에서 만원권 제거

let 천원 = parseInt( 금액2/1000 );
console.log("천원 : " + 천원);
금액2 -= 천원*1000;	// 원 금액에서 천원권 제거

let 백원 = parseInt( 금액2/100 );
console.log("백원 : " + 백원);




let 정수1 = Number(prompt("정수1 : " ));
console.log( "홀수 여부 : " + (정수1 % 2 == 1));

let 정수2 = Number(prompt("정수2 : " ));
console.log( "7배수 여부 : " + (정수2 % 7 == 0));

















