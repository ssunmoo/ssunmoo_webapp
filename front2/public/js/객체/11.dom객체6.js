/*
 
 
 	1. DOM : 문서 객체 모델 [ 미리 만들어진 객체/메소드 ]
 		
 		* 식별자 [js , css 동일]
 			tag, class[.], id[#]
 		
 		1. HTML에 요소
 			1. querySelector('식별자명')		: 1개
			2. querySelectorAll('식별자명')	: 여러개
			 		
 		2. 문서객체.addEventListener( '이벤트명', 함수 )
 			1. 이벤트 종류
 				1. 'click' : 해당 객체를 클릭했을 때 함수 실행
 				2. 'keyup' : 해당 객체에서 키[키보드]가 떨어질 때 함수 실행
 				
 				
 */
 

// p.331
	// 1. HTML 태그를 문서객체화
const 긴글상자 = document.querySelector('textarea')
const 헤더텍스트 = document.querySelector('h1')

								//인수  //결과				
긴글상자.addEventListener('keyup', ( ) => {
	
	const 길이 = 긴글상자.value.length
	헤더텍스트.textContent = `글자 수 : ${ 길이 }`
})			// html에 텍스트 찍어줌


 // 긴글상자.onkeyup = () => { }		// 이렇게도 가능


function 글자수(){
	const 길이 = 긴글상자.value.length
	헤더텍스트.textContent = `글자 수 : ${ 길이 }`
}


// p.333
	// html 이벤트 속성 [ event ]
	//	keyup 이벤트 -> 속성 인수 전달 [ .altKey .ctrlKey .shiftKey]
const h2 = document.querySelector('h2')
const print = ( event ) => {
	
	let output = ''
	output += `alt : ${event.altKey}<br>`
	output += `ctrl : ${event.ctrlKey}<br>`
	output += `shift : ${event.shiftKey}<br>`
	output += `code : ${typeof(event.code) != 'undefined' ?
		event.code : event.keyCode}<br>`
	
	h2.innerHTML = output
}
document.addEventListener( 'keyup', print )























 