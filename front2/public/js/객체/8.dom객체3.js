/**
 * 
 */
 
 document.addEventListener('DOMContentLoaded', () => {
 
 	//	1. p.314 텍스트 조작
 	
	 const a = document.querySelector('#a')	// 해당 id의 요소 가져오기
	 const b = document.querySelector('#b')
 
	 a.textContent = '<h1> textContent </h1>'
	 b.innerHTML = '<h1> innerHTML </h1>'
	 
	 
	 // 2. p.315 속성 조작
	 const rects = document.querySelectorAll('.rect') // 해당 class의 모든 요소 가져오기
	 	// 길이 1~10		// 인덱스 0~9
	 for(let i = 0; i < rects.length; i++){
		// [i : 인덱스로 사용할 변수] i는 0부터 마지막인덱스까지
		const width = ( i + 1 ) *100
		const src = `http://placekitten.com/${width}/250`
		rects[i].setAttribute('src', src)
		//	rects.src = src
		// 배열내 해당 i번째 인덱스의 태그 속성을 추가[ 이미지 경로 ]
	}
	 
	 
	 // 3. p. 318 스타일 조작
	 const divs = document.querySelectorAll('#divbox div') // divbox 안에있는 div를 선택
	 										// 상위태그 > 하위태그
	 										// 상위태그 하위태그
	 divs.forEach((div, index) => {
		// 배열명.forEach( [ 콜백함수 ] ( 반복(요소) 변수, 인덱스 변수, 배열명 ) => { } )
			// 배열에 있는 요소들을 하나씩 반복 변수에 저장 대입
			// 배열에 인덱스들을 하나씩 인덱스 변수에 저장 대입
			// 함수내에서 사용할 배열명 대입
			
		// 배열명.forEach( ( 요소명 ) => { } )
			
		// 배열명.forEach( ( 요소명, 인덱스 ) => { } )
		
		console.log(div, index)	// 확인
		const val = index *10	// 인덱스 * 10
		div.style.height = `10px`	// 높이
		div.style.backgroundColor = `rgb(${val}, ${val}, ${val})`
		
	})
	 
	 
	 
})	





















