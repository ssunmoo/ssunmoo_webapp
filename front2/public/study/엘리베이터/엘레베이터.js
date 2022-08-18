/*
elevator algorithm

엘레베이터 구동하기
현재위치에서 상승 하강하기

프론트에 상승버튼,
하강버튼 누르기

엘리베이터 위치와 내위치가 달랐을때
상승 하강 눌렀을때 만나도록
 */




let 내위치 = Number(prompt('내위치 입력:'))
let 현재엘베층수 = Number(prompt('엘베위치 입력:'))

function 상승(){	// 상승 버튼을 눌렀을때 층수가 1개씩 올라간다
	// 상승버튼을 눌렀을때 엘베위치 값이 내 위치 값까지 내려올때까지 반복
	if( 현재엘베층수 > 내위치 ){
		현재엘베층수--
	}else{
		return
	}
		document.getElementById('엘베위치').innerHTML = 현재엘베층수;
		document.getElementById('내위치').innerHTML = 내위치;	
}

function 하강(){	// 하강 버튼을 눌렀을때 층수가 1개씩 내려간다
	if(현재엘베층수 < 내위치){
		현재엘베층수++	
	}else{
		return
	}
	document.getElementById('엘베위치').innerHTML = 현재엘베층수;
	document.getElementById('내위치').innerHTML = 내위치;
}


/*

if(현재엘베층수 < 내위치){
	for(i = 현재엘베층수; i < 내위치; i++){
		setTimeout(상승(), 1 * 1000)}
	}
*/	


// + 온클릭을 눌렀을때 if값을 밖으로 빼서 그안에 펑션이 작동하게?



// 현재엘베층수 < 내위치가 낮으면 현재엘베층수가 내려가
// 현재엘베층수 > 내위치가 높으면 현재엘베층수가 올라가
	
	
	
	
	
	
/*

function 상승(){	// 상승 버튼을 눌렀을때 층수가 1개씩 올라간다
	if( 층수 < 10 ){
		층수++
	}else{
		return
	}
	document.getElementById('엘베위치').innerHTML = 층수;	
	document.getElementById('내위치').innerHTML = 층수;
}

function 하강(){	// 하강 버튼을 눌렀을때 층수가 1개씩 내려간다
	if(층수 > 1){
		층수--	
	}else{
		return
	}
	
	document.getElementById('엘베위치').innerHTML = 층수;
	document.getElementById('내위치').innerHTML = 층수;
}

*/