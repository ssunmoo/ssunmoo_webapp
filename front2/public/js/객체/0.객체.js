
/*

	변수/상수 : 데이터(메모리) 한개
	배열 : 변수 여러개를 저장하는 객체
	함수 : 미리 정의된 코드
	객체[object] : 실제로 존재하는 사물 
	인스턴스 : 
		객체지향[oop] : 
		
		
		
		
		
*/
//	* 객체 : 메모리(변수, 배열)와 함수들의 모임

// p.246
// 1. 객체 생성
//	const/let 객체명 = { 키 : 값 , }
const product = {
	
	제품명 : '7D 건조망고',
	유형 : '당절임',
	성분:'망고, 설탕, 메타중아황산나트륨, 치자황색소',
	원산지 : '필리핀'
	
}
// 2. 객체 확인
	// 1. [객체호출] : 객체명
	// 2. [객체내 속성 호출] : 객체명[키값]
console.log('객체호출 : ' + product)
console.log('객체 내 속성 호출 : ' + product['제품명'])
console.log('객체 내 속성 호출 : ' + product['유형'])
console.log('객체 내 속성 호출 : ' + product.성분)
console.log('객체 내 속성 호출 : ' + product.원산지)


// p.248
// 1. 객체생성
const object ={
	number : 273,
	string : '구름',
	boolean : true,
	array : [52, 273, 103, 32],
	
	method : function(){ console.log('함수실행') }
}
// 2. 객체 내 속성과 메소드 = 함수 호출
console.log('객체 내 메소드 호출 : ' + object.method())











