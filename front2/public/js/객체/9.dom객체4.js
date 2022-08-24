/**
 * 
 */
 
 
// p.320
// 1. JS <h1> 태그 생성 -> header 객체에 대입
const header = document.createElement( 'h1' )

// 2. 텍스트 조작
header.textContent = 'js에서 만든 태그'
header.style.color = 'red'
header.style.backgroundColor = 'black'


// 3. 해당 태그에 하위 태그로 객체를추가
document.body.appendChild( header )




// p. 321

	// 1. 해당 di의 태그 객체 가져오기
const divA = document.querySelector('#first')
const divB = document.querySelector('#second')
const h1 = document.createElement('h1') // 2. 태그( 요소 ) 만들기
h1.textContent = '이동하는 h1 태그'	// 3. js가 만든 태그(요소)에 텍스트넣기	
	
	
	const toFirst = ( ) => {
		divA.appendChild( h1 )	// 4. 첫번째 div에서 js가 만든 태그 추가
		setTimeout( toSecond , 2000 ) // 5. 2초뒤에 다른 함수 [toSecond]를 싱행
	}
		
	const toSecond = ( ) => {
		divB.appendChild( h1 )
		setTimeout( toFirst, 2000 ) // 5. 2초뒤에 다른 함수 [toFirst]를 싱행
	}
	
toFirst() // 6. 함수실행
		
/*

	// 1. 기본 함수
	function 함수( ) {
		divB.appendChild( divA )
	}
	
	// 2. 익명함수
	const 익명함수 = function( ) {
		divB.appendChild( divA )
	}
	
	// 3. 화살표함수 
	const 화살표함수 = ( ) => { divB.appendChild( divA ) }

	// 4. 콜백함수
	// 함수( 함수 )
	
}
// 3. 타이머함수( 함수() , 밀리초(1000/1초) )
setTimeout( toSecond , 3000 )

*/




// p.322 객체 제거

const h2 = document.querySelector('h2')

// 1. 타이머함수 : setTimeout( 함수, 밀리초 )  // 1회용
// 2. 문서객체.removeChild( 자식객체 )
// 3. 부모객체 찾기 : 문서객체.parentNode
setTimeout ( ( ) => {
	
	h2.parentNode.removeChild(h2)
	
} , 3000 )	// 3초 후 실행되는 코드


// 2. 익명함수	// 이름은 없지만 변수로 저장했기 때문에 재사용 가능
const 익명함수 = ( ) => {
	h2.parentNode.removeChild(h2)
}
	setTimeout(익명함수 , 3000)
	
// 3. 기본 함수	// 함수명으로 저장했으니까 재사용 가능
function 함수() {
	// h2.parentNode.removeChild(h2)// h2의 부모 부분을 확인해서 자식 녀석들중 h2를 제거하겠다
	document.body.removeChild(h2)	// 문서에서 바디에있는 내용중 h2를 제거하겠다
}
	setTimeout(익명함수 , 3000)















