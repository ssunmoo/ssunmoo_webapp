/*

	1. 로또 시작하기 버튼을 눌렀을때 로또 버튼 45개 출력
	2. 45개 버튼 중 선택한 번호가 누적되어 출력되도록
	3. 중복 숫자는 누를 수 없음
	4. 6개까지만 선택 가능
		- 번호 추첨
	5. 당첨번호 6개가 랜덤으로 출력되도록(6개 한번에, 6개 까지만)
	6. 중복 숫자는 출력될 수 없음
	7. 내가 선택한 번호와 추첨된 번호 비교
	8. 당첨된 번호가 어떤 것인지 출력
	9. 당첨자 발표(1등. 22억! 2등. 3천만원! 3등. 100만원 4등. 5만원 5등. 5천원 꽝!)

*/


let select_box = [];
let com_select_box = [];


function btn_create() {
	
	let btn_box ='';
	for ( let i = 1; i < 46; i++ ){
		btn_box += `<button id = ${i} onclick = btn_select(${i})> ${i} </button>`
		if( i % 5 == 0){
			btn_box += `<br>`
		}
	}
	document.getElementById('btn_box').innerHTML = btn_box
} // 함수 종료


function btn_select( i ) {
	if ( select_box.length < 6 ){	
		select_box.push( i )
	}	// if 종료
	else {
		alert("더 이상 선택할 수 없습니다.")
		return;
	} // else 종료
	document.getElementById('select_box').innerHTML = select_box
} // 함수 종료




function com_select(){
	if( select_box.length < 6 ) {
		alert("번호를 6개 모두 선택해주세요")
	}
	
	else {
		while( com_select_box.length < 6 ){	
			let random = Math.floor(Math.random()*45+1);
			com_select_box.push( random )
			continue;
		} // while 종료
		com_select_box.sort();
	}
	document.getElementById('draw_box').innerHTML = com_select_box
} // 함수 종료




function lotto_result() {

/*	
	let count = 0;
	// let result_number = [];
	if ( select_box.indexOf( com_select_box ) ){

	}
*/

	let count = 0;
	
	let result_num = select_box.filter( ( i ) => {
		com_select_box.includes( i )
		return;	
		
	})
	
	count = result_num.length;
	
	console.log( select_box )
	console.log( com_select_box )
	console.log( result_num )
	
	
	if( count == 6 ) {
		alert( `[1등] 6개 맞았습니다! 당첨금액 : 22억원 ${result_num}` )
	}
	else if( count == 5 ) {
		alert( `[2등] 5개 맞았습니다! 당첨금액 : 3천만원 ${result_num}` )
	}
	else if( count == 4 ) {
		alert( `[3등] 4개 맞았습니다! 당첨금액 : 5만원 ${result_num}` )
	}
	else if( count == 3 ) {
		alert( `[4등] 3개 맞았습니다! 당첨금액 : 5천원 ${result_num}` )
	}
	else if( count == 2 ) {
		alert( `[꽝] 2개 맞았습니다 ${result_num}` )
	}
	else if( count == 1 ) {
		alert( `[꽝] 1개 맞았습니다 ${result_num}` )
	}
	else if( count == 0 ) {
		alert( "[꽝]")
	}
}// 함수종료









