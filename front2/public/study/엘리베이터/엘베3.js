/*
 
내층
엘베층
전체층

엘베가 층수 저장할 변수?

1. 엘베호출

2. 엘베도착문구

3. 탑승안내문구

4. 층수선택

5. 이동

6. 도착안내문구


*/
 
 // 1. 출발층, 엘베층, 전체층 받아올 변수 생성
 
 let 전체층 = Number(prompt('전체층 입력 : ')) 
 let 출발층 = Number(prompt('출발층 입력 : '))
 let 엘베층 = Number(prompt('엘베층 입력 : '))
 
 document.getElementById('엘베층수보여줘').innerHTML = `엘리베이터는 ${엘베층} 층에 있습니다`



function 위(){
	if( 전체층 >= 엘베층 ){	// 엘베는 전체층을 넘지 않을때
		let 타이머 = setInterval(() => {
			엘베층++	// 엘베층에 1씩 더해줘
				if( 전체층 == 엘베층 ){	// 전체층이랑 엘베층이 같아졌을경우
				clearInterval(타이머)	// 타이머 종료
				}return	// 수식종료
		})
	} document.getElementById('엘베층수보여줘').innerHTML = `현재 층수는 ${엘베층} 입니다.`		
}	
	
function 아래(){
	if( 엘베층 <= 1 ){
		let 타이머 = setInterval(() => {
			엘베층--	// 엘베층에 1씩 빼줘
				if( 엘베층 == 1 ){	// 엘베층이랑 1층이 같아졌을경우
				clearInterval(타이머)	// 타이머 종료
				}return	// 수식종료
		})
	} document.getElementById('엘베층수보여줘').innerHTML = `현재 층수는 ${엘베층} 입니다.`	

}	


// 엘베 호출할 함수 + 호출버튼 만들기
// html 호출 버튼에다가 어떻게 넣더라,, html에 온클릭이름이랑 같게 만드는게 맞았나,,?
function 엘베호출(){
	if(엘베층 > 출발층){	// 엘베층이 출발층보다 높을때
		아래()	// 아래로 내려가는 함수 호출
		}else if(엘베층 < 출발층){
		위()
	} document.getElementById('엘베층수보여줘').innerHTML = `현재 층수는 ${엘베층} 입니다.`
}











































/*
function 아래(){
	엘베층--	// 엘베층에 1씩 빼줘
	if( 엘베층 <= 1 ){	//	엘베층이 1층보다 클경우 
		alert('최하층입니다.')	
		return
	}	
	document.getElementById('엘베층수보여줘').innerHTML = `현재 층수는 ${엘베층} 입니다.`
}	
*/








 
 // 2. 엘베가 움직일 수 있도록 움직이는 함수 생성
 // 엘베는 위 아래로 움직이니까 2개 생성하기

/*

function 위(){
	let 올라가자 = ''	// 올라가는 층수를 저장해줄 변수
	if(엘베층 < 출발층){ // 엘베층이 출발층보다 낮다면 올라가야돼
		for(let i = 엘베층; i < 출발층; i++){	// 엘베층이 출발층이랑 같아질때까지 1씩 증가해 
			올라가자 += i
		}	return
	}	alert('올라가자')
}
	위() // 호출
 

function 아래(){
	let 내려가자 = ''	// 내려가는 층수를 저장해줄 변수
	if(엘베층 > 출발층){
		for(let i = 엘베층; i > 출발층; i--){	// 엘베층이 출발층이랑 같아질때까지 1씩 내려와
			내려가자 += i
		}	return
	}	alert('내려가자')
}	
 	아래() // 호출
	
	
	
// 엘베호출 버튼을 눌러서 호출해보자,,

function 엘베호출(){
	if(엘베층 < 출발층){	// 엘베층이랑 나랑 같지 않을때 나한테 와야돼
		위()
		
	}	
	
} 	
	
*/
















	
	
	
	