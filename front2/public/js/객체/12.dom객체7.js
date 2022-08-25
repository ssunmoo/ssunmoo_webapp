/*
	키보드 속성 코드표 구글링하면 나옴
	왼쪽 방향키 = 37, 위쪽 방향키 = 38 등

*/

// 별의 초기 설정
const star = document.querySelector('h1')
star.style.position ='absolute'	// css 조작 = 포지션을 절대위치 [앱솔루트]로 주겠다


// 별의 이동을 출력하는 기능
let [ x, y ] = [ 0, 0 ]		// 키보드 이동 값		x : left의 위치를 저장하는 변수		y : right의 위치를 저장하는 변수
const block = 20 	// 이동단위
const print = () => {
	star.style.left = `${x*block}px`
	star.style.top = `${y*block}px`
}
	print()

			
const [ left, up, right, down ] = [ 37, 38, 39, 40 ]

document.body.addEventListener('keydown', (event) => {
	
		/*
		switch( event.keyCode ){
			case left :
				x -= 1	
				break
				
			case up :	
				y -= 1
				break
				
			case right :	
				x += 1
				break
				
			case down :
				y += 1
				break		
		}
		print()	// x와 y의 함수 호출
		*/
		/*
		if( right == event.keyCode ){
			x += 1
		}
		if(left == event.keyCode ){
			x -= 1
		}
		if(up == event.keyCode ){
			y -= 1
		}
		if(down == event.keyCode ){
			y += 1
		}
		print()
		*/
		
		if( left == event.keyCode ){
			x -= 1
		}else if( up == event.keyCode ){
			y -= 1
		}else if( right == event.keyCode ){
			x += 1
		}else( y += 1 )
		print()
		
})
























