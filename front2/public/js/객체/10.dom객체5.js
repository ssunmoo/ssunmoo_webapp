/**
 * 
 */
 
 
 
 let counter = 0	// 클릭 수를 저장하는 변수
 let isConnect = false	// 연결 상태를 저장하는 변수
 
 // 요소 객체들
 const h1 = document.querySelector( 'h1' )	// 요소 가져오기 [ 호출 ]
 const p = document.querySelector( 'p' )	// 요소 가져오기 [ 호출 ]
 const connectBtn = document.querySelector( '#connect' )	// 요소 가져오기 [ 호출 ]
 const disconnectBtn = document.querySelector( '#disconnect' )	// 요소 가져오기 [ 호출 ] 
 
 const a = document.querySelector('#a')
 const b = document.querySelector('#b')
 
 
 // 출력하는 함수
 const listener = () =>{
	counter++
	h1.textContent = `클릭횟수 : ${counter}`
}
 
 const listener2 = () =>{
	counter--
	h1.textContent = `클릭횟수 : ${counter}`
}
 
 // 1. 연결
 connectBtn.addEventListener( 'click' , ( ) => {
	if(isConnect == false){	// 만약에 연결이 안되어있으면
		// h1.addEventListener( 'click', listener)	// h1 태그에 클릭 이벤트 추가
		
		a.addEventListener( 'click', listener )
		b.addEventListener( 'click', listener2 )
		
		p.textContent = '이벤트 연결 상태 : 연결'	// p 태그에 내용 넣기
		isConnect = true	// 연결 했다는 의미로 연결상태 변수에 true로 변환
	}
})
	 
 // 2. 연결해제 
 disconnectBtn.addEventListener( 'click' , ( ) => {
	if(isConnect == true){	// 만약에 연결 되어있으면
		// h1.removeEventListener( 'click' , listener  )	// h1 태그에 클릭 이벤트 제거
		
		a.removeEventListener( 'click' , listener )
		b.removeEventListener( 'click' , listener2 )
		
		p.textContent = '이벤트 연결 상태 : 해제'
		isConnect = false	
	}
}) 
 
 /*
 // 증가
a.addEventListener( 'click', listener)

 
 // 감소
 b.addEventListener( 'click', listener2)
 
 */
 
 
 /*
 // 객체명.addEventListener( '이벤트명', 콜백함수 )
 	// 해당 객체의 이벤트가 발생했을때 콜백함수 실행된다
 h1.addEventListener( 'click' , ( event ) => {
	
	counter++	// 변수에 1증가
	h1.textContent = `클릭횟수 : ${counter}`

})
 /* 두번째 방법 기본 함수 사용 시
 h1.addEventListener( 'click', 함수)
 function 함수(){
	counter++
	h1.textContent = `클릭횟수 : ${counter}`
}

 
 // 3. html에서 클릭 이벤트 속성을 이용한다.
 function 함수(){
	counter++
	h1.textContent = `클릭횟수 : ${counter}`
} 
 
 */
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 