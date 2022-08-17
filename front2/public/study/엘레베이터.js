/*
elevator algorithm

엘레베이터 구동하기
현재위치에서 상승 하강하기

프론트에 상승버튼,
하강버튼 누르기

엘리베이터 위치와 내위치가 달랐을때
상승 하강 눌렀을때 만나도록


 */
 
let output = []
// 층수를 출력할때 배열로 출력할래

/*

// btn_up 을 눌렀을때 층수 하나씩 올라가야하니까 1개씩 더해지게 해줘.....
// 숫자니까 배열로 만들고싶다..

	for(let i = 1; i <= 10; i++){
		
		btn_up += i
		
	document.getElementById('output').innerHTML = btn_up;	
	}


// btn_down 을 눌렀을때 1개씩 빼지게 해줘.....
	for(let j = 10; j <= 1; i--){
		
		btn_down += j
	}


*/

 
 
 
 function btn_print(){
	
	let btnlist = '' // 엘리베이터 층수인 1부터 10층까지의 버튼을 저장할 변수 선언
		for(let i = 1; i <= 10; i++){
			// 1부터 10까지 1씩 증가해서 만들어줘
		btnlist += `<button id=${i} onclick=btn_click(${i})> ${i} </button>`
		if(i % 2 == 0){
			btnlist += '<br>'
		}
		}
		document.getElementById('btnbox').innerHTML = btnlist;
}


 
 
 
 
 
 
 
 
 
 