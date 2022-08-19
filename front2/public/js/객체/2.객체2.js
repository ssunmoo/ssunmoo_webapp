/*

	p.249
	자바스크립트 데이터를 저장하는 방법
		1. 변수/상수
		2. 배열
		*. 함수 : 1. 매개변수 2. 코드를 미리 정의 3. 리턴값
			1. 일반함수 : function 함수명 ( 매개변수 ){ 코드 return 리턴값 }
			2. 익명함수 : function ( ){ }
			3. [콜백함수]화살표 함수 : ( 매개변수 ) => 리턴값
			4. [객체메소드] : 함수명( ){ }

			 
		3. 객체
			

			let/const 객체명 = {
				키:값,
				키2:값,
				키3:값
				키4: function(){}
			}



 */
 
 // 1. 객체 생성
 const pet = {
	
	name : '구름',
	eat : function( food ){
		alert(this.name + ' 은/는 ' + food + ' 을/를 먹습니다.')
			// this : 자신이 가진 속성
			// 객체내부 = this.키 vs 객체외부 = 객체명.키
			
	}	// 함수 end
}	// 객체 end

 // 2. 객체 내 메소드 호출 [객체내 속성/메소드 호출할때 : 객체명.키]
 
 pet.eat('고기')
 
 
 
 
 // p.250 속성추가
 
 // 1. 객체만들기
 const student = { } // 비어있는 객체
 // 2. 기존에 없는 키 접근 -> 새로운 속성 부여
 student.이름 = '윤인성'
 student.취미 = '악기'
 student.장래희망 = '생명공학자'
 
 // 3. 객체 확인
 console.log(student)
 
 
 // 속성제거
 // 1. 객체내 속성 제거 [delete 객체명.키]
 delete student.장래희망
 
 // 2. 객체 확인
  console.log(student)

 // p.251 
 const pet2 = {
	name : '구름',
	eat( food ){	// eat : function( food ){ }
		alert(this.name + ' 이는 ' + food + ' 를 먹습니다.')
	}
}
pet2.eat
 
 
 // p.254 예제1.
 
 const 객체 = {
	name : '혼자공부하는파이썬',
	price : 18000,
	publisher : '한빛미디어'
}
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 