/*
  
 */
 
 					// 함수( 이벤트, 콜백함수( 인수 ) => { 결과 } ) 인수를 넣어서 결과를 낸다
 document.addEventListener('DOMContentLoaded', () => {
						// DOMContentLoaded : 우선순위를 바꾼다, html 문서를 읽고나서 js 읽기해준다는 명령어 
	// 변수 선언	= h1 태그 이름으로 요소(태그) 선택[태그를 js 객체로 가져오기]
	const header = document.querySelector('h1')	// html내 h1의 속성을 바꿔줄거야
		// querySelector : 요소 1개 가져오기
		// querySelectorAll : 요소 여러개 가져오기 [배열]
	
	
	console.log(header)
	console.log(typeof(header))	// typeof() : 자료형[1. string 2. boolean 3. number 4. object(배열,함수,dom)] 확인
	
	
	// 텍스트와 스타일 변경
	header.textContent = '안녕'
	
	// css 조작 시 [Dom객체명.style.속성명 = 값]
	header.style.color = 'white'
	header.style.backgroundColor = 'black'

})
 
 
 document.addEventListener('DOMContentLoaded' , () => {
	
	const headers = document.querySelectorAll('h1')
	
	console.log(headers)
	console.log(typeof(headers))
	
	// 배열내 데이터를 하나씩 꺼내는 방법
	// 1. 배열 인덱스 사용
	for(let i = 0; i < headers.length; i++){
		headers[i].textContent = '안녕'+i
	}
	
	// 2. 인덱스를 하나씩 넣어줌
	for(let index in headers){	// 0부터 마지막 인덱스까지 인덱스를 하나씩 대입반복
		headers[index].textContent = '안녕'+index
	}
	
	// 3. 오브젝트를 하나씩 넣어줌
	for(let object of headers){	// 0번째 인덱스의 데이터를 마지막 인덱스의 데이터를 하나씩 대입반복
		object.textContent = '안녕'
	}
	
	// 4. 
	headers.forEach( ( object ) => {
		object.textContent = '안녕'
		
	})
	
	
	
	
})
 
 
 
 