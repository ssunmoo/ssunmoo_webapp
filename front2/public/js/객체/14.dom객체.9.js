

// contextmenu : 오른쪽 클릭했을때 이벤트


 
 // 1. 모든 사진들의 요소 호출 All 쓰면 여러개를 배열로 가져오겠다는 뜻
 const imgs = document.querySelectorAll('img')
 		// 배열[객체] = All --> 여러개 --> 배열
 
 
 // 1번. 기본 방법 
for(let i = 0; i < imgs.length; i++){
	imgs[i].addEventListener( 'contextmenu', ( event ) => {
		event.preventDefault()
	})
}	


 // 2. in은 인덱스 배열o
 for(let i in imgs){ // 마지막 인덱스 제외
	// 
	if( imgs.length-1 == i ){ break }
	imgs[i].addEventListener( 'contextmenu', ( event ) => {
		event.preventDefault()
	})
}

// 3. of는 값을 빼오는 것 배열x
for(let i of imgs){ 
	i.addEventListener( 'contextmenu', ( event ) => {
		event.preventDefault()
	})
}

// 4. forEach 배열o
imgs.forEach( ( img ) => {
	img.addEventListener( 'contextmenu', ( event ) => {
		event.preventDefault()
	})
})



/* ---- p.351 ---- */


let 상태 = false // 체크박스 체크 여부 확인 저장 변수[체크 되어있으면 true 체크 안되어있으면 false]

// html 요소 가져오기
const 체크박스 = document.querySelector('input')

// 체크박스에서 체크가 변경이 있을때 이벤트 실행
체크박스.addEventListener('change', ( 이벤트속성 ) => {
	상태 = 이벤트속성.currentTarget.checked
	// 변수명 = 변수명.checked
	
})

const 링크 = document.querySelector('a')

링크.addEventListener('click', ( 이벤트속성 ) => {
	if( !상태 ){	// ! 논리 반대
	//	if( 상태 == false )
	//	if( 상태 != true )
		// 만약에 상태가 false 이면 [체크가 안되어있으면을 찾는 것]
		event.preventDefault()
	}
})
































