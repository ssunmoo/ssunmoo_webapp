/*
 
 	p.226	1초 하려면 1 * 1000
 		* 타이머 함수 : 콜백함수 [ 내장함수 ]
 		setTimeout{함수, 시간[밀리초]} : 시간 이후에 한번 함수 실행
 			clearTimeout{함수, 시간[밀리초]} : 타이머 종료
 		setInteval{함수, 시간[밀리초]} : 매 시간마다 함수 실행
 			clearInterval(함수변수) : 타이머 종료
  
 */
 
 
 setTimeout(() => {
	console.log('1초 후에 실행됩니다.')
}, 1 * 1000)
let count = 0	
	
let 타이머 = setInterval(() => {
	console.log(`1초마다 실행됩니다${count}`)
	count++
	
	if(count == 5){		// 5초뒤에 끄겠다
		clearInterval(타이머)
	}
	
}, 1 * 1000)


 