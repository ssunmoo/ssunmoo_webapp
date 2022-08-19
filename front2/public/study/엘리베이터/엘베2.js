/**
 * 
 */
 
 let 엘베전체층수출력 = ''	// 엘베 층수를 저장할 변수
 let 내위치 = Number(prompt('내 위치를 입력하세요'))
 let 엘베위치 = Number(prompt('엘베위치를 입력하세요'))
 

 function 엘베리스트출력(){

	for(let i = 20; i > 0; i--){	// 1부터 5까지 1씩 증가	
		엘베전체층수출력 += `<button id=${i} onclick=엘베리스트(${i})> ${i} </button>`
		// i값을 엘베전체층수출력에 누적 더하기
		
		if(i % 1 == 0){ // 한줄로 처리하고싶음, 1로 나눴을때 값이 남지 않으면 줄바꿔줘 
			엘베전체층수출력 += '<br>'
		}
	}
	document.getElementById('엘베리스트출력').innerHTML = 엘베전체층수출력
}
	엘베리스트출력()  // 호출!!
	

	
	/*
	 상승 버튼을 눌렀을때 엘베층수가 나보다 높으면 
	 엘베리스트출력 1부터 시작해서 최대 엘베위치까지 올라간다 
	 엘베가 올라가는게 자동으로 표시가되야함
	*/



function 상승(){ // 상승버튼을 눌렀을때
	if( 엘베위치 > 내위치 ){ 	//엘베위치가 내 위치보다 높을경우

		let ev_up = setInterval(() => { // 타이머를 돌아가게할건데
		let count = 0; // 숫자를 저장할 변수
			
			for(i = 엘베위치; i > 내위치; i--){
				count++
				alert(`${ 엘베위치 - count } 층입니다.`) // 엘베위치는 -1씩되고 카운트는 1개씩 올라가니까		
					
					if( (엘베위치 - count) == 내위치 ){
					clearInterval(ev_up) // 카운터 종료한다
					}
			} alert('엘리베이터가 도착했습니다. 문이 열립니다.')
		
			document.getElementById('엘베위치').innerHTML = 엘베위치 - count + '층'
		}, 1 * 1000) 
		// 시작시간을 엘베 위치 5에서 내 위치 2까지로 어떻게넣음...?????
	}
	document.getElementById('내위치').innerHTML = 내위치 + '층'
}




function 하강(){ // 상승버튼을 눌렀을때
	if( 엘베위치 < 내위치 ){ 	//엘베위치가 내 위치보다 낮을 경우

		let ev_up = setInterval(() => { // 타이머를 돌아가게할건데
		let count = 0; // 숫자를 저장할 변수
			
			for(i = 엘베위치; i < 내위치; i++){
				count++
				alert(`${ 엘베위치 + count } 층입니다.`)	
							
				if( (엘베위치 + count) == 내위치 ){
				clearInterval(ev_up) // 카운터 종료한다
				}
			} alert('엘리베이터가 도착했습니다. 문이 열립니다.')
		/* 	
			while(true){
				엘베위치-- // 엘베 위치를 1씩 빼줘
				if(엘베위치 == 내위치) { // 엘베위치가 내위치랑 같아지면
					break			// 멈추고 와일 나가기
				}
			}
		*/
			document.getElementById('엘베위치').innerHTML = 엘베위치 + count + '층'
		}, 1 * 1000) 
		// 시작시간을 엘베 위치 5에서 내 위치 2까지로 어떻게넣음...?????
	} 
	
	document.getElementById('내위치').innerHTML = 내위치 + '층'
}



































































/* 

function 상승(){ // 상승버튼을 눌렀을때
	if( 엘베위치 > 내위치 ){ 	//엘베위치가 내 위치보다 높을경우

		let ev_up = setInterval(() => { // 타이머를 돌아가게할건데
		let count = 0; // 숫자를 저장할 변수
			
			for(i = 엘베위치; i > 내위치; i--){
				count++
				alert(`${ 엘베위치 - count } 층입니다.`) // 엘베위치는 -1씩되고 카운트는 1개씩 올라가니까		
					if( (엘베위치 - count) == 내위치 ){
					clearInterval(ev_up) // 카운터 종료한다
					}
			} alert('엘리베이터가 도착했습니다. 문이 열립니다.')
		
		// 첨에 생각한 와일 s
		
			while(true){
				엘베위치-- // 엘베 위치를 1씩 빼줘
				if(엘베위치 == 내위치) { // 엘베위치가 내위치랑 같아지면
					break			// 멈추고 와일 나가기
				}
			}
		// 첨에 생각한와일 e
		
			document.getElementById('엘베위치').innerHTML = 엘베위치 - count + '층'
		}, 1 * 1000) 
		// 시작시간을 엘베 위치 5에서 내 위치 2까지로 어떻게넣음...?????
	} 
	
	document.getElementById('내위치').innerHTML = 내위치 + '층'
}

*/
